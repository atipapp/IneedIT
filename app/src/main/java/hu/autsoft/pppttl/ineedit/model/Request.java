package hu.autsoft.pppttl.ineedit.model;

import java.util.ArrayList;
import java.util.List;

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
    private List<Comment> comments;

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
        this.comments = new ArrayList<>();
    }

    public Request() {
        this.name = "";
        this.status=Status.PENDING;
        this.link = "";
        this.price = 0;
        this.comments = new ArrayList<>();
    }

    public Request(Request request) {
        name = request.getName();
        status = request.getStatus();
        link = request.getLink();
        price = request.getPrice();
        userID = request.getUserID();
        requestID = request.getRequestID();
        this.comments = request.getComments();
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public int getStatusID() {
        if (status.equals(Status.ACCEPTED)) return 1;
        if (status.equals(Status.DENIED)) return 2;
        return 0;
    }
}
