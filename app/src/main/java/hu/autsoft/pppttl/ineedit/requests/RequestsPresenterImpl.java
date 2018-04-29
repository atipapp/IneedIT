package hu.autsoft.pppttl.ineedit.requests;

import java.util.List;

import javax.inject.Inject;

import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsPresenterImpl extends BasePresenter<RequestsContract.RequestsView>
        implements RequestsContract.RequestsPresenter {

    @Inject
    RequestsContract.RequestsInteractor interactor;

    public RequestsPresenterImpl(RequestsContract.RequestsView view, RequestsContract.RequestsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
        interactor.setPresenter(this);
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

    @Override
    public String getCurrentUID() {
        return interactor.getCurrentUID();
    }

    @Override
    public void logout() {
        interactor.logout();
    }
}
