package hu.autsoft.pppttl.ineedit.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import hu.autsoft.pppttl.ineedit.App;

/**
 * Created by pppttl on 2018. 03. 12..
 */

@Module
public class AppModule {
    @Provides
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

}
