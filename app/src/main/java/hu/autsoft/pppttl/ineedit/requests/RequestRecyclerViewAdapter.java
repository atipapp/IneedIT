package hu.autsoft.pppttl.ineedit.requests;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    private RequestsContract.RequestsView activity;

    private final List<Request> allRequests;
    private final List<Request> filteredRequests;

    private Request.Status selectedFilter;

    public RequestRecyclerViewAdapter(RequestsContract.RequestsView activity) {
        this.allRequests = new ArrayList<>();
        this.filteredRequests = new ArrayList<>();
        selectedFilter = null;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_request, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mRequest = filteredRequests.get(position);
        holder.name.setText(filteredRequests.get(position).getName());
        holder.status.setText(filteredRequests.get(position).getStatus().toString());

        switch (holder.mRequest.getStatus()) {
            case ACCEPTED:
                holder.statusImage.setBackgroundResource(R.drawable.ic_requests_accepted);
                break;
            case PENDING:
                holder.statusImage.setBackgroundResource(R.drawable.ic_requests_pending);
                break;
            case DENIED:
                holder.statusImage.setBackgroundResource(R.drawable.ic_requests_denied);
                break;
            default:
                holder.statusImage.setBackgroundResource(R.drawable.ic_requests_all);
                break;
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.navigateToRequest(holder.mRequest.getRequestID());
            }
        });
    }


    public void updateRequests(List<Request> newRequests) {
        allRequests.clear();
        allRequests.addAll(newRequests);

        filterRequests(selectedFilter);
    }

    public void filterRequests(Request.Status newStatus) {
        //newStatus = null -> all requests selected
        selectedFilter = newStatus;
        filteredRequests.clear();
        if (selectedFilter == null) {
            filteredRequests.addAll(allRequests);
        } else {
            for (Request req : allRequests) {
                if (req.getStatus().equals(selectedFilter)) {
                    filteredRequests.add(req);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return filteredRequests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final TextView status;
        public Request mRequest;
        public ImageView statusImage;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = view.findViewById(R.id.textViewRequestName);
            status = view.findViewById(R.id.textViewRequestStatus);
            statusImage = view.findViewById(R.id.imageViewType);
        }
    }
}
