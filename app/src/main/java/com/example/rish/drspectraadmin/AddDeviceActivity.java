package com.example.rish.drspectraadmin;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddDeviceActivity extends AppCompatActivity {

    private RadioGroup freqRG,earRG,modeRG;
    private TextInputEditText soundET,volET,idET,nameET;
    private Spinner sessionSpinner,timerSpinner;
    private String device_id = "";
    private Map<String, Object> editDetailMap = new HashMap();
    private String session[] = new String[]{"20","30","40","50","60","70","80","90","100","110","120","130","140","150","160","170","180","190","200","210","220","230","240","250"};
    private String timer[] = new String[]{"5","10","15","20","25","30","35","40","45",};
    private String sessionStatus = "50",timerStatus = "15";
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddevice);
        add = findViewById(R.id.addDeviceconnectBT);
        freqRG = findViewById(R.id.addDevicefrequencyRG);
        earRG = findViewById(R.id.addDeviceearRG);
        modeRG = findViewById(R.id.addDevicemodeRG);
        soundET = findViewById(R.id.addDeviceSoundET);
        volET = findViewById(R.id.addDevicevolumeET);
        sessionSpinner = findViewById(R.id.addDeviceSessionET);
        timerSpinner = findViewById(R.id.addDeviceTimerET);
        nameET = findViewById(R.id.addDeviceOwenerNameET);
        idET = findViewById(R.id.addDeviceIDET);

        ArrayAdapter<String> sessionadapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,session);
        sessionadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sessionSpinner.setAdapter(sessionadapter);

        ArrayAdapter<String> timeradapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,timer);
        timeradapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timerSpinner.setAdapter(timeradapter);

        sessionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sessionStatus = session[position];
                editDetailMap.put("session", sessionStatus);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        timerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                timerStatus = timer[position];
                editDetailMap.put("timer", timerStatus);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    if(soundET.getText().toString().isEmpty())
                        soundET.setError("Sound can not be empty");
                    else if(volET.getText().toString().isEmpty())
                        volET.setError("Volume can not be empty");
                    else if(Integer.parseInt(soundET.getText().toString())>10)
                        soundET.setError("Sound should be in range of 1-10");
                    else if(Integer.parseInt(volET.getText().toString())>21)
                        volET.setError("Volume should be in range of 1-21");
                    else if(idET.getText().toString().isEmpty())
                        idET.setError("ID can not be empty");
                    else if(nameET.getText().toString().isEmpty())
                        nameET.setError("Owner name can not be empty");

                    else {
                        String freq = "$,1",ear = "1",mode = "1",vol,sound,query;
                        switch(freqRG.getCheckedRadioButtonId()){

                            case R.id.addDeviceRB11:
                                freq = "$,1";
                                editDetailMap.put("frequency", "T1");
                                break;

                            case R.id.addDeviceRB12:
                                freq = "$,2";
                                editDetailMap.put("frequency", "T2");
                                break;
                            case R.id.addDeviceRB13:
                                freq = "$,3";
                                editDetailMap.put("frequency", "T3");
                                break;
                        }

                        switch(earRG.getCheckedRadioButtonId()){

                            case R.id.addDeviceRB21:
                                ear = "1";
                                editDetailMap.put("ear", "Left");
                                break;

                            case R.id.addDeviceRB22:
                                ear = "2";
                                editDetailMap.put("ear", "Right");
                                break;
                            case R.id.addDeviceRB23:
                                ear = "3";
                                editDetailMap.put("ear", "Both");
                                break;
                        }

                        switch(modeRG.getCheckedRadioButtonId()){

                            case R.id.addDeviceRB31:
                                mode = "1";
                                break;

                            case R.id.addDeviceRB32:
                                mode = "2";
                                break;
                        }

                        sound = soundET.getText().toString();
                        editDetailMap.put("db_Value", sound);

                        //session = sessionET.getText().toString();
                        //editDetailMap.put("session", session);

                        //timer = timerET.getText().toString()+",#";
                        //editDetailMap.put("timer", timerET.getText().toString());

                        vol = volET.getText().toString();
                        editDetailMap.put("volume", vol);

                        query = freq+","+ear+","+sound+","+vol+","+sessionStatus+","+mode+","+timerStatus+",$";
                        editDetailMap.put("Query",query);
                        editDetailMap.put("id", idET.getText().toString());
                        editDetailMap.put("ownerName", nameET.getText().toString());
                        device_id = idET.getText().toString();

                        FirebaseDatabase.getInstance().getReference().child("Device_Details").child(device_id).setValue(editDetailMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                msg("Device Added");

                                FirebaseDatabase.getInstance().getReference().child("Device_Details").child(device_id)
                                        .child("updation_time")
                                        .setValue(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));

                                onBackPressed();
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        msg("Device not added. Check Network connection");
                                    }
                                });
                        //btSocket.getOutputStream().write(query.getBytes());

                    }
                }
                catch (Exception e)
                {
                    Log.e("updateError", e.getMessage());
                    msg("Error");
                }

            }
        });
    }


    private void msg(String s)
    {
        Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
    }

}
