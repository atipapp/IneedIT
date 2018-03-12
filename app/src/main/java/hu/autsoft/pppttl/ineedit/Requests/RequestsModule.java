package hu.autsoft.pppttl.ineedit.Requests;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class RequestsModule {
    @Provides
    RequestsPresenter provideRequestsPresenter(RequestsView view) {
        return new RequestsPresenterImpl(view);
    }

    @Provides
    RequestRecyclerViewAdapter provideRequestsRecyclerViewAdapter(RequestsView view) {
        return new RequestRecyclerViewAdapter(view);
    }
}
