package hu.autsoft.pppttl.ineedit.Login;

import dagger.Binds;
import dagger.Module;


/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public abstract class LoginViewModule {
    @Binds
    abstract LoginView provideLoginView(LoginActivity loginActivity);
}
