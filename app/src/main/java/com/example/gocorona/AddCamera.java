package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class AddCamera extends AppCompatActivity {

    EditText getID,getURL;
    Button ADD;
    String ID;
    String URL;
    DatabaseConnectivity db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_camera);

        initUI();
        updatingDB();
    }

    public void initUI(){
        getID = findViewById(R.id.getID);
        getURL = findViewById(R.id.getURL);
        ADD = findViewById(R.id.add);
        db=new DatabaseConnectivity(getApplicationContext());
    }


    public void updatingDB(){
        ADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                ID = String.valueOf(getID.getText());
                URL = String.valueOf(getURL.getText());
                db.addcamera(ID,URL);
                    Toast.makeText(getApplicationContext(),"Camera Added",Toast.LENGTH_SHORT).show();

            }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"SOME ERROR OCCURED",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
