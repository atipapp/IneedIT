package hu.autsoft.pppttl.ineedit.RequestDetails;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.RequestCreateOrEdit.RequestCreateOrEditDialog;

public class RequestDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestCreateOrEditDialog dialog = new RequestCreateOrEditDialog();
                dialog.show(view, getString(R.string.edit_request));
            }
        });
    }
}
