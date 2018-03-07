package hu.autsoft.pppttl.ineedit.RequestDetails;

import hu.autsoft.pppttl.ineedit.Model.Comment;
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

    public RequestDetailsPresenterImpl(RequestDetailsView view, RequestDetailsInteractor interactor) {
        //Only for testing
        this.view = view;
        this.interactor = interactor;
    }

    public Request getRequest() {
        return interactor.getRequest();
    }

    @Override
    public void updateUI() {
        view.updateUI();
    }

    @Override
    public void updateRequest(Request request) {
        interactor.updateRequest(request);
    }

    @Override
    public String getUserID() {
        return interactor.getUserID();
    }

    @Override
    public void sendComment(Comment comment) {
        interactor.sendComment(comment);
    }

    @Override
    public void closeUI() {
        view.closeUI();
    }
}
