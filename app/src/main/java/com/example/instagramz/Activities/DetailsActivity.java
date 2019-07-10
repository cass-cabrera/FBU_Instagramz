package com.example.instagramz.Activities;

import android.graphics.Movie;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.instagramz.Model.Post;
import com.example.instagramz.R;
import com.parse.ParseFile;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {
    TextView handle;
    ImageView image;
    TextView description;
    TextView timestamp;

    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_post);

        handle = findViewById(R.id.tvHandle);
        image = findViewById(R.id.ivImagePostPic);
        description = findViewById(R.id.tvDescriptionPost);
        timestamp = findViewById(R.id.tvTimestamp);

        post = Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        Log.d("Details Activity", String.format("Showing details for '%s'", post.getKeyDescription()));

        setCaption();
        setImage();
        setUsername();
        setTimestamp();
    }

    private void setUsername() {
        handle.setText(post.getKeyUser().getUsername());
    }

    private void setImage() {
        ParseFile picz = post.getKeyImage();

        if(picz != null) {
            Glide.with(this).load(picz.getUrl()).into(image);
        }
    }

    private void setCaption() {
        description.setText(post.getKeyDescription());
    }

    private void setTimestamp() {
        timestamp.setText(post.getRelativeTimestamp());

    }
}
