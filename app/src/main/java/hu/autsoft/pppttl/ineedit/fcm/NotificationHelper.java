package hu.autsoft.pppttl.ineedit.fcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.login.LoginActivity;

/**
 * Created by pppttl on 2018. 04. 22..
 */
public class NotificationHelper extends ContextWrapper {

    private NotificationManager notifManager;
    public static final String CHANNEL_ONE_ID = "hu.autsoft.pppttl.ineedit.fcm.ONE";
    public static final String CHANNEL_ONE_NAME = "Request status changed";
    public static final String CHANNEL_TWO_ID = "hu.autsoft.pppttl.ineedit.fcm.TWO";
    public static final String CHANNEL_TWO_NAME = "New comment on a request";

    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }

    public void sendRequestNotification(String title, String message) {
        getManager().notify(0, getRequestNotificationBuilder(title, message).build());
    }

    public void sendCommentNotification(String title, String message) {
        getManager().notify(0, getCommentNotificationBuilder(title, message).build());
    }

    private void createChannels() {
        if (!shouldUseLegacyNotification()) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ONE_ID,
                    CHANNEL_ONE_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            getManager().createNotificationChannel(notificationChannel);

            NotificationChannel notificationChannel2 = new NotificationChannel(CHANNEL_TWO_ID,
                    CHANNEL_TWO_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel2.enableLights(false);
            notificationChannel2.enableVibration(true);
            notificationChannel2.setLightColor(Color.YELLOW);
            notificationChannel2.setShowBadge(false);
            getManager().createNotificationChannel(notificationChannel2);
        }
    }

    private NotificationManager getManager() {
        if (notifManager == null) {
            notifManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return notifManager;
    }

    private NotificationCompat.Builder getRequestNotificationBuilder(String title, String body) {
        if (!shouldUseLegacyNotification()) {

            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

            return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ONE_ID)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(R.drawable.ic_requests_accepted)
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);
        } else {
            return buildLegacyNotification(title, body);
        }
    }

    private NotificationCompat.Builder getCommentNotificationBuilder(String title, String body) {
        if (!shouldUseLegacyNotification()) {
            return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_TWO_ID)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(R.drawable.ic_email_black_24dp)
                    .setAutoCancel(true);
        } else {
            return buildLegacyNotification(title, body);
        }
    }

    private boolean shouldUseLegacyNotification() {
        return android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.O;
    }

    @SuppressWarnings("deprecation")
    private NotificationCompat.Builder buildLegacyNotification(String title, String message) {
        if (shouldUseLegacyNotification()) {
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent);

            return notificationBuilder;
        } else {
            return null;
        }
    }
}