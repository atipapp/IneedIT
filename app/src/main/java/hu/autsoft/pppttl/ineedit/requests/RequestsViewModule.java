package hu.autsoft.pppttl.ineedit.requests;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public abstract class RequestsViewModule {
    @Binds
    @SuppressWarnings("unused")
    abstract RequestsContract.RequestsView provideRequestsView(RequestsActivity requestsActivity);
}
