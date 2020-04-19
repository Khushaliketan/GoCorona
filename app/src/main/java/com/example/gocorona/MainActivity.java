package com.example.gocorona;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView starttrace,gettraceduser,getreportsbtn,getchatbtn,gethelpbtn,getaboutbtn,setcameraIDbtn,getfootagebtn;
    TextView textstarttrace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        starttrace=findViewById(R.id.startTrace);
        textstarttrace=findViewById(R.id.textStartTrace);
        gettraceduser=findViewById(R.id.getTraced);
        getreportsbtn=findViewById(R.id.getReportsButton);
        getchatbtn=findViewById(R.id.chatButton);
        gethelpbtn=findViewById(R.id.helpButton);
        getaboutbtn=findViewById(R.id.aboutButton);
        setcameraIDbtn = findViewById(R.id.addcamera);
        getfootagebtn = findViewById(R.id.getfootage);

        traceFunction();
        reportsFunctions();
        chatFunction();
        helpFunction();
        aboutFunction();
        setcameraID();
        getfootage();
    }


    private void getfootage(){
        getfootagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),cctv.class);
                startActivity(i);


            }
        });
    }


    private void setcameraID(){
        setcameraIDbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),AddCamera.class);
                startActivity(i);


            }
        });
    }


    private void aboutFunction() {
        getaboutbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),About.class);
                        startActivity(i);
                    }
                }
        );
    }

    private void helpFunction() {
        gethelpbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Intent i=new Intent(getApplicationContext(),GetHelp.class);
                        //startActivity(i);
                        //https://swachhnoida.000webhostapp.com/gocorona/%23IndiaFightsCorona.html
                        Intent i=new Intent(MainActivity.this,WebsiteView.class);
                        i.putExtra("url","https://swachhnoida.000webhostapp.com/gocorona/%23IndiaFightsCorona.html");
                        startActivity(i);
                    }
                }
        );
    }

    private void chatFunction() {
        getchatbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),WebsiteView.class);
                        i.putExtra("url","https://covid.apollo247.com/?utm_source=linkedin&utm_medium=organic&utm_campaign=bot_scanner");
                        startActivity(i);
                    }
                }
        );
    }

    private void reportsFunctions() {
        getreportsbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),Reports.class);
                        //i.putExtra("url","https://www.worldometers.info/coronavirus/");
                        startActivity(i);
                    }
                }
        );
    }

    private void traceFunction() {
        starttrace.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(MainActivity.this,Trace.class);
                        startActivity(i);
                    }
                }
        );

        gettraceduser.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(MainActivity.this,GetTracedUser.class);
                        startActivity(i);
                    }
                }
        );
    }

    public void traceFunctionText(View view) {
        Intent i=new Intent(MainActivity.this,Trace.class);
        startActivity(i);
    }

    public void getTraceFunctionText(View view) {
        Intent i=new Intent(MainActivity.this,GetTracedUser.class);
        startActivity(i);
    }

    public void getReports(View view){
        Intent i=new Intent(getApplicationContext(),Reports.class);
        //i.putExtra("url","https://www.worldometers.info/coronavirus/");
        startActivity(i);
    }

    public void getChatFunctionText(View view) {
        Intent i=new Intent(getApplicationContext(),WebsiteView.class);
        i.putExtra("url","https://covid.apollo247.com/?utm_source=linkedin&utm_medium=organic&utm_campaign=bot_scanner");
        startActivity(i);
    }

    public void getHelpFunctionText(View view) {
        Intent i=new Intent(getApplicationContext(),GetHelp.class);
        startActivity(i);
    }

    public void getAboutFunctionText(View view) {
        Intent i=new Intent(getApplicationContext(),About.class);
        startActivity(i);
    }
}
