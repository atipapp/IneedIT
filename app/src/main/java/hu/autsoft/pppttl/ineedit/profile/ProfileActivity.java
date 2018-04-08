package hu.autsoft.pppttl.ineedit.profile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.model.User;
import hu.autsoft.pppttl.ineedit.useredit.SaveUserCallbackListener;
import hu.autsoft.pppttl.ineedit.useredit.UserEditDialog;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.ProfileView, SaveUserCallbackListener {
    public static final String USER_ID = "USER_ID";

    @Inject
    ProfileContract.ProfilePresenter presenter;

    private String uid;
    private User currentUser;

    @BindView(R.id.userPhone)
    TextView phoneNumberTv;
    @BindView(R.id.userLoginEmail)
    TextView loginEmailTv;
    @BindView(R.id.userWorkEmail)
    TextView workEmailTv;
    @BindView(R.id.userWorkAddress)
    TextView workAddressTv;
    @BindView(R.id.fabProfile)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        uid = getIntent().getStringExtra(USER_ID);
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @OnClick(R.id.fabProfile)
    public void fabClick(View view) {
        UserEditDialog dialog = new UserEditDialog();
        if (currentUser == null) {
            currentUser = new User();
            currentUser.setuID(uid);
        }
        dialog.show("Edit user", view, currentUser, this);
    }

    @Override
    public void closeUI() {
        finish();
    }

    @Override
    public void updateUI() {
        currentUser = presenter.getUser(uid);

        if (currentUser == null) {
            finish();
        } else {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(currentUser.getFullName());

            phoneNumberTv.setText(currentUser.getPhoneNumber());
            loginEmailTv.setText(currentUser.getWorkEmail()); //TODO
            workEmailTv.setText(currentUser.getWorkEmail());
            workAddressTv.setText(currentUser.getWorkAddress());
        }
    }

    @Override
    public String getSelectedUserId() {
        return uid;
    }

    @Override
    public void onSaveUser(User user) {
        currentUser = user;
        presenter.saveUser(currentUser);
    }
}
