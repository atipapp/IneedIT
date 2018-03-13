package hu.autsoft.pppttl.ineedit.requestdetails;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import hu.autsoft.pppttl.ineedit.model.Comment;
import hu.autsoft.pppttl.ineedit.model.Request;
import hu.autsoft.pppttl.ineedit.requests.RequestsInteractorImpl;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestDetailsInteractorImpl implements RequestDetailsContract.RequestDetailsInteractor {
    private Request request = new Request();
    private RequestDetailsContract.RequestDetailsPresenter presenter;

    private void subscribeToRequest(String requestID) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        databaseReference.child(RequestsInteractorImpl.CHILD_NAME).child(requestID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                request = dataSnapshot.getValue(Request.class);
                if (request == null) {
                    if (presenter != null) presenter.closeUI();
                    return;
                }
                request.setRequestID(dataSnapshot.getKey());
                if (presenter != null) presenter.updateUI();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public Request getRequest() {
        return request;
    }

    @Override
    public void updateRequest(Request newRequest) {
        request = newRequest;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        databaseReference.child(RequestsInteractorImpl.CHILD_NAME).child(request.getRequestID()).setValue(request);
        if (presenter != null) presenter.updateUI();
    }

    @Override
    public String getUserID() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    @Override
    public void sendComment(Comment comment) {
        request.addComment(comment);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        databaseReference.child(RequestsInteractorImpl.CHILD_NAME).child(request.getRequestID()).setValue(request);
        if (presenter != null) presenter.updateUI();
    }

    @Override
    public void setPresenter(RequestDetailsContract.RequestDetailsPresenter presenter) {
        this.presenter = presenter;
        subscribeToRequest(presenter.getSelectedRequestId());
    }
}
