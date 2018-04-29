package hu.autsoft.pppttl.ineedit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import hu.autsoft.pppttl.ineedit.model.User;
import hu.autsoft.pppttl.ineedit.profile.ProfileContract;
import hu.autsoft.pppttl.ineedit.profile.ProfilePresenterImpl;

import static org.mockito.Mockito.verify;

/**
 * Created by pppttl on 2018. 04. 29..
 */
public class ProfilePresenterImplUnitTest {
    @Mock
    ProfileContract.ProfileView view;
    @Mock
    ProfileContract.ProfileInteractor interactor;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private ProfilePresenterImpl presenter;

    @Before
    public void setUp() {
        presenter = new ProfilePresenterImpl(view, interactor);
    }

    @Test
    public void getUserTest() {
        String FAKE_USER_ID = "ABCxyz123";
        presenter.getUser(FAKE_USER_ID);

        verify(interactor).getUser(FAKE_USER_ID);
    }

    @Test
    public void saveUserTest() {
        User fakeUser = new User();
        presenter.saveUser(fakeUser);

        verify(interactor).saveUser(fakeUser);
    }

    @Test
    public void subscribeToUserTest() {
        String FAKE_USER_ID = "ABCxyz123";
        presenter.subscribeToUser(FAKE_USER_ID);

        verify(interactor).subscribeToUser(FAKE_USER_ID);
    }

    @Test
    public void closeUITest() {
        presenter.closeUI();

        verify(view).closeUI();
    }

    @Test
    public void updateUITest() {
        presenter.updateUI();

        verify(view).updateUI();
    }

    @Test
    public void getSelectedUserIdTest() {
        presenter.getSelectedUserId();

        verify(view).getSelectedUserId();
    }
}
