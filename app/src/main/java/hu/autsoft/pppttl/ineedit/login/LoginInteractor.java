package hu.autsoft.pppttl.ineedit.login;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

    boolean isLoggedIn();
}
