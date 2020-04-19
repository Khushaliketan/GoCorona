package com.example.gocorona;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseConnectivity extends SQLiteOpenHelper {

    public static String name="GoCorona.db";
    public DatabaseConnectivity(Context context) {
        super(context, name, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tracedUser(DEVICE_NAME TEXT, DEVICE_ADDRESS TEXT, DATE TEXT)");
        db.execSQL("create table cameradetails(CAMERA_ID TEXT,CAMERA_URL TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addcamera(String ID , String URL){
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();
        Log.d("Inside Database",""+ID+" "+URL);
        cv.put("CAMERA_ID",ID);
        cv.put("CAMERA_URL",URL);
        db.insert("cameradetails",null,cv);

    }



    public Cursor getCameraList(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from cameradetails",null);
        return c;
    }







    public void addTracedUser(String dname,String daddress){
    SQLiteDatabase db=getWritableDatabase();
    ContentValues cv=new ContentValues();
    Log.d("Inside Database",""+dname+" "+daddress);
    cv.put("DEVICE_NAME",dname);
    cv.put("DEVICE_ADDRESS",daddress);

    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    String strDate = dateFormat.format(date);

    cv.put("DATE",strDate);

    db.insert("tracedUser",null,cv);

    }

    public Cursor getTracedUser(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.rawQuery("select * from tracedUser",null);

        return c;
    }

}
