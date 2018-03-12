package hu.autsoft.pppttl.ineedit.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class LoginModule {

    @Provides
    LoginContract.LoginPresenter provideLoginPresenter(LoginContract.LoginView view) {
        return new LoginPresenterImpl(view);
    }
}
