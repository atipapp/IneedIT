package hu.autsoft.pppttl.ineedit.requestdetails;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public abstract class RequestDetailsViewModule {
    @Binds
    abstract RequestDetailsContract.RequestDetailsView provideRequestDetailsView(RequestDetailsActivity requestDetailsActivity);
}
