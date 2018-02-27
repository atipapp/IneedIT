package hu.autsoft.pppttl.ineedit.Login;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void autoLogin();

    void onDestroy();
}
