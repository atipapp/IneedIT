package hu.autsoft.pppttl.ineedit.profile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import javax.inject.Inject;

import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.model.User;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.ProfileView {
    @Inject
    ProfileContract.ProfilePresenter presenter;

    private String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void closeUI() {
        finish();
    }

    @Override
    public void updateUI() {
        User currentUser = presenter.getUser(uid);


    }
}
