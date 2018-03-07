package hu.autsoft.pppttl.ineedit.RequestDetails;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import hu.autsoft.pppttl.ineedit.Model.Comment;
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
    @BindView(R.id.edittext_chatbox)
    EditText chatbox;
    @BindView(R.id.button_chatbox_send)
    Button sendButton;
    @BindView(R.id.reyclerview_message_list)
    RecyclerView recyclerView;

    public static final String REQUEST_ID = "request_id";
    private static final String REQUEST_NAME = "request_name";

    String requestID;
    RequestDetailsPresenter presenter;
    Request request;
    CommentRecyclerViewAdapter adapter;

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
        setupRecyclerView(recyclerView);
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

    @OnClick(R.id.button_chatbox_send)
    public void sendClick() {
        String userID = presenter.getUserID();
        String message = chatbox.getText().toString();
        Comment comment = new Comment(userID, message);

        presenter.sendComment(comment);
        chatbox.setText("");
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        List<Comment> comments = request == null ? new ArrayList<Comment>() : new ArrayList<>(request.getComments());
        adapter = new CommentRecyclerViewAdapter(comments);
        recyclerView.setAdapter(adapter);
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
            adapter.updateComments(request.getComments());
        }

    }

    @Override
    public void onRequestSave(Request request) {
        presenter.updateRequest(request);
    }
}
