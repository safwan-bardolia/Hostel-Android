package com.example.hostel;

//In this code handler is used to hold the screen for specific time and once the handler is out, our main Activity will be launched.
// We are going to hold the Splash screen for three second’s. We will define the seconds in millisecond’s after Post Delayed(){} method
//Post Delayed method will delay the time for 3 seconds. After the delay time is complete, then your main activity will be launched.


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}