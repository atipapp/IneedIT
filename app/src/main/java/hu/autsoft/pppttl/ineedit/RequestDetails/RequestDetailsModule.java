package hu.autsoft.pppttl.ineedit.RequestDetails;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class RequestDetailsModule {

    @Provides
    RequestDetailsPresenter provideRequestDetailsPresenter(RequestDetailsView view) {
        String requestID = view.getSelectedRequestId();
        return new RequestDetailsPresenterImpl(view, requestID);
    }

    @Provides
    CommentRecyclerViewAdapter provideCommentRecyclerViewAdapter() {
        return new CommentRecyclerViewAdapter();
    }
}
