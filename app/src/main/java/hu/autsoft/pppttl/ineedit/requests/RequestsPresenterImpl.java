package hu.autsoft.pppttl.ineedit.requests;

import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsPresenterImpl extends BasePresenter<RequestsView, RequestsInteractor>
        implements RequestsPresenter {

    public RequestsPresenterImpl(RequestsView view) {
        attachView(view);
        attachInteractor(new RequestsInteractorImpl(this));
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
