package hu.autsoft.pppttl.ineedit.login;

import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class LoginPresenterImpl extends BasePresenter<LoginView, LoginInteractor>
        implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    public LoginPresenterImpl(LoginView view) {
        attachView(view);
        attachInteractor(new LoginInteractorImpl());
    }

    @Override public void validateCredentials(String username, String password) {
        if (view != null) {
            view.showProgress();
        }

        interactor.login(username, password, this);
    }

    @Override
    public void autoLogin() {
        if (interactor.isLoggedIn()) {
            view.navigateToHome();
        }
    }

    @Override public void onDestroy() {
        view = null;
    }

    @Override public void onUsernameError() {
        if (view != null) {
            view.setUsernameError();
            view.hideProgress();
        }
    }

    @Override public void onPasswordError() {
        if (view != null) {
            view.setPasswordError();
            view.hideProgress();
        }
    }

    @Override public void onSuccess() {
        if (view != null) {
            view.navigateToHome();
        }
    }
}
