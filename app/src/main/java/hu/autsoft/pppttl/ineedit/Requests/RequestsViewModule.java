package hu.autsoft.pppttl.ineedit.Requests;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public abstract class RequestsViewModule {
    @Binds
    abstract RequestsView provideRequestsView(RequestsActivity requestsActivity);
}
