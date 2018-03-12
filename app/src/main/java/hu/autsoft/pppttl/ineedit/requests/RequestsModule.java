package hu.autsoft.pppttl.ineedit.requests;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class RequestsModule {
    @Provides
    RequestsContract.RequestsPresenter provideRequestsPresenter(RequestsContract.RequestsView view) {
        return new RequestsPresenterImpl(view);
    }

    @Provides
    RequestRecyclerViewAdapter provideRequestsRecyclerViewAdapter(RequestsContract.RequestsView view) {
        return new RequestRecyclerViewAdapter(view);
    }
}
