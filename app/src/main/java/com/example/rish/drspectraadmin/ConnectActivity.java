package com.example.rish.drspectraadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.rish.drspectraadmin.Interfaces.ItemClickListener;
import com.example.rish.drspectraadmin.Model.DeviceDetail;
import com.example.rish.drspectraadmin.ViewHolders.DeviceDetailViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConnectActivity extends AppCompatActivity {

    private FirebaseRecyclerAdapter<DeviceDetail, DeviceDetailViewHolder> adapter;
    private RecyclerView deviceDetailRV;
    private DatabaseReference deviceList;
    private ProgressDialog loadDetailPB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        this.deviceDetailRV = (RecyclerView) findViewById(R.id.deviceDetailRV);
        this.deviceDetailRV.setLayoutManager(new LinearLayoutManager(this));
        this.deviceDetailRV.setHasFixedSize(true);
        this.loadDetailPB = new ProgressDialog(this);
        this.loadDetailPB.setMessage("Loading details...");
        this.loadDetailPB.show();
        this.deviceList = FirebaseDatabase.getInstance().getReference().child("Device_Details");
        loadDetails();
    }
    private void loadDetails() {
        this.adapter = new FirebaseRecyclerAdapter<DeviceDetail, DeviceDetailViewHolder>(DeviceDetail.class, R.layout.device_detail_layout, DeviceDetailViewHolder.class, this.deviceList) {

            /* renamed from: com.hello.one.dr_admin.ConnectActivity$1$2 */

            protected void populateViewHolder(DeviceDetailViewHolder viewHolder, final DeviceDetail model, int position) {
                ConnectActivity.this.loadDetailPB.dismiss();
                viewHolder.ownerName.setText(model.getownerName());
                viewHolder.deviceID.setText(model.getid());
                viewHolder.eardetail.setText(model.getear());
                viewHolder.freqDetail.setText(model.getfrequency());
                viewHolder.dbDetail.setText(model.getdb_Value());
                viewHolder.freqValueDetail.setText(model.getfrequency_Value());
                viewHolder.sessionDetail.setText(model.getSession());
                viewHolder.timerDetail.setText(model.getTimer());
                viewHolder.volumeDetail.setText(model.getVolume());
                viewHolder.updateDateTV.setText("Update Date: "+model.getUpdation_time());
                viewHolder.connectionStatusTV.setText(model.getConnection_status());

                viewHolder.editSettings.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(ConnectActivity.this, DeviceBluetoothSettingActivity.class);
                        i.putExtra("DeviceID", model.getid());
                        Log.e("ID2", model.getid());
                        ConnectActivity.this.startActivity(i);
                    }
                });
                viewHolder.updateNowButton.setOnClickListener(new OnClickListener() {
                    public void onClick(View v) {

                    }
                });
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void Onclick(View view, int position, boolean z) {
                        Log.e("Click","Item: "+position);
                    }
                });
            }
        };
        this.deviceDetailRV.setAdapter(this.adapter);
    }

}
