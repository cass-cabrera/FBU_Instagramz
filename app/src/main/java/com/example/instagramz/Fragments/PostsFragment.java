package com.example.instagramz.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagramz.Model.Post;
import com.example.instagramz.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

public class PostsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        final Post.Query postsQuery = new Post.Query();
//        postsQuery.getTop().withUser();
//
//        postsQuery.findInBackground(new FindCallback<Post>() {
//            @Override
//            public void done(List<Post> objects, ParseException e) {
//                if(e == null) {
//
//                    for(int i = 0; i < objects.size(); i++) {
//                        Log.d("Post Fragment", "Post [" + i + "] = "
//                                + objects.get(i).getKeyDescription()
//                                + "\nusername = " + objects.get(i).getKeyUser().getUsername()
//                        );
//                    }
//                }
//                else {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}
