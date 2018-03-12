package hu.autsoft.pppttl.ineedit.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.AndroidInjection;
import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.requests.RequestsActivity;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class LoginActivity extends AppCompatActivity implements LoginView {
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;

    @Inject
    LoginPresenter presenter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
    }

    @Override protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override protected void onStart(){
        super.onStart();
        presenter.autoLogin();
    }

    @Override public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override public void setUsernameError() {
        username.setError(getString(R.string.username_error));
    }

    @Override public void setPasswordError() {
        password.setError(getString(R.string.password_error));
    }

    @Override public void navigateToHome() {
        startActivity(new Intent(this, RequestsActivity.class));
        finish();
    }

    @OnClick(R.id.loginButton)
    public void loginClick() {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
