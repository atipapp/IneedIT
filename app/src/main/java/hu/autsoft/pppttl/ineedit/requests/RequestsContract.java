package hu.autsoft.pppttl.ineedit.requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;

/**
 * Created by pppttl on 2018. 03. 12..
 */

public interface RequestsContract {

    interface RequestsInteractor {
        void saveRequest(Request request);

        List<Request> getRequests();

        String getCurrentUsername();

        String getCurrentUserEmail();

        void setPresenter(RequestsPresenter presenter);

        String getCurrentUID();

        void logout();
    }

    interface RequestsPresenter {
        void saveRequest(Request request);

        List<Request> getRequests();

        void onRequestDataChanged();

        String getCurrentUsername();

        String getCurrentUserEmail();

        String getCurrentUID();

        void logout();
    }

    interface RequestsView {
        void navigateToRequest(String requestID);

        void onRequestDataChanged(List<Request> requests);
    }
}
