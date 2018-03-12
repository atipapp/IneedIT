package hu.autsoft.pppttl.ineedit;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import hu.autsoft.pppttl.ineedit.login.LoginInteractor;
import hu.autsoft.pppttl.ineedit.login.LoginPresenterImpl;
import hu.autsoft.pppttl.ineedit.login.LoginView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pppttl on 2018. 03. 03..
 */

public class LoginPresenterImplUnitTest {
    @Mock
    LoginView loginView;
    @Mock
    LoginInteractor loginInteractor;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    private static final String FAKE_USERNAME = "email@email.com";
    private static final String FAKE_PASSWORD = "123456";

    @Test
    public void validateCredentialsTest() {
        LoginPresenterImpl presenter = new LoginPresenterImpl(loginView, loginInteractor);
        presenter.validateCredentials(FAKE_USERNAME, FAKE_PASSWORD);

        verify(loginView).showProgress();
        verify(loginInteractor).login(FAKE_USERNAME, FAKE_PASSWORD, presenter);
    }

    @Test
    public void autoLoginTest_NotLoggedIn() {
        LoginPresenterImpl presenter = new LoginPresenterImpl(loginView, loginInteractor);
        presenter.autoLogin();

        when(loginInteractor.isLoggedIn()).thenReturn(false);
        verify(loginInteractor).isLoggedIn();
    }

    @Test
    public void autoLoginTest_LoggedIn() {
        LoginPresenterImpl presenter = new LoginPresenterImpl(loginView, loginInteractor);
        presenter.autoLogin();

        when(loginInteractor.isLoggedIn()).thenReturn(true);
        verify(loginInteractor).isLoggedIn();
    }

    @Test
    public void onUsernameErrorTest() {
        LoginPresenterImpl presenter = new LoginPresenterImpl(loginView, loginInteractor);
        presenter.onUsernameError();

        verify(loginView).setUsernameError();
        verify(loginView).hideProgress();
    }

    @Test
    public void onPasswordErrorTest() {
        LoginPresenterImpl presenter = new LoginPresenterImpl(loginView, loginInteractor);
        presenter.onPasswordError();

        verify(loginView).setPasswordError();
        verify(loginView).hideProgress();
    }

    @Test
    public void onSuccessTest() {
        LoginPresenterImpl presenter = new LoginPresenterImpl(loginView, loginInteractor);
        presenter.onSuccess();

        verify(loginView).navigateToHome();
    }
}
