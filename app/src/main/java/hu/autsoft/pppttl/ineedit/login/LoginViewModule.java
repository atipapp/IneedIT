package hu.autsoft.pppttl.ineedit.login;

import dagger.Binds;
import dagger.Module;


/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public abstract class LoginViewModule {
    @Binds
    @SuppressWarnings("unused")
    abstract LoginContract.LoginView provideLoginView(LoginActivity loginActivity);
}
