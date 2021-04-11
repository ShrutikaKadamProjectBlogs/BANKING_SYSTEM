package com.Shrutika.bankingsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Screen extends Activity {

    TextView  app_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);


    

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startEnterAnimation();
            }
        }, 2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();

            }
        }, 5500);
    }

    private void startEnterAnimation() {

        app_name.setVisibility(View.VISIBLE);
    }
}

