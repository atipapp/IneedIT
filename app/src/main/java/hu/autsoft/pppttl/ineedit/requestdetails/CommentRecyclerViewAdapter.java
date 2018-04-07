package hu.autsoft.pppttl.ineedit.requestdetails;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.model.Comment;


/**
 * Created by pppttl on 2018. 03. 07..
 */

public class CommentRecyclerViewAdapter
        extends RecyclerView.Adapter {

    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    private final List<Comment> comments;
    private Context context;
    private String currentUserEmail;

    public CommentRecyclerViewAdapter() {
        comments = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_comment_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_comment_received, parent, false);
            return new ReceivedMessageHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Comment comment = comments.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(comment);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(comment);
        }
    }

    @Override
    public int getItemViewType(int position) {
        Comment comment = comments.get(position);

        if (comment.getUserEmail().equals(currentUserEmail)) {
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void updateComments(Context context, List<Comment> newComments, String currentUserEmail) {
        this.context = context;
        this.currentUserEmail = currentUserEmail;
        comments.clear();
        comments.addAll(newComments);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            comments.sort(new Comparator<Comment>() {
                @SuppressLint("NewApi")
                @Override
                public int compare(Comment o1, Comment o2) {
                    return Long.compare(o1.getCreatedAt(), o2.getCreatedAt());
                }
            });
        }

        notifyDataSetChanged();
    }

    public class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView name;
        public final TextView comment;
        public final TextView time;

        public ReceivedMessageHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.text_message_name);
            comment = (TextView) view.findViewById(R.id.text_message_body);
            time = (TextView) view.findViewById(R.id.text_message_time);
        }

        void bind(Comment comm) {
            name.setText(comm.getUserEmail());
            comment.setText(comm.getMessage());
            time.setText(DateUtils.formatDateTime(context, comm.getCreatedAt(), DateUtils.FORMAT_ABBREV_ALL));
        }
    }

    public class SentMessageHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView comment;
        public final TextView time;

        public SentMessageHolder(View view) {
            super(view);
            mView = view;
            comment = (TextView) view.findViewById(R.id.text_message_body);
            time = (TextView) view.findViewById(R.id.text_message_time);
        }

        void bind(Comment comm) {
            comment.setText(comm.getMessage());
            time.setText(DateUtils.formatDateTime(context, comm.getCreatedAt(), DateUtils.FORMAT_ABBREV_ALL));
        }
    }
}
