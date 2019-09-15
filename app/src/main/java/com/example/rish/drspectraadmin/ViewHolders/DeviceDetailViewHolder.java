package com.example.rish.drspectraadmin.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.rish.drspectraadmin.Interfaces.ItemClickListener;
import com.example.rish.drspectraadmin.R;

public class DeviceDetailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView dbDetail;
    public TextView deviceID;
    public TextView eardetail;
    public Button editSettings,updateNowButton;
    public TextView freqDetail;
    public TextView sessionDetail;
    public TextView timerDetail;
    public TextView volumeDetail;
    public TextView freqValueDetail;
    public TextView updateDateTV;
    public TextView modeStatusTV;
    public ItemClickListener itemClickListener;
    public TextView ownerName;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public DeviceDetailViewHolder(View itemView) {
        super(itemView);
        this.deviceID = (TextView) itemView.findViewById(R.id.deviceIdTV);
        this.ownerName = (TextView) itemView.findViewById(R.id.ownerNameTV);
        this.eardetail = (TextView) itemView.findViewById(R.id.EarDetailTV);
        this.freqDetail = (TextView) itemView.findViewById(R.id.FreqDetailTV);
        this.dbDetail = (TextView) itemView.findViewById(R.id.DBDetailTV);
        this.freqValueDetail = (TextView) itemView.findViewById(R.id.FreqValueTV);
        this.editSettings = (Button) itemView.findViewById(R.id.editSettingButton);
        updateNowButton = itemView.findViewById(R.id.updateNowDeviceButton);
        sessionDetail = itemView.findViewById(R.id.SessionTV);
        timerDetail = itemView.findViewById(R.id.TimerTV);
        volumeDetail = itemView.findViewById(R.id.VolumeTV);
        updateDateTV = itemView.findViewById(R.id.updationDateTV);
        modeStatusTV = itemView.findViewById(R.id.modeViewTV);
        itemView.setOnClickListener(this);
    }

    public void onClick(View v) {
        this.itemClickListener.Onclick(v, getAdapterPosition(), false);
    }
}

