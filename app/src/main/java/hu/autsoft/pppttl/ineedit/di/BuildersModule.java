package hu.autsoft.pppttl.ineedit.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import hu.autsoft.pppttl.ineedit.login.LoginActivity;
import hu.autsoft.pppttl.ineedit.login.LoginModule;
import hu.autsoft.pppttl.ineedit.login.LoginViewModule;
import hu.autsoft.pppttl.ineedit.profile.ProfileActivity;
import hu.autsoft.pppttl.ineedit.profile.ProfileModule;
import hu.autsoft.pppttl.ineedit.profile.ProfileViewModule;
import hu.autsoft.pppttl.ineedit.requestdetails.RequestDetailsActivity;
import hu.autsoft.pppttl.ineedit.requestdetails.RequestDetailsModule;
import hu.autsoft.pppttl.ineedit.requestdetails.RequestDetailsViewModule;
import hu.autsoft.pppttl.ineedit.requests.RequestsActivity;
import hu.autsoft.pppttl.ineedit.requests.RequestsModule;
import hu.autsoft.pppttl.ineedit.requests.RequestsViewModule;

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

    @ContributesAndroidInjector(modules = {ProfileViewModule.class, ProfileModule.class})
    abstract ProfileActivity bindProfileActivity();
}
