package hu.autsoft.pppttl.ineedit.Model;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class Request {
    private String name;
    private Status status;
    private String link;
    private int price;
    private String userID;
    private String requestID;

    public enum Status{
        PENDING,
        ACCEPTED,
        DENIED
    }

    public Request(String name, Status status, String link, int price) {
        this.name = name;
        this.status = status;
        this.link = link;
        this.price = price;
    }

    public Request() {
        this.name = "";
        this.status=Status.PENDING;
        this.link = "";
        this.price = 0;
    }

    public Request(Request request) {
        name = request.getName();
        status = request.getStatus();
        link = request.getLink();
        price = request.getPrice();
        userID = request.getUserID();
        requestID = request.getRequestID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }
}
