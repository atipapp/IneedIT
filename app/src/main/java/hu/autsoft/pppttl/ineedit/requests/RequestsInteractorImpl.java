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
import hu.autsoft.pppttl.ineedit.model.User;
import hu.autsoft.pppttl.ineedit.profile.ProfileInteractorImpl;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsInteractorImpl implements RequestsContract.RequestsInteractor {
    public static final String CHILD_NAME = "requests";

    private RequestsContract.RequestsPresenter presenter;

    private List<Request> requests = new ArrayList<>();
    private FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    private User userData;

    private void subscribeToRequests() {
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

                if (presenter != null) presenter.onRequestDataChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        DatabaseReference userdb = databaseReference.child(ProfileInteractorImpl.CHILD_NAME).child(currentUser.getUid());
        userdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                userData = dataSnapshot.getValue(User.class);
                if (presenter != null) presenter.onRequestDataChanged();
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

        if (userData != null && userData.isAdmin()) {
            return requests;
        }

        if (currentUser != null) {
            for (Request request : this.requests) {
                if (request.getUserID().equals(currentUser.getUid())) {
                    currUserRequests.add(request);
                }
            }
        }

        return currUserRequests;
    }

    @Override
    public String getCurrentUsername() {
        return currentUser.getDisplayName();
    }

    @Override
    public String getCurrentUserEmail() {
        return currentUser.getEmail();
    }

    @Override
    public void setPresenter(RequestsContract.RequestsPresenter presenter) {
        this.presenter = presenter;
        subscribeToRequests();
    }

    @Override
    public String getCurrentUID() {
        return currentUser.getUid();
    }
}
