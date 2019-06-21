package com.example.rish.drspectraadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;


public class addPatientActivity extends AppCompatActivity {

    private LinearLayout LL1;
    private LinearLayout LL2;
    private LinearLayout LL3;
    private TextInputEditText P_Id;
    private RadioGroup RG1;
    private RadioGroup RG_Gender;
    private TextInputLayout TIL1;
    private Button addPatientButton;
    private TextInputEditText address;
    private TextInputEditText age;
    private CardView cv1;
    private CardView cv2;
    private CardView cv3;
    private CardView cv4;
    private CardView cv5;
    private CardView cv6;
    private CardView cv7;
    private TextInputEditText email;
    private TextInputEditText name;
    private TextInputEditText number;
    private Map<String, Object> patientDetailMap = new HashMap();
    private DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Patient_Details");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

         cv1 = (CardView) findViewById(R.id.patientDetailsCV);
         cv2 = (CardView) findViewById(R.id.audioLogicalCV);
//         cv3 = (CardView) findViewById(R.id.earHistoryCV);
//         cv4 = (CardView) findViewById(R.id.otherEarHistoryCV);
         cv5 = (CardView) findViewById(R.id.occupationCV);
         LL1 = (LinearLayout) findViewById(R.id.demographicDetailLL);
//         LL2 = (LinearLayout) findViewById(R.id.EarHistoryLL);
         LL3 = (LinearLayout) findViewById(R.id.occupationLL);
//         TIL1 = (TextInputLayout) findViewById(R.id.otherMedicalHistTIL);
         RG1 = (RadioGroup) findViewById(R.id.audiologyRG);
         RG_Gender = (RadioGroup) findViewById(R.id.audiologyRG);
         name = (TextInputEditText) findViewById(R.id.patientName);
         email = (TextInputEditText) findViewById(R.id.patientEmail);
         number = (TextInputEditText) findViewById(R.id.patientNumber);
         P_Id = (TextInputEditText) findViewById(R.id.patientID);
         age = (TextInputEditText) findViewById(R.id.patientAge);
         address = (TextInputEditText) findViewById(R.id.patientAddress);
         addPatientButton = (Button) findViewById(R.id.addPatientButton);



    }
}
