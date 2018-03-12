package hu.autsoft.pppttl.ineedit.requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public interface RequestsInteractor {
    void saveRequest(Request request);

    List<Request> getRequests();
}
