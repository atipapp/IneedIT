package hu.autsoft.pppttl.ineedit.login;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



/**
 * Created by pppttl on 2018. 02. 26..
 */

public class LoginInteractorImpl implements LoginContract.LoginInteractor {
    private static final String TAG = "LoginInteractorImpl";
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        mAuth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            listener.onSuccess();
                        } else {
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            listener.onUsernameError();
                        }

                        // ...
                    }
                });
    }

    @Override
    public boolean isLoggedIn() {
        return mAuth.getCurrentUser() != null;
    }
}
