package hu.autsoft.pppttl.ineedit.RequestCreateOrEdit;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 02. 27..
 */

public interface SaveRequestCallbackListener {
    void onRequestSave(Request request);
}
