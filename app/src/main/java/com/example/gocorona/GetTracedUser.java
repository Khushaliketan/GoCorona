package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class GetTracedUser extends AppCompatActivity {

    DatabaseConnectivity db;
    ListView traceddevices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_traced_user);

        db=new DatabaseConnectivity(getApplicationContext());

        traceddevices=findViewById(R.id.tracedDevices);

        ArrayList<String> itemTraced=new ArrayList<>();
        itemTraced.add("Device Name\tDevice Address\tTracing Date");
        Cursor c=db.getTracedUser();
        if(c.getCount()>0){
            String x="";
            while(c.moveToNext()){
                itemTraced.add(c.getString(0)+"\t"+c.getString(1)+"\t"+c.getString(2));
            }
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.textview,itemTraced);
            traceddevices.setAdapter(arrayAdapter);
        }






//        else{
//            tdata.setText("NULL");
//        }

    }
}
