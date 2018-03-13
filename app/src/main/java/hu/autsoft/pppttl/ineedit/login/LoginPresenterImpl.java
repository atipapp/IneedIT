package hu.autsoft.pppttl.ineedit.login;

import javax.inject.Inject;

import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class LoginPresenterImpl extends BasePresenter<LoginContract.LoginView>
        implements LoginContract.LoginPresenter, LoginContract.LoginInteractor.OnLoginFinishedListener {

    @Inject
    LoginContract.LoginInteractor interactor;

    public LoginPresenterImpl(LoginContract.LoginView view, LoginContract.LoginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
    }

    @Override public void validateCredentials(String username, String password) {
        if (view != null) {
            view.showProgress();
        }

        if (interactor != null) interactor.login(username, password, this);
    }

    @Override
    public void autoLogin() {
        if (interactor != null)
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
