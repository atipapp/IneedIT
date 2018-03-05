package hu.autsoft.pppttl.ineedit.Requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 02. 27..
 */

public interface RequestsView {
    void navigateToRequest(String requestID);

    void onRequestDataChanged(List<Request> requests);
}
