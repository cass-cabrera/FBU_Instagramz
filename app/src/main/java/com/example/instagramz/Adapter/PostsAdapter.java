package com.example.instagramz.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.instagramz.Activities.CommentActivity;
import com.example.instagramz.Activities.DetailsActivity;
import com.example.instagramz.Model.Post;
import com.example.instagramz.R;
import com.parse.ParseFile;

import org.parceler.Parcels;
import org.w3c.dom.Comment;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Post post = posts.get(i);
        viewHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Post> list) {
        posts.addAll(list);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView handle;
        ImageView image;
        TextView description;
        TextView timestamp;
        ImageButton comment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            handle = itemView.findViewById(R.id.tvHandle);
            image = itemView.findViewById(R.id.ivImagePostPic);
            description = itemView.findViewById(R.id.tvDescriptionPost);
            timestamp = itemView.findViewById(R.id.tvTimestamp);
            comment = itemView.findViewById(R.id.ibCommentButt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION) {
                Post post = posts.get(position);
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(Post.class.getSimpleName(), Parcels.wrap(post));
                context.startActivity(intent);
            }
        }

        public void bind(Post post) {
            handle.setText(post.getKeyUser().getUsername());
            ParseFile picz = post.getKeyImage();

            if(picz != null) {
                Glide.with(context).load(picz.getUrl()).into(image);
            }
            description.setText(post.getKeyDescription());
            timestamp.setText(post.getRelativeTimestamp());

            comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Will implememnt comment later", Toast.LENGTH_LONG).show();
//                    int position = getAdapterPosition();
//                    if(position != RecyclerView.NO_POSITION) {
//                        Post post = posts.get(position);
//                        Intent intent = new Intent(context, CommentActivity.class);
//                        intent.putExtra(Post.class.getSimpleName(), Parcels.wrap(post));
//                        context.startActivity(intent);
//                    }
                }
            });

        }
    }
}
