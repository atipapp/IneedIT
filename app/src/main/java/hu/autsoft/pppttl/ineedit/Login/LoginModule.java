package hu.autsoft.pppttl.ineedit.Login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class LoginModule {

    @Provides
    LoginPresenter provideLoginPresenter(LoginView view) {
        return new LoginPresenterImpl(view);
    }
}