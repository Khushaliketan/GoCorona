package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class cctv extends AppCompatActivity {

    DatabaseConnectivity db;
    ArrayList<String> cameraList;
    ListView cameralist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cctv);


        cameraList=new ArrayList<>();

        db=new DatabaseConnectivity(getApplicationContext());

        cameralist=findViewById(R.id.cameralist);


        cameraList.add("Camera ID\tCamera IP");
        Cursor c=db.getCameraList();
        if(c.getCount()>0){
            String x="";
            while(c.moveToNext()){
                cameraList.add(c.getString(1));
            }
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.textview,cameraList);
            cameralist.setAdapter(arrayAdapter);
        }
//
        cameralist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent i = new Intent(getApplicationContext(),WebsiteView.class);
                i.putExtra("url", String.valueOf(parent.getItemAtPosition(position)));
                startActivity(i);
                Toast.makeText(getApplicationContext(),String.valueOf(parent.getItemAtPosition(position)),Toast.LENGTH_LONG).show();
            }
        });

    }
}


