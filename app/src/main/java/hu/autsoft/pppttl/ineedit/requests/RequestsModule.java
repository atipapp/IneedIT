package hu.autsoft.pppttl.ineedit.requests;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class RequestsModule {
    @Provides
    RequestsContract.RequestsPresenter provideRequestsPresenter(RequestsContract.RequestsView view, RequestsContract.RequestsInteractor interactor) {
        return new RequestsPresenterImpl(view, interactor);
    }

    @Provides
    RequestRecyclerViewAdapter provideRequestsRecyclerViewAdapter(RequestsContract.RequestsView view) {
        return new RequestRecyclerViewAdapter(view);
    }

    @Provides
    RequestsContract.RequestsInteractor provideRequestsInteractor() {
        return new RequestsInteractorImpl();
    }
}
