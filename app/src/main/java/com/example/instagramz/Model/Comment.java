package com.example.instagramz.Model;

import android.text.format.DateUtils;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


@ParseClassName("Comment")

public class Comment extends ParseObject {

    public static final String KEY_COMMENT = "Comment";
    public static final String KEY_CREATEDAT = "createdAt";
    public static final String KEY_USER = "User";
    public static final String KEY_POSTID = "postID";

    public String getKeyComment() {
        return getString(KEY_COMMENT);
    }

    public void setKeyComment(String description) {
        put(KEY_COMMENT, description);
    }

    public ParseUser getKeyUser() {
        return getParseUser(KEY_USER);
    }

    public void setKeyUser(ParseUser user) {
        put(KEY_USER, user);
    }

    public  String getKeyPostID() {
        return getString(KEY_POSTID);
    }
    public  void setKeyPostID(String id) {
        put(KEY_POSTID, id);
    }


    public String getRelativeTimestamp() {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        Date createdAt = getCreatedAt();
        long dateMillis = createdAt.getTime();
        relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        return relativeDate;
    }

}
/*


    }

    public void setKeyDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getKeyImage() {
        return getParseFile(KEY_IMAGE);
    }

    public void setKeyImage(ParseFile image) {
        put(KEY_IMAGE, image);
    }

    public ParseUser getKeyUser() {
        return getParseUser(KEY_USER);
    }

    public void setKeyUser(ParseUser user) {
        put(KEY_USER, user);
    }

    public String getRelativeTimestamp() {
        String twitterFormat = "EEE MMM dd HH:mm:ss ZZZZZ yyyy";
        SimpleDateFormat sf = new SimpleDateFormat(twitterFormat, Locale.ENGLISH);
        sf.setLenient(true);

        String relativeDate = "";
        Date createdAt = getCreatedAt();
        long dateMillis = createdAt.getTime();
        relativeDate = DateUtils.getRelativeTimeSpanString(dateMillis,
                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS).toString();
        return relativeDate;
    }

    public static class Query extends ParseQuery<Post> {
        public Query(){
            super(Post.class);
        }

        public Query getTop() {
            setLimit(20);
            return this;
        }

        public Query withUser() {
            include("user");
            return this;
        }


    }


}

 */