package hu.autsoft.pppttl.ineedit.Requests;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hu.autsoft.pppttl.ineedit.Model.Request;
import hu.autsoft.pppttl.ineedit.R;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class RequestRecyclerViewAdapter
        extends RecyclerView.Adapter<RequestRecyclerViewAdapter.ViewHolder> {

    private boolean mTwoPane;
    private AppCompatActivity activity;

    private final List<Request> requests;

    public RequestRecyclerViewAdapter(List<Request> requests, AppCompatActivity activity) {
        this.requests = requests;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_request, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mRequest = requests.get(position);
        holder.name.setText(requests.get(position).getName());
        holder.status.setText(requests.get(position).getStatus().toString());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void deleteRow(int position) {
        requests.remove(position);
        notifyDataSetChanged();
    }


    public void addItem(Request aRequest) {
        requests.add(aRequest);
    }

    @Override
    public int getItemCount() {
        return requests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final TextView status;
        public Request mRequest;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.textViewRequestName);
            status = (TextView) view.findViewById(R.id.textViewRequestStatus);
        }
    }
}
