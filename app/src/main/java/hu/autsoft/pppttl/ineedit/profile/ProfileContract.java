package hu.autsoft.pppttl.ineedit.profile;

import hu.autsoft.pppttl.ineedit.model.User;

/**
 * Created by pppttl on 2018. 04. 08..
 */
public interface ProfileContract {

    interface ProfileInteractor {
        User getUser(String uid);

        void saveUser(User user);

        void subscribeToUser(String uid);

        void setPresenter(ProfilePresenter presenter);
    }

    interface ProfilePresenter {
        User getUser(String uid);

        void saveUser(User user);

        void subscribeToUser(String uid);

        void closeUI();

        void updateUI();

        String getSelectedUserId();
    }

    interface ProfileView {
        void closeUI();

        void updateUI();

        String getSelectedUserId();
    }
}
