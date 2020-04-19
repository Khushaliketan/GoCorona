package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class About extends AppCompatActivity {
    TextView abouttext;//aboutdev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        abouttext=findViewById(R.id.aboutText);
        //aboutdev=findViewById(R.id.aboutDeveloper);

        abouttext.setText("\n\n• Many people in world who suffer from normal cold have a confusion that they may be suffering from Covid-19, but mass PCR test is not possible in country like India, so need of alternate solution\n\n" +
                "• Very difficult to keep track of spread of Coronavirus as it spreads via human contact, very contagious which calls for need of systems capable of keeping track of past 15 days data by tracing and storing smart devices location which are in close proximity.This will prove beneficial to alert people, if someone is tested positive!\n\n"+
                "• Delay in verifying patients with positive cases due to not enough medical facilities.The World Health Organization (WHO) prescribes 1:1000 doctor-patient ratio and India is below that criteria. This burden can be reduced by building 24X7 chatbot for risk detection of COVID\n\n");

        //aboutdev.setText("\n\nApp created by:\n1. Ashish Basantani\n2. Anushree Jain\n\n");
    }
}
