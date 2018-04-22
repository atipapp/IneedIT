package hu.autsoft.pppttl.ineedit.fcm;


import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


/**
 * Created by pppttl on 2018. 04. 22..
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage message) {
        if (message != null) {
            String title = message.getNotification().getTitle();
            String messageText = message.getNotification().getBody();
            NotificationHelper notificationHelper = new NotificationHelper(this);
            notificationHelper.sendRequestNotification(title, messageText);
        }
    }



}
