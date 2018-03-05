package hu.autsoft.pppttl.ineedit.Requests;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsPresenterImpl implements RequestsPresenter {
    RequestsView view;
    RequestsInteractor interactor;

    public RequestsPresenterImpl(RequestsView view, RequestsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void saveRequest(Request request) {
        interactor.saveRequest(request);
    }
}
