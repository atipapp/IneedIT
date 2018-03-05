package hu.autsoft.pppttl.ineedit.Requests;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public interface SaveRequestCallbackListener {
    void onRequestSave(Request request);
}
