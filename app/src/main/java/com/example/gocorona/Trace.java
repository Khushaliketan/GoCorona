package com.example.gocorona;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Trace extends AppCompatActivity {
    Button bttrace,btstoptrace;
    BluetoothAdapter bluetoothAdapter;

    Intent btEnablingIntent;
    int requestCodeForEnable;

    DatabaseConnectivity db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trace);

        bttrace=findViewById(R.id.btTrace);
        btstoptrace=findViewById(R.id.btStopTrace);
        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        btEnablingIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        requestCodeForEnable=1;
        db=new DatabaseConnectivity(getApplicationContext());

        IntentFilter intentFilter=new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(myReceiver,intentFilter);

        btEnableMethod();
        btDisableMethod();
    }

    BroadcastReceiver myReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action=intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)){
                BluetoothDevice device=intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                Toast.makeText(getApplicationContext(),device.getName(),Toast.LENGTH_LONG).show();
                db.addTracedUser(device.getName(),device.getAddress());
            }
        }
    };

    private void btDisableMethod() {
        btstoptrace.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(bluetoothAdapter.isEnabled()){
                            bluetoothAdapter.disable();
                        }
                    }
                }
        );
    }

    private void btEnableMethod() {
        bttrace.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(bluetoothAdapter==null){
                            Toast.makeText(getApplicationContext(),"Bluetooth does not support on this device",Toast.LENGTH_LONG).show();
                        }
                        else {
                            if (!bluetoothAdapter.isEnabled()) {
                                startActivityForResult(btEnablingIntent, requestCodeForEnable);
                            }
                            else if(bluetoothAdapter.isEnabled()){
                                Toast.makeText(getApplicationContext(),"Tracing started",Toast.LENGTH_LONG).show();
                                recordTracing();
                            }
                        }
                    }
                }
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==requestCodeForEnable){
            if(resultCode==RESULT_OK){
                Toast.makeText(getApplicationContext(),"Bluetooth is Enabled. Tracing started",Toast.LENGTH_LONG).show();
                recordTracing();
            }
            else if(resultCode==RESULT_CANCELED){
                Toast.makeText(getApplicationContext(),"Bluetooth enabling is cancelled",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void recordTracing() {
        bluetoothAdapter.startDiscovery();
    }
}
