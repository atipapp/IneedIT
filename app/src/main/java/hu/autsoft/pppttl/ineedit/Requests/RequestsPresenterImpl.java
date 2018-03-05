package hu.autsoft.pppttl.ineedit.Requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsPresenterImpl implements RequestsPresenter {
    RequestsView view;
    RequestsInteractor interactor;

    public RequestsPresenterImpl(RequestsView view) {
        this.view = view;
        this.interactor = new RequestsInteractorImpl(this);
    }

    public RequestsPresenterImpl(RequestsView view, RequestsInteractor interactor) {
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
}
