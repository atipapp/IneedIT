package hu.autsoft.pppttl.ineedit.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
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
}
