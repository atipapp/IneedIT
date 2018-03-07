package hu.autsoft.pppttl.ineedit.Model;

import java.util.Calendar;

/**
 * Created by pppttl on 2018. 03. 07..
 */

public class Comment {
    private String userID;
    private String message;
    private long createdAt;

    public Comment() {
    }

    public Comment(String userID, String message, long createdAt) {
        this.userID = userID;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Comment(String userID, String message) {
        this.userID = userID;
        this.message = message;

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        this.createdAt = today.getTimeInMillis();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
