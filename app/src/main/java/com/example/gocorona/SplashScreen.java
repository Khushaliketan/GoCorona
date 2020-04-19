package com.example.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        //getSupportActionBar().hide();

        SplashScreenShow s=new SplashScreenShow();
        s.start();
    }

    private class SplashScreenShow extends Thread{
        public void run()
        {
            try
            {
                sleep(2000);
            }
            catch (Exception e)
            {

            }
            Intent i=new Intent(SplashScreen.this, MainActivity.class);
            startActivity(i);
            SplashScreen.this.finish();
        }
    }
}
