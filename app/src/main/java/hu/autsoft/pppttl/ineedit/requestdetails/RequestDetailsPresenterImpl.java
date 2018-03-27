package hu.autsoft.pppttl.ineedit.requestdetails;

import javax.inject.Inject;

import hu.autsoft.pppttl.ineedit.model.Comment;
import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestDetailsPresenterImpl extends BasePresenter<RequestDetailsContract.RequestDetailsView>
        implements RequestDetailsContract.RequestDetailsPresenter {

    @Inject
    RequestDetailsContract.RequestDetailsInteractor interactor;

    public RequestDetailsPresenterImpl(RequestDetailsContract.RequestDetailsView view, RequestDetailsContract.RequestDetailsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
        interactor.setPresenter(this);
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
    public String getUserEmail() {
        return interactor.getUserEmail();
    }

    @Override
    public void sendComment(Comment comment) {
        interactor.sendComment(comment);
    }

    @Override
    public void closeUI() {
        view.closeUI();
    }

    @Override
    public String getSelectedRequestId() {
        return view.getSelectedRequestId();
    }
}
