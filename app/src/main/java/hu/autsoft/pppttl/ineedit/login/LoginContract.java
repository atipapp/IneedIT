package hu.autsoft.pppttl.ineedit.login;

/**
 * Created by pppttl on 2018. 03. 12..
 */

public interface LoginContract {

    interface LoginInteractor {

        interface OnLoginFinishedListener {
            void onUsernameError();

            void onPasswordError();

            void onSuccess();
        }

        void login(String username, String password, OnLoginFinishedListener listener);

        boolean isLoggedIn();
    }

    interface LoginPresenter {
        void validateCredentials(String username, String password);

        void autoLogin();

        void onDestroy();
    }

    interface LoginView {
        void showProgress();

        void hideProgress();

        void setUsernameError();

        void setPasswordError();

        void navigateToHome();
    }
}
