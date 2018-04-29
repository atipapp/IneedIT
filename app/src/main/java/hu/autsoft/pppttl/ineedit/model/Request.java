package hu.autsoft.pppttl.ineedit.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by pppttl on 2018. 02. 26..
 */

@Data
@Getter
@Setter
public class Request {
    private String name;
    private Status status;
    private String link;
    private int price;
    private String userID;
    private String issuerEmail;
    private String requestID;
    private List<Comment> comments;

    public enum Status {
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
        this.status = Status.PENDING;
        this.link = "";
        this.price = 0;
        this.comments = new ArrayList<>();
        this.issuerEmail = "";
    }

    public Request(Request request) {
        name = request.getName();
        status = request.getStatus();
        link = request.getLink();
        price = request.getPrice();
        userID = request.getUserID();
        requestID = request.getRequestID();
        comments = request.getComments();
        issuerEmail = request.getIssuerEmail();
    }

    public int getStatusID() {
        if (status.equals(Status.ACCEPTED)) return 1;
        if (status.equals(Status.DENIED)) return 2;
        return 0;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
