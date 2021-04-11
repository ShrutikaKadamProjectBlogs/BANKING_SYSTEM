package com.Shrutika.bankingsystem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HolderDetails extends RecyclerView.ViewHolder {

    TextView mName, mPhonenumber, mBalance, mRupee, mRupeeslash, mName1, mName2, mDate, mTransc_status;
    ImageView mPhone, mArrow;
    View mView;

    public HolderDetails(@NonNull View itemView) {
        super(itemView);
        mView = itemView;

        mName = itemView.findViewById(R.id.username);
        mPhonenumber = itemView.findViewById(R.id.userphonenumber);
        mBalance = itemView.findViewById(R.id.balance);
        mRupee = itemView.findViewById(R.id.rupee);
        mRupeeslash = itemView.findViewById(R.id.rupeeslash);
        mPhone = itemView.findViewById(R.id.phone);
        mName1 = itemView.findViewById(R.id.name1);
        mName2 = itemView.findViewById(R.id.name2);
        mDate = itemView.findViewById(R.id.date);
        mArrow = itemView.findViewById(R.id.arrow);
        mTransc_status = itemView.findViewById(R.id.transaction_status);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

    }
    private HolderDetails.ClickListener mClickListener;
    public interface  ClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnClickListener(HolderDetails.ClickListener clickListener){
       mClickListener = clickListener;
    }
}
