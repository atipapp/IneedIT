package hu.autsoft.pppttl.ineedit.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by pppttl on 2018. 03. 27..
 */
@Data
@Getter
@Setter
public class User {
    private String uID;
    private String email;
    private String workEmail;
    private String phoneNumber;
    private String homeAddress;
    private String workAddress;
    private String fullName;
    private boolean admin;
    private List<String> notificationTokens;

    public User() {
        uID = "";
        email = "n/a";
        workEmail = "n/a";
        phoneNumber = "n/a";
        homeAddress = "n/a";
        workAddress = "n/a";
        fullName = "n/a";
        admin = false;
        notificationTokens = new ArrayList<>();
    }

    public User(String uID, String email) {
        this.uID = uID;
        this.email = email;
        this.admin = false;
        notificationTokens = new ArrayList<>();
    }

    public void addNotificationToken(String notificationToken) {
        notificationTokens.add(notificationToken);
    }
}
