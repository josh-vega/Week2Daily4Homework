package com.example.week2daily4homework;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplayFragment extends Fragment {
    RecyclerView recyclerView;
    static RecyclerViewAdapter rvAdapter;
    ArrayList<User> list = listOfUsers();


    public DisplayFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rvMainRecyclerView);
        rvAdapter = new RecyclerViewAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);
    }

    public static void setDisplay(User user) {
        rvAdapter.addUser(user);
    }

    private ArrayList<User> listOfUsers(){
        ArrayList<User> userArrayList = new ArrayList<>();
        User user = new User();
        user.setName("Jill Davis");
        user.setEmail("Jill.Davis@charter.ex");
        user.setPassword("gengar");
        userArrayList.add(user);

        User user2 = new User();
        user2.setName("Austin Smith");
        user2.setEmail("AusDaBoss@bossman.com");
        user2.setPassword("kiraka");
        userArrayList.add(user2);

        User user3 = new User();
        user3.setName("Joshua Vega");
        user3.setEmail("Joshman@vegadude.com");
        user3.setPassword("Booyah!");
        userArrayList.add(user3);
        return userArrayList;
    }

}
