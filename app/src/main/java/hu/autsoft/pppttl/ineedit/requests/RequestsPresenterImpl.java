package hu.autsoft.pppttl.ineedit.requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsPresenterImpl extends BasePresenter<RequestsContract.RequestsView, RequestsContract.RequestsInteractor>
        implements RequestsContract.RequestsPresenter {

    public RequestsPresenterImpl(RequestsContract.RequestsView view) {
        attachView(view);
        attachInteractor(new RequestsInteractorImpl(this));
    }

    public RequestsPresenterImpl(RequestsContract.RequestsView view, RequestsContract.RequestsInteractor interactor) {
        //Only for unit tests
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void saveRequest(Request request) {
        interactor.saveRequest(request);
    }

    @Override
    public List<Request> getRequests() {
        return interactor.getRequests();
    }

    @Override
    public void onRequestDataChanged() {
        view.onRequestDataChanged(interactor.getRequests());
    }

    @Override
    public String getCurrentUsername() {
        return interactor.getCurrentUsername();
    }

    @Override
    public String getCurrentUserEmail() {
        return interactor.getCurrentUserEmail();
    }
}
