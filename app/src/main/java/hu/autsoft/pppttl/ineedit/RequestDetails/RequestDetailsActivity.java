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

public class RequestDetailsActivity extends AppCompatActivity implements RequestDetailsView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.detailsURL)
    TextView urlView;
    @BindView(R.id.detailsPrice)
    TextView priceView;
    @BindView(R.id.detailsStatus)
    TextView statusView;

    public static final String REQUEST_ID = "request_id";

    String requestID;
    RequestDetailsPresenter presenter;

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

    @OnClick(R.id.fabRequestDetails)
    public void fabClick(View view) {
        RequestCreateOrEditDialog dialog = new RequestCreateOrEditDialog();
        dialog.show(view, getString(R.string.edit_request), null); //TODO
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
        Request request = presenter.getRequest();
        if (request == null) {
            finish();
        } else {
            toolbar.setTitle(request.getName());
            urlView.setText(request.getLink());
            priceView.setText(Integer.toString(request.getPrice()));
            statusView.setText(request.getStatus().toString());
        }

    }
}
