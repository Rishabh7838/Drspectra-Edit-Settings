package com.example.rish.drspectraadmin.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rish.drspectraadmin.Interfaces.ItemClickListener;
import com.example.rish.drspectraadmin.R;

public class patientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public Button callPatient;
    public ItemClickListener itemClickListener;
    public TextView patientName;
    public TextView patientNumber;
    public TextView patientSession;
    public TextView thiScore;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public patientViewHolder(View itemView) {
        super(itemView);
//        patientName = (TextView) itemView.findViewById(R.id.patientNameTV);
//        patientNumber = (TextView) itemView.findViewById(R.id.patientNumberTV);
//        patientSession = (TextView) itemView.findViewById(R.id.patientSessionLeftTV);
//        thiScore = (TextView) itemView.findViewById(R.id.patientTHITV);
//        callPatient = (Button) itemView.findViewById(R.id.callPatient);
        itemView.setOnClickListener(this);
    }

    public void onClick(View v) {
        this.itemClickListener.Onclick(v, getAdapterPosition(), false);
    }
}
