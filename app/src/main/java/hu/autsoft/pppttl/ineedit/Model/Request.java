package hu.autsoft.pppttl.ineedit.Model;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class Request {
    private String name;
    private Status status;
    private String link;
    private int price;

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
        this.name = "Default";
        this.status=Status.PENDING;
        this.link = "";
        this.price = 0;
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
}
