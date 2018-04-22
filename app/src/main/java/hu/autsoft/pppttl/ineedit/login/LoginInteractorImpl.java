package hu.autsoft.pppttl.ineedit.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import hu.autsoft.pppttl.ineedit.model.User;


/**
 * Created by pppttl on 2018. 02. 26..
 */

public class LoginInteractorImpl implements LoginContract.LoginInteractor {
    private static final String TAG = "LoginInteractorImpl";
    public static final String USERS_NAME = "users";
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser currentUser;
    private User user;

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            currentUser = mAuth.getCurrentUser();
                            saveCurrentUserEmail();
                            listener.onSuccess();
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            listener.onUsernameError();
                        }
                    }
                });
    }

    @Override
    public boolean isLoggedIn() {
        return mAuth.getCurrentUser() != null;
    }

    private void saveCurrentUserEmail() {
        if (currentUser != null) {
            final String notificationToken = FirebaseInstanceId.getInstance().getToken();

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            final DatabaseReference databaseReference = database.getReference().child(USERS_NAME).child(currentUser.getUid());
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    user = dataSnapshot.getValue(User.class);
                    if (user == null) {
                        user = new User();
                        user.setuID(currentUser.getUid());
                        user.setEmail(currentUser.getEmail());
                        user.setWorkEmail(currentUser.getEmail());
                        user.setNotificationToken(notificationToken);
                        databaseReference.setValue(user);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}
