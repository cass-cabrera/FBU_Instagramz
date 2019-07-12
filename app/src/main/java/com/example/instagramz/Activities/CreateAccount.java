package com.example.instagramz.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.instagramz.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccount extends AppCompatActivity {

    EditText user;
    EditText pass;
    EditText email;
    EditText handle;
    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_action_bar);

        user = findViewById(R.id.etCreateName);
        pass = findViewById(R.id.etCreatePass);
        email = findViewById(R.id.etCreateEmail);
        handle = findViewById(R.id.etCreateHandle);
        create = findViewById(R.id.createButt);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user.getText().toString();
                String passs = pass.getText().toString();
                String electronic = email.getText().toString();
                String atname = handle.getText().toString();

                createAcct(name, passs, electronic, atname);
            }
        });
    }

    private void createAcct(String name, String pass, String email, String handle) {
        ParseUser user = new ParseUser();
        user.setUsername(name);
        user.setPassword(pass);
        user.setEmail(email);
        user.put("handle", handle);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null) {
                    Log.d("Create Account", "creating an account successful");
                    Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Log.e("Create Account", "creating an account failed");
                }
            }
        });

    }
}
