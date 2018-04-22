package hu.autsoft.pppttl.ineedit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pppttl on 2018. 03. 27..
 */
public class User {
    private String uID;
    private String email;
    private String workEmail;
    private String phoneNumber;
    private String homeAddress;
    private String workAddress;
    private String fullName;
    private Boolean admin;
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

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean isAdmin() {
        return admin;
    }

    public List<String> getNotificationTokens() {
        return notificationTokens;
    }

    public void setNotificationTokens(List<String> notificationTokens) {
        this.notificationTokens = notificationTokens;
    }

    public void addNotificationToken(String notificationToken) {
        notificationTokens.add(notificationToken);
    }
}
