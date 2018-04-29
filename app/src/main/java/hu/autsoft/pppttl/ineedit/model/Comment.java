package hu.autsoft.pppttl.ineedit.model;

import java.util.Calendar;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by pppttl on 2018. 03. 07..
 */
@Data
@Getter
@Setter
public class Comment {
    private String userEmail;
    private String message;
    private long createdAt;

    @SuppressWarnings("unused")
    public Comment() {
        //Required by ORM
    }

    public Comment(String userID, String message) {
        this.userEmail = userID;
        this.message = message;

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        this.createdAt = today.getTimeInMillis();
    }
}
