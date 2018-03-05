package hu.autsoft.pppttl.ineedit;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsInteractor;
import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsPresenterImpl;
import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsView;

import static org.mockito.Mockito.verify;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestDetailsPresenterImplUnitTest {
    @Mock
    RequestDetailsInteractor interactor;

    @Mock
    RequestDetailsView view;

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
}
