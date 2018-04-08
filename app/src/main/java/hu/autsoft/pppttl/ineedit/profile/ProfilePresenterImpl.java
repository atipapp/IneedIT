package hu.autsoft.pppttl.ineedit.profile;

import javax.inject.Inject;

import hu.autsoft.pppttl.ineedit.model.User;
import hu.autsoft.pppttl.ineedit.mvp.BasePresenter;

/**
 * Created by pppttl on 2018. 04. 08..
 */
public class ProfilePresenterImpl extends BasePresenter<ProfileContract.ProfileView> implements ProfileContract.ProfilePresenter {
    @Inject
    ProfileContract.ProfileInteractor interactor;

    public ProfilePresenterImpl(ProfileContract.ProfileView view, ProfileContract.ProfileInteractor interactor) {
        this.interactor = interactor;
        this.view = view;
        this.interactor.setPresenter(this);
    }

    @Override
    public User getUser(String uid) {
        return interactor.getUser(uid);
    }

    @Override
    public void saveUser(User user) {
        interactor.saveUser(user);
    }

    @Override
    public void subscribeToUser(String uid) {
        interactor.subscribeToUser(uid);
    }

    @Override
    public void closeUI() {
        view.closeUI();
    }

    @Override
    public void updateUI() {
        view.updateUI();
    }

    @Override
    public String getSelectedUserId() {
        return view.getSelectedUserId();
    }
}
