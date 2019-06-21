package com.example.rish.drspectraadmin.ViewHolders;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.rish.drspectraadmin.Interfaces.ViewHolderClickListner;
import com.example.rish.drspectraadmin.R;

public class THIAdapter extends RecyclerView.Adapter<THIAdapter.thiViewHolder> {
    private Context context;
    private ViewHolderClickListner itemClickListener;
    private String[] ques;

    public class thiViewHolder extends RecyclerView.ViewHolder {
        public TextView thiQues;
        public RadioGroup thiRG;

        public thiViewHolder(View itemView) {
            super(itemView);
//            this.thiQues = (TextView) itemView.findViewById(R.id.THIQuesTV);
  //          this.thiRG = (RadioGroup) itemView.findViewById(R.id.thiAnsRG);
            this.thiRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    itemClickListener.Onclick(checkedId, thiViewHolder.this.getAdapterPosition(), thiViewHolder.this);
                }
            });
        }
    }

    public THIAdapter(String[] ques, Context context) {
        this.ques = ques;
        this.context = context;
    }

    public thiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new thiViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.thi_layout, parent, false));
    }

    public void onBindViewHolder(thiViewHolder holder, int position) {
        holder.thiQues.setText(this.ques[position]);
    }

    public int getItemCount() {
        return this.ques.length;
    }

    public void setClickListner(ViewHolderClickListner itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
