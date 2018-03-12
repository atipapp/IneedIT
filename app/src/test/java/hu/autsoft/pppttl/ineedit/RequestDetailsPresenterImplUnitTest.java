package hu.autsoft.pppttl.ineedit;

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

    @Test
    public void getRequestTest() {
        RequestDetailsPresenterImpl presenter = new RequestDetailsPresenterImpl(view, interactor);
        presenter.getRequest();

        verify(interactor).getRequest();
    }

    @Test
    public void updateUITest() {
        RequestDetailsPresenterImpl presenter = new RequestDetailsPresenterImpl(view, interactor);
        presenter.updateUI();

        verify(view).updateUI();
    }

    @Test
    public void updateRequestTest() {
        RequestDetailsPresenterImpl presenter = new RequestDetailsPresenterImpl(view, interactor);
        presenter.updateRequest(request);

        verify(interactor).updateRequest(request);
    }

    @Test
    public void sendCommentTest() {
        RequestDetailsPresenterImpl presenter = new RequestDetailsPresenterImpl(view, interactor);
        presenter.sendComment(comment);

        verify(interactor).sendComment(comment);
    }

    @Test
    public void closeUITest() {
        RequestDetailsPresenterImpl presenter = new RequestDetailsPresenterImpl(view, interactor);
        presenter.closeUI();

        verify(view).closeUI();
    }
}
