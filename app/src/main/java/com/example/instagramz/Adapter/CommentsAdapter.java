package com.example.instagramz.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.instagramz.Model.Comment;
import com.example.instagramz.Model.Post;
import com.example.instagramz.R;

import org.w3c.dom.Text;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private Context context;
    private List<Comment> comments;

    public CommentsAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Comment comment = comments.get(i);
        viewHolder.bind(comment);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public void clear() {
        comments.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Comment> list) {
        comments.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView handle;
        TextView commentView;
        TextView timestamp;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            handle = itemView.findViewById(R.id.tvCommenter);
            commentView = itemView.findViewById(R.id.tvComment);
            timestamp= itemView.findViewById(R.id.tvCommentTimestamp);

        }

        public void bind(Comment comment) {
            handle.setText(comment.getKeyUser().getUsername());
            commentView.setText(comment.getKeyComment());
            timestamp.setText(comment.getRelativeTimestamp());
        }
    }
}