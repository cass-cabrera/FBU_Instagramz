package com.example.instagramz.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagramz.Model.Post;
import com.example.instagramz.R;
import com.parse.ParseFile;

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

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView handle;
        ImageView image;
        TextView description;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            handle = itemView.findViewById(R.id.tvHandle);
            image = itemView.findViewById(R.id.ivImagePostPic);
            description = itemView.findViewById(R.id.tvDescriptionPost);

        }

        public void bind(Post post) {
            handle.setText(post.getKeyUser().getUsername());
            ParseFile picz = post.getKeyImage();

            if(picz != null) {
                Glide.with(context).load(picz.getUrl()).into(image);
            }
            description.setText(post.getKeyDescription());
        }
    }
}
