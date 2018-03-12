package hu.autsoft.pppttl.ineedit.login;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}