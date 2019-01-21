package com.example.week2daily4homework;

import android.content.Context;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<User> userArrayList;

    public RecyclerViewAdapter(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        User user = userArrayList.get(position);

        if(user != null) {
            String name = user.getName();
            String email = user.getEmail();
            String pass = user.getPassword();

            viewHolder.setItemUser(user);
            viewHolder.tvName.setText(name);
            viewHolder.tvEmail.setText(email);
            viewHolder.tvPassword.setText(pass);

        }
    }

    public void addUser(User user){
        userArrayList.add(user);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userArrayList != null ? userArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvEmail;
        TextView tvPassword;
        User itemUser;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvPassword = itemView.findViewById(R.id.tvPassword);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), itemUser.getName(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setItemUser(User itemUser){
            this.itemUser = itemUser;
        }
    }
}
