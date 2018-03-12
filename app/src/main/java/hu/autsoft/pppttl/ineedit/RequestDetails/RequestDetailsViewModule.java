package hu.autsoft.pppttl.ineedit.RequestDetails;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public abstract class RequestDetailsViewModule {
    @Binds
    abstract RequestDetailsView provideRequestDetailsView(RequestDetailsActivity requestDetailsActivity);
}
