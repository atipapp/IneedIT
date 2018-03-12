package hu.autsoft.pppttl.ineedit;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.requests.RequestsInteractor;
import hu.autsoft.pppttl.ineedit.requests.RequestsPresenterImpl;
import hu.autsoft.pppttl.ineedit.requests.RequestsView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsPresenterImplUnitTest {
    @Mock
    RequestsView view;

    @Mock
    RequestsInteractor interactor;

    @Mock
    Request request;

    @Mock
    List<Request> requests;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void saveRequestTest() {
        RequestsPresenterImpl presenter = new RequestsPresenterImpl(view, interactor);

        presenter.saveRequest(request);
        verify(interactor).saveRequest(request);
    }

    @Test
    public void getRequestsTest() {
        RequestsPresenterImpl presenter = new RequestsPresenterImpl(view, interactor);

        presenter.getRequests();
        verify(interactor).getRequests();
    }

    @Test
    public void onRequestDataChangedTest() {
        RequestsPresenterImpl presenter = new RequestsPresenterImpl(view, interactor);


        when(interactor.getRequests()).thenReturn(requests);
        presenter.onRequestDataChanged();

        verify(interactor).getRequests();
        verify(view).onRequestDataChanged(requests);
    }
}
