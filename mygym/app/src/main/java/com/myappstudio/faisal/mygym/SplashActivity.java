package com.myappstudio.faisal.mygym;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView emblem1 = (TextView)findViewById(R.id.emblem1);
        TextView emblem2 = (TextView)findViewById(R.id.emblem2);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Organo.ttf");

        emblem1.setTypeface(custom_font);
        emblem2.setTypeface(custom_font);

        emblem1.startAnimation(AnimationUtils.loadAnimation(SplashActivity.this, android.R.anim.slide_in_left));
        emblem2.startAnimation(AnimationUtils.loadAnimation(SplashActivity.this, android.R.anim.slide_in_left));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.SplashScreenAccent));
        }

        new Handler().postDelayed(new Runnable() {


            //* Showing splash screen with a timer. This will be useful when you
            //* want to show case your app logo / company


            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashActivity.this, GymMainMenuActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 3000);
    }
}
