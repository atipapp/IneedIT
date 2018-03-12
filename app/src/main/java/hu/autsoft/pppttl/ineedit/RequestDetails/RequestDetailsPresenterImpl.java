package hu.autsoft.pppttl.ineedit.RequestDetails;

import hu.autsoft.pppttl.ineedit.Model.Comment;
import hu.autsoft.pppttl.ineedit.Model.Request;
import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestDetailsPresenterImpl extends BasePresenter<RequestDetailsView, RequestDetailsInteractor>
        implements RequestDetailsPresenter {

    public RequestDetailsPresenterImpl(RequestDetailsView view, String requestID) {
        attachView(view);
        attachInteractor(new RequestDetailsInteractorImpl(this, requestID));
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
