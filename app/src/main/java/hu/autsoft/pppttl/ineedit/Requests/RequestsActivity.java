package hu.autsoft.pppttl.ineedit.Requests;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import hu.autsoft.pppttl.ineedit.Model.Request;
import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.RequestDetails.RequestDetailsActivity;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class RequestsActivity extends AppCompatActivity implements RequestsView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View recyclerView = findViewById(R.id.recyclerViewRequests);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        ArrayList<Request> requests = new ArrayList<Request>();
        requests.add(new Request("Request 1", Request.Status.ACCEPTED, ""));
        requests.add(new Request("Request 2", Request.Status.PENDING, ""));
        requests.add(new Request("Request 3", Request.Status.DENIED, ""));

        recyclerView.setAdapter(new RequestRecyclerViewAdapter(requests, RequestsActivity.this));
    }

    @Override
    public void navigateToRequest() {
        startActivity(new Intent(this, RequestDetailsActivity.class));
    }
}
