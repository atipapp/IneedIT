package hu.autsoft.pppttl.ineedit.RequestDetails;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestDetailsPresenterImpl implements RequestDetailsPresenter {
    RequestDetailsView view;
    RequestDetailsInteractor interactor;

    public RequestDetailsPresenterImpl(RequestDetailsView view, String requestID) {
        this.view = view;
        this.interactor = new RequestDetailsInteractorImpl(this, requestID);
    }

    public Request getRequest() {
        return interactor.getRequest();
    }

    @Override
    public void updateUI() {
        view.updateUI();
    }
}
