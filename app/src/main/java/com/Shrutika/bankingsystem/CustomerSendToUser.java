package com.Shrutika.bankingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CustomerSendToUser extends RecyclerView.Adapter<HolderDetails> {

    com.Shrutika.bankingsystem.SendtoUser SendtoUser;
    List<Model> modelList;
    Context context;

    public CustomerSendToUser(com.Shrutika.bankingsystem.SendtoUser sentoUser, List<Model> modelList) {
        this.SendtoUser = sentoUser;
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
                SendtoUser.selectuser(position);
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

    public void setFilter(ArrayList<Model> newList){
        modelList = new ArrayList<>();
        modelList.addAll(newList);
        notifyDataSetChanged();
    }
}
