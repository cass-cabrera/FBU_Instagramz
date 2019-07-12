package com.example.instagramz.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.instagramz.Adapter.CommentsAdapter;
import com.example.instagramz.Adapter.PostsAdapter;
import com.example.instagramz.Model.Comment;
import com.example.instagramz.R;
import com.parse.LocationCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class CommentActivity extends AppCompatActivity {

    RecyclerView commentsList;
    EditText comment;
    Button post;
    CommentsAdapter adapter;
    List<Comment> mComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commentsList = findViewById(R.id.rvCommentList);
        comment = findViewById(R.id.etMakeComment);
        post = findViewById(R.id.submitComment);

        adapter = new CommentsAdapter(this, mComments);
        commentsList.setAdapter(adapter);
        commentsList.setLayoutManager(new LinearLayoutManager(this));



    }

//    private void makeAComment() {
//        final ParseQuery<Comment> commentParseQuery = new ParseQuery<Comment>(Comment.class);
//        commentParseQuery.include()
//    }
}
