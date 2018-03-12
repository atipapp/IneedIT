package hu.autsoft.pppttl.ineedit.requests;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import hu.autsoft.pppttl.ineedit.model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsInteractorImpl implements RequestsContract.RequestsInteractor {
    public static final String CHILD_NAME = "requests";

    private final RequestsContract.RequestsPresenter presenter;

    private List<Request> requests = new ArrayList<>();
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    ;

    public RequestsInteractorImpl(RequestsContract.RequestsPresenter newPresenter) {
        this.presenter = newPresenter;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        databaseReference.child(CHILD_NAME).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> newRequests = dataSnapshot.getChildren();
                requests.clear();
                for (DataSnapshot child : newRequests) {
                    Request request = child.getValue(Request.class);
                    request.setRequestID(child.getKey());
                    requests.add(request);
                }

                presenter.onRequestDataChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void saveRequest(Request request) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        request.setUserID(currentUser.getUid());
        databaseReference.child(CHILD_NAME).push().setValue(request);
    }

    @Override
    public List<Request> getRequests() {
        List<Request> currUserRequests = new ArrayList<>();

        if (currentUser != null) {
            for (Request request : this.requests) {
                if (request.getUserID().equals(currentUser.getUid())) {
                    currUserRequests.add(request);
                }

            }
        }

        return currUserRequests;
    }
}
