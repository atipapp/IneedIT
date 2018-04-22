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

exports.sendStatusChangeNotification = functions.database.ref('/requests/{requestID}')
    .onUpdate((change, context) => {

        const requestID = context.params.requestID;
        const userID = change.after._data.userID;        

        console.log(requestID, ' status changed');
        console.log(userID, ' is the userID');

        // Get the list of device notification tokens.
        const getDeviceTokensPromise = admin.database().ref(`/users/${userID}/notificationTokens`).once('value');
        
        // The snapshot to the user's tokens.
        let tokensSnapshot;

        // The array containing all the user's tokens.
        let tokens;

        if (change.before._data.status === change.after._data.status){
            return console.log('The status was not changed. Ignoring.');
        }

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
                    body: `${change.after._data.name} is now ${change.after._data.status}.`
                }
            };            
               
            tokens = tokensSnapshot.val(); //Not an array. Array doesn't work for some reason

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