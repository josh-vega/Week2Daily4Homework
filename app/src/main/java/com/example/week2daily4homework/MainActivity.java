package com.example.week2daily4homework;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserInputFragment.OnFragmentInteractionListener{
    UserInputFragment userInputFragment;
    DisplayUserFragment displayUserFragment;
    ArrayList<User> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputFragment = new UserInputFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.flFragOne, userInputFragment).commit();
        fm.beginTransaction().replace(R.id.flFragTwo, displayUserFragment).commit();
    }


    @Override
    public void sendToActivity(String name, String email, String pass) {
        User user = new User(name, email, pass);
        list.add(user);
    }
}
