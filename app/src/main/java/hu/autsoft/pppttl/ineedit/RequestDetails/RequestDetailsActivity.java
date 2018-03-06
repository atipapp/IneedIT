package hu.autsoft.pppttl.ineedit.RequestDetails;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.autsoft.pppttl.ineedit.Model.Request;
import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.RequestCreateOrEdit.RequestCreateOrEditDialog;
import hu.autsoft.pppttl.ineedit.Requests.SaveRequestCallbackListener;

public class RequestDetailsActivity extends AppCompatActivity implements RequestDetailsView, SaveRequestCallbackListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detailsURL)
    TextView urlView;
    @BindView(R.id.detailsPrice)
    TextView priceView;
    @BindView(R.id.detailsStatus)
    TextView statusView;

    public static final String REQUEST_ID = "request_id";
    private static final String REQUEST_NAME = "request_name";

    String requestID;
    RequestDetailsPresenter presenter;
    Request request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_details);
        ButterKnife.bind(this);

        requestID = getIntent().getStringExtra(REQUEST_ID);
        presenter = new RequestDetailsPresenterImpl(this, requestID);

        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateUI();
    }

    @OnClick(R.id.fabRequestDetails)
    public void fabClick(View view) {
        RequestCreateOrEditDialog dialog = new RequestCreateOrEditDialog();
        dialog.show(view, getString(R.string.edit_request), this, request);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void updateUI() {
        request = presenter.getRequest();
        if (request == null) {
            finish();
        } else {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(request.getName());

            urlView.setText(request.getLink().length() > 0 ? request.getLink() : getString(R.string.n_a));
            priceView.setText(request.getPrice() > 0 ? Integer.toString(request.getPrice()) : getString(R.string.n_a));
            statusView.setText(request.getStatus().toString());
        }

    }

    @Override
    public void onRequestSave(Request request) {
        presenter.updateRequest(request);
    }
}
