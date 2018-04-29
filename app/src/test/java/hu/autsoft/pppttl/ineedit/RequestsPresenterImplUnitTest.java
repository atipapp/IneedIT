package hu.autsoft.pppttl.ineedit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.requests.RequestsContract;
import hu.autsoft.pppttl.ineedit.requests.RequestsPresenterImpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsPresenterImplUnitTest {
    @Mock
    RequestsContract.RequestsView view;

    @Mock
    RequestsContract.RequestsInteractor interactor;

    @Mock
    Request request;

    @Mock
    List<Request> requests;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private RequestsPresenterImpl presenter;

    @Before
    public void setUp() {
        presenter = new RequestsPresenterImpl(view, interactor);
    }

    @Test
    public void saveRequestTest() {
        presenter.saveRequest(request);

        verify(interactor).saveRequest(request);
    }

    @Test
    public void getRequestsTest() {
        presenter.getRequests();

        verify(interactor).getRequests();
    }

    @Test
    public void onRequestDataChangedTest() {
        when(interactor.getRequests()).thenReturn(requests);
        presenter.onRequestDataChanged();

        verify(interactor).getRequests();
        verify(view).onRequestDataChanged(requests);
    }

    @Test
    public void getCurrentUsernameTest() {
        presenter.getCurrentUsername();

        verify(interactor).getCurrentUsername();
    }

    @Test
    public void getCurrentUserEmailTest() {
        presenter.getCurrentUserEmail();

        verify(interactor).getCurrentUserEmail();
    }

    @Test
    public void getCurrentUIDTest() {
        presenter.getCurrentUID();

        verify(interactor).getCurrentUID();
    }

    @Test
    public void logoutTest() {
        presenter.logout();

        verify(interactor).logout();
    }
}
