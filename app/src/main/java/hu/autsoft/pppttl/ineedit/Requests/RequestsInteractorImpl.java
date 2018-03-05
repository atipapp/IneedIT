package hu.autsoft.pppttl.ineedit.Requests;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import hu.autsoft.pppttl.ineedit.Model.Request;

/**
 * Created by pppttl on 2018. 03. 05..
 */

public class RequestsInteractorImpl implements RequestsInteractor {
    private static final String CHILD_NAME = "requests";

    class FirebaseRequest extends Request {
        private FirebaseUser user = null;

        public FirebaseRequest(Request request) {
            super(request);
            user = FirebaseAuth.getInstance().getCurrentUser();
        }

        public FirebaseUser getUser() {
            return user;
        }

        public void setUser(FirebaseUser user) {
            this.user = user;
        }
    }

    @Override
    public void saveRequest(Request request) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();

        FirebaseRequest firebaseRequest = new FirebaseRequest(request);
        databaseReference.child(CHILD_NAME).push().setValue(firebaseRequest);
    }
}
