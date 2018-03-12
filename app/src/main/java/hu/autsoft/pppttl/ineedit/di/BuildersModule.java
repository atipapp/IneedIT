package hu.autsoft.pppttl.ineedit.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hu.autsoft.pppttl.ineedit.Login.LoginActivity;
import hu.autsoft.pppttl.ineedit.Login.LoginModule;
import hu.autsoft.pppttl.ineedit.Login.LoginViewModule;
import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsActivity;
import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsModule;
import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsViewModule;
import hu.autsoft.pppttl.ineedit.Requests.RequestsActivity;
import hu.autsoft.pppttl.ineedit.Requests.RequestsModule;
import hu.autsoft.pppttl.ineedit.Requests.RequestsViewModule;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = {RequestsViewModule.class, RequestsModule.class})
    abstract RequestsActivity bindRequestsActivity();

    @ContributesAndroidInjector(modules = {RequestDetailsViewModule.class, RequestDetailsModule.class})
    abstract RequestDetailsActivity bindRequestDetailsActivity();

    @ContributesAndroidInjector(modules = {LoginViewModule.class, LoginModule.class})
    abstract LoginActivity bindLoginActivity();
}
