package com.example.instagramz.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.instagramz.Activities.MainActivity;
import com.example.instagramz.R;
import com.parse.ParseUser;

public class ProfileFragment extends Fragment {

    Button logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        logout = view.findViewById(R.id.logoutButt);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser.logOut();

                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
//                ParseUser currentUser = ParseUser.getCurrentUser();

                //intent to go back to login screen with a finish
            }
        });
    }

}
