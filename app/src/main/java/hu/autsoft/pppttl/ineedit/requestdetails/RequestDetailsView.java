package hu.autsoft.pppttl.ineedit.requestdetails;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public interface RequestDetailsView {

    void updateUI();

    void closeUI();

    String getSelectedRequestId();
}
