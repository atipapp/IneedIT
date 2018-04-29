package hu.autsoft.pppttl.ineedit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import hu.autsoft.pppttl.ineedit.model.Comment;
import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.requestdetails.RequestDetailsContract;
import hu.autsoft.pppttl.ineedit.requestdetails.RequestDetailsPresenterImpl;

import static org.mockito.Mockito.verify;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestDetailsPresenterImplUnitTest {
    @Mock
    RequestDetailsContract.RequestDetailsInteractor interactor;

    @Mock
    RequestDetailsContract.RequestDetailsView view;

    @Mock
    Request request;

    @Mock
    Comment comment;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private RequestDetailsPresenterImpl presenter;

    @Before
    public void setUp() {
        presenter = new RequestDetailsPresenterImpl(view, interactor);
    }

    @Test
    public void getRequestTest() {
        presenter.getRequest();

        verify(interactor).getRequest();
    }

    @Test
    public void updateUITest() {
        presenter.updateUI();

        verify(view).updateUI();
    }

    @Test
    public void updateRequestTest() {
        presenter.updateRequest(request);

        verify(interactor).updateRequest(request);
    }

    @Test
    public void getUserEmailTest() {
        presenter.getUserEmail();

        verify(interactor).getUserEmail();
    }

    @Test
    public void sendCommentTest() {
        presenter.sendComment(comment);

        verify(interactor).sendComment(comment);
    }

    @Test
    public void closeUITest() {
        presenter.closeUI();

        verify(view).closeUI();
    }

    @Test
    public void getSelectedRequestIdTest() {
        presenter.getSelectedRequestId();

        verify(view).getSelectedRequestId();
    }

    @Test
    public void isCurrentUserAdmin() {
        presenter.isCurrentUserAdmin();

        verify(interactor).isCurrentUserAdmin();
    }
}
