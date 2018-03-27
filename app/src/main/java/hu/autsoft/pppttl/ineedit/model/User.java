package hu.autsoft.pppttl.ineedit.model;

/**
 * Created by pppttl on 2018. 03. 27..
 */
public class User {
    private String uID;
    private String email;

    public User(String uID, String email) {
        this.uID = uID;
        this.email = email;
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
}
