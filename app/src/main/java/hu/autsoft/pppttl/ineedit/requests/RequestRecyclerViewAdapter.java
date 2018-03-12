package hu.autsoft.pppttl.ineedit.requests;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.model.Request;

/**
 * Created by pppttl on 2018. 02. 26..
 */

public class RequestRecyclerViewAdapter
        extends RecyclerView.Adapter<RequestRecyclerViewAdapter.ViewHolder> {

    private RequestsView activity;

    private final List<Request> requests;

    public RequestRecyclerViewAdapter(RequestsView activity) {
        this.requests = new ArrayList<>();
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
                activity.navigateToRequest(holder.mRequest.getRequestID());
            }
        });
    }


    public void updateRequests(List<Request> newRequests) {
        requests.clear();
        requests.addAll(newRequests);
        notifyDataSetChanged();
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
