package hu.autsoft.pppttl.ineedit.requestcreateoredit;

import hu.autsoft.pppttl.ineedit.model.Request;

/**
 * Created by pppttl on 2018. 02. 27..
 */

public interface SaveRequestCallbackListener {
    void onRequestSave(Request request);
}
