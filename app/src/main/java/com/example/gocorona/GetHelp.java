package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GetHelp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_help);
    }

    public void viewMore(View view) {
        Intent i=new Intent(getApplicationContext(),WebsiteView.class);
        i.putExtra("url","https://drive.google.com/viewerng/viewer?embedded=true&url=https://paytm.com/offer/wp-content/uploads/2020/03/coronvavirus-state-helplinenumber.pdf");
        startActivity(i);
    }
}
