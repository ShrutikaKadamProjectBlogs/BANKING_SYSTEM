package com.Shrutika.bankingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerUserlist extends RecyclerView.Adapter<HolderDetails> {

    Userlist UserList;
    List<Model> modelList;
    Context context;

    public CustomerUserlist(Userlist userList, List<Model> modelList) {
        this.UserList = userList;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public HolderDetails onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.userslist, parent, false);

        HolderDetails viewHolder = new HolderDetails(itemView);
        viewHolder.setOnClickListener(new HolderDetails.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                UserList.nextActivity(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDetails holder, int position) {
        holder.mName.setText(modelList.get(position).getName());
        holder.mPhonenumber.setText(modelList.get(position).getPhoneno());
        holder.mBalance.setText(modelList.get(position).getBalance());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
