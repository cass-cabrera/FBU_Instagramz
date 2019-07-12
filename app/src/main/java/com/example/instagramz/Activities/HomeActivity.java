package com.example.instagramz.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.instagramz.Fragments.ComposeFragment;
import com.example.instagramz.Fragments.PostsFragment;
import com.example.instagramz.Fragments.ProfileFragment;
import com.example.instagramz.R;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.title_action_bar);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = new PostsFragment();
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        // do something here
                        fragment = new PostsFragment();

                        break;
                    case R.id.action_compose:
                        // do something here
                        fragment = new ComposeFragment();

                        break;
                    case R.id.action_profile:
                         //do something here
                        fragment = new ProfileFragment();

                        break;
                    default: break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });

        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
}
