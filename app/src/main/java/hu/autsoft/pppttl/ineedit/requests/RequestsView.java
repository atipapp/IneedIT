package hu.autsoft.pppttl.ineedit.requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;

/**
 * Created by pppttl on 2018. 02. 27..
 */

public interface RequestsView {
    void navigateToRequest(String requestID);

    void onRequestDataChanged(List<Request> requests);
}
