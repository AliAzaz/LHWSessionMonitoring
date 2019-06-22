package com.irfansyed.umeedenau.umeedenauMonitring;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import utils.MyPreferences;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);



     setContentView(R.layout.activity_splash_screen);

// Clear Old Data Irfan



        final MyPreferences preferences = new MyPreferences(this);
    //    if (preferences.getReq1() == null) {



     //   preferences.setReq1("http://192.168.1.116:61259///Testing/insert_monitoring");


        //   preferences.setReqLogin("http://192.168.1.116:61259///Testing/check_user_id");


      preferences.setReqLogin("http://43.245.131.159/cmapp/Testing/check_user_id");
      preferences.setReq1("http://43.245.131.159/cmapp/Testing/insert_monitoring");

     //   }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

// show login or main page
                Intent mainIntent;
                if (preferences.getUserId() == -1) {
                    //mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                } else {
                  //  mainIntent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                }
                    mainIntent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                   // mainIntent = new Intent(SplashScreenActivity.this, HomeActivity.class);

                    SplashScreenActivity.this.startActivity(mainIntent);
                    SplashScreenActivity.this.finish();
            }
        }, 1000);
    }



}
