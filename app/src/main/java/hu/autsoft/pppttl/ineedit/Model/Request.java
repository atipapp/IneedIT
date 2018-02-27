package hu.autsoft.pppttl.ineedit.Model;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class Request {
    private String name;
    private Status status;

    public enum Status{
        PENDING,
        ACCEPTED,
        DENIED
    }

    public Request(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public Request() {
        name = "Default";
        this.status=Status.PENDING;
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
}
