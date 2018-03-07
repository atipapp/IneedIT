package hu.autsoft.pppttl.ineedit.RequestDetails;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import hu.autsoft.pppttl.ineedit.Model.Comment;
import hu.autsoft.pppttl.ineedit.R;


/**
 * Created by pppttl on 2018. 03. 07..
 */

public class CommentRecyclerViewAdapter
        extends RecyclerView.Adapter<CommentRecyclerViewAdapter.ViewHolder> {

    private final List<Comment> comments;

    public CommentRecyclerViewAdapter(List<Comment> messageList) {
        comments = messageList;
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
        holder.name.setText(comments.get(position).getUserID());
        holder.comment.setText(comments.get(position).getMessage());
        holder.time.setText(comments.get(position).getCreatedAt() + "");
    }


    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void updateComments(List<Comment> newComments) {
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
