package hu.autsoft.pppttl.ineedit.requestdetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hu.autsoft.pppttl.ineedit.R;
import hu.autsoft.pppttl.ineedit.model.Comment;


/**
 * Created by pppttl on 2018. 03. 07..
 */

public class CommentRecyclerViewAdapter
        extends RecyclerView.Adapter<CommentRecyclerViewAdapter.ViewHolder> {

    private final List<Comment> comments;
    private Context context;

    public CommentRecyclerViewAdapter() {
        comments = new ArrayList<>();
    }

    @Override
    public CommentRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_comment, parent, false);
        return new CommentRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mComment = comments.get(position);
        holder.name.setText(comments.get(position).getUserEmail());
        holder.comment.setText(comments.get(position).getMessage());
        holder.time.setText(DateUtils.formatDateTime(context, comments.get(position).getCreatedAt(), DateUtils.FORMAT_ABBREV_ALL));
    }


    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void updateComments(Context context, List<Comment> newComments) {
        this.context = context;
        comments.clear();
        comments.addAll(newComments);
        notifyDataSetChanged();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        //public final ImageView profile;
        public final TextView name;
        public final TextView comment;
        public final TextView time;
        public Comment mComment;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            name = (TextView) view.findViewById(R.id.text_message_name);
            //profile = (ImageView) view.findViewById(R.id.image_message_profile);
            comment = (TextView) view.findViewById(R.id.text_message_body);
            time = (TextView) view.findViewById(R.id.text_message_time);

        }
    }
}
