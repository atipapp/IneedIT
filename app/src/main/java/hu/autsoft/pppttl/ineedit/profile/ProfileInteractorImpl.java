package hu.autsoft.pppttl.ineedit.profile;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import hu.autsoft.pppttl.ineedit.model.User;

/**
 * Created by pppttl on 2018. 04. 08..
 */
public class ProfileInteractorImpl implements ProfileContract.ProfileInteractor {
    public static final String CHILD_NAME = "users";
    private User currentUser;

    ProfileContract.ProfilePresenter presenter;

    @Override
    public void subscribeToUser(String uid) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        DatabaseReference userdb = databaseReference.child(ProfileInteractorImpl.CHILD_NAME).child(uid);
        userdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentUser = dataSnapshot.getValue(User.class);
                if (currentUser == null) {
                    if (presenter != null) presenter.closeUI();
                    return;
                }

                if (presenter != null) presenter.updateUI();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    @Override
    public void setPresenter(ProfileContract.ProfilePresenter presenter) {
        this.presenter = presenter;
        subscribeToUser(presenter.getSelectedUserId());
    }

    @Override
    public User getUser(String uid) {
        return currentUser;
    }

    @Override
    public void saveUser(User user) {
        currentUser = user;
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        databaseReference.child(ProfileInteractorImpl.CHILD_NAME).child(currentUser.getuID()).setValue(currentUser);
        if (presenter != null) presenter.updateUI();
    }
}
