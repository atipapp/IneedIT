package hu.autsoft.pppttl.ineedit.profile;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import javax.inject.Inject;

import hu.autsoft.pppttl.ineedit.model.User;

/**
 * Created by pppttl on 2018. 04. 08..
 */
public class ProfileInteractorImpl implements ProfileContract.ProfileInteractor {
    private static final String CHILD_NAME = "users";
    private User currentUser;

    @Inject
    ProfileContract.ProfilePresenter presenter;

    @Override
    public void subscribeToUser(String uid) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        databaseReference.child(ProfileInteractorImpl.CHILD_NAME).child(uid).addValueEventListener(new ValueEventListener() {
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
