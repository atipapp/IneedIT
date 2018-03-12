package hu.autsoft.pppttl.ineedit.requestdetails;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class RequestDetailsModule {

    @Provides
    RequestDetailsContract.RequestDetailsPresenter provideRequestDetailsPresenter(RequestDetailsContract.RequestDetailsView view) {
        String requestID = view.getSelectedRequestId();
        return new RequestDetailsPresenterImpl(view, requestID);
    }

    @Provides
    CommentRecyclerViewAdapter provideCommentRecyclerViewAdapter() {
        return new CommentRecyclerViewAdapter();
    }
}
