package hu.autsoft.pppttl.ineedit.profile;

import dagger.Module;
import dagger.Provides;

/**
 * Created by pppttl on 2018. 04. 08..
 */
@Module
public class ProfileModule {

    @Provides
    ProfileContract.ProfilePresenter provideProfilePresenter(ProfileContract.ProfileView view, ProfileContract.ProfileInteractor interactor) {
        return new ProfilePresenterImpl(view, interactor);
    }

    @Provides
    ProfileContract.ProfileInteractor provideProfileInteractor() {
        return new ProfileInteractorImpl();
    }
}
