package hu.autsoft.pppttl.ineedit.Requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public interface RequestsPresenter {
    void saveRequest(Request request);

    List<Request> getRequests();

    void onRequestDataChanged();
}
