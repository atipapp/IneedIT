package hu.autsoft.pppttl.ineedit.Requests;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.autsoft.pppttl.ineedit.Model.Request;
import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.RequestCreateOrEdit.RequestCreateOrEditDialog;
import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsActivity;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class RequestsActivity extends AppCompatActivity implements RequestsView, SaveRequestCallbackListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerViewRequests)
    RecyclerView recyclerView;
    RequestRecyclerViewAdapter adapter;

    RequestsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        setSupportActionBar(toolbar);

        presenter = new RequestsPresenterImpl(this);

        ButterKnife.bind(this);
        setupRecyclerView(recyclerView);
    }

    @OnClick(R.id.fabRequests)
    public void fabClick(View view) {
        RequestCreateOrEditDialog dialog = new RequestCreateOrEditDialog();
        dialog.show(view, getString(R.string.create_request), this);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        List<Request> requests = new ArrayList<>(presenter.getRequests());
        adapter = new RequestRecyclerViewAdapter(requests, RequestsActivity.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void navigateToRequest() {
        startActivity(new Intent(this, RequestDetailsActivity.class));
    }

    @Override
    public void onRequestDataChanged(List<Request> requests) {
        if (adapter != null) {
            adapter.updateRequests(requests);
        }
    }

    @Override
    public void onRequestSave(Request request) {
        presenter.saveRequest(request);
    }
}
