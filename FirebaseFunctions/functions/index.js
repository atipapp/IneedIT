const functions = require('firebase-functions');

// // Create and Deploy Your First Cloud Functions
// // https://firebase.google.com/docs/functions/write-firebase-functions
//
// exports.helloWorld = functions.https.onRequest((request, response) => {
//  response.send("Hello from Firebase!");
// });

'use strict';

const admin = require('firebase-admin');
admin.initializeApp();

exports.sendStatusChangeNotification = functions.database.ref('/requests/{requestID}/status')
    .onWrite((change, context) => {

        const requestID = context.params.requestID;

        console.log(requestID, ' status changed');
        // Get the request
        const request = admin.database().ref(`/requests/${requestID}`).once('value')
        const userID = request.userID;

        // Get the list of device notification tokens.
        const getDeviceTokensPromise = admin.database().ref(`/users/${userID}/notificationTokens`).once('value');
        
        // The snapshot to the user's tokens.
        let tokensSnapshot;

        // The array containing all the user's tokens.
        let tokens;

        return Promise.all([getDeviceTokensPromise]).then(results => {
            tokensSnapshot = results[0];

            if (!tokensSnapshot.hasChildren()) {
                return console.log('There are no notification tokens to send to.');
            }

            console.log('There are', tokensSnapshot.numChildren(), 'tokens to send notifications to.');

            // Notification details.
            const payload = {
                notification: {
                    title: 'Your request status has been updated!',
                    body: `${request.name} is now ${request.status}.`
                }
            };

            // Listing all tokens as an array.
            tokens = Object.keys(tokensSnapshot.val());
            // Send notifications to all tokens.
            return admin.messaging().sendToDevice(tokens, payload);
        }).then((response) => {
            // For each message check if there was an error.
            const tokensToRemove = [];

            response.results.forEach((result, index) => {
                const error = result.error;
                if (error) {
                  console.error('Failure sending notification to', tokens[index], error);
                  // Cleanup the tokens who are not registered anymore.
                  if (error.code === 'messaging/invalid-registration-token' ||
                      error.code === 'messaging/registration-token-not-registered') {
                    tokensToRemove.push(tokensSnapshot.ref.child(tokens[index]).remove());
                  }
                }
              });
              return Promise.all(tokensToRemove);
        });
    });