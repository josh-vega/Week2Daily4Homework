package com.example.week2daily4homework;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserInputFragment.OnFragmentInteractionListener{
    UserInputFragment userInputFragment;
    DisplayFragment displayFragment;
    ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputFragment = new UserInputFragment();
        displayFragment = new DisplayFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.flFragOne, userInputFragment).commit();
        fm.beginTransaction().replace(R.id.flFragTwo, displayFragment).commit();
    }

    @Override
    public void sendToActivity(User user) {
        DisplayFragment.setDisplay(user);
    }
}
