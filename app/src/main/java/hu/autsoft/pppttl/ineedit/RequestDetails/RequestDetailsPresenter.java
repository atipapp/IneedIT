package hu.autsoft.pppttl.ineedit.RequestDetails;

import hu.autsoft.pppttl.ineedit.Model.Comment;
import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public interface RequestDetailsPresenter {

    Request getRequest();

    void updateUI();

    void updateRequest(Request request);

    String getUserID();

    void sendComment(Comment comment);

    void closeUI();
}
