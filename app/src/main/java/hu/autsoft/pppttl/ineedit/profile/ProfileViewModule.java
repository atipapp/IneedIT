package hu.autsoft.pppttl.ineedit.profile;

import dagger.Binds;
import dagger.Module;

/**
 * Created by pppttl on 2018. 04. 08..
 */
@Module
public abstract class ProfileViewModule {
    @Binds
    abstract ProfileContract.ProfileView provideProfileView(ProfileActivity profileActivity);
}
