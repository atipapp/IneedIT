package hu.autsoft.pppttl.ineedit.fcm;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import hu.autsoft.pppttl.ineedit.model.User;

import static hu.autsoft.pppttl.ineedit.login.LoginInteractorImpl.USERS_NAME;

/**
 * Created by pppttl on 2018. 04. 22..
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        final String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.d("TOKEN refreshed: ", refreshedToken);

        final FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        if (currentUser != null) {
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference databaseReference = database.getReference().child(USERS_NAME).child(currentUser.getUid());
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user == null) {
                        user = new User();
                        user.setUID(currentUser.getUid());
                        user.setEmail(currentUser.getEmail());
                        user.setWorkEmail(currentUser.getEmail());
                    }
                    user.addNotificationToken(refreshedToken);
                    databaseReference.setValue(user);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
