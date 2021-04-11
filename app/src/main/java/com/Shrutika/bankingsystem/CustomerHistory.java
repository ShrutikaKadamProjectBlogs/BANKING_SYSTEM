package com.Shrutika.bankingsystem;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerHistory extends RecyclerView.Adapter<HolderDetails> {

    History HistoryList;
    List<Model> modelList;
    Context context;

    TextView mTransc_status;

    public CustomerHistory(History historyList, List<Model> modelList) {
        this.HistoryList = historyList;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public HolderDetails onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.transfer_history_list, parent, false);

        mTransc_status = itemView.findViewById(R.id.transaction_status);

        HolderDetails viewHolder = new HolderDetails(itemView);
        viewHolder.setOnClickListener(new HolderDetails.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderDetails holder, int position) {
        holder.mName1.setText(modelList.get(position).getName1());
        holder.mName2.setText(modelList.get(position).getName2());
        holder.mBalance.setText(modelList.get(position).getBalance());
        holder.mDate.setText(modelList.get(position).getDate());
        holder.mTransc_status.setText(modelList.get(position).getTransaction_status());

        if(modelList.get(position).getTransaction_status().equals("Failed")){
            holder.mTransc_status.setTextColor(Color.parseColor("#f40404"));
        }else{
            holder.mTransc_status.setTextColor(Color.parseColor("#4BB543"));
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
