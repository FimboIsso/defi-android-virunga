package com.issonet.virunga.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;

import com.issonet.virunga.MainActivity;
import com.issonet.virunga.R;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        startApplication();
    }


    private void startApplication(){

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Looper.prepare();
                    sleep(1500);

                    startActivity(new Intent(splashScreen.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }
}