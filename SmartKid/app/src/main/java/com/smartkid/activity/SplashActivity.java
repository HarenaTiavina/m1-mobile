package com.smartkid.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.smartkid.MainActivity;
import com.smartkid.R;

public class SplashActivity extends AppCompatActivity {
    Animation top, bottom;
    ImageView logo;
    TextView appName;
    LottieAnimationView animationView;

    final int SPLASH_SCREEN_DURATION = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initComponent();
        initAnimation();
        goToMainActivity();
    }

    private void initComponent(){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        top = AnimationUtils.loadAnimation(this, R.anim.spash_top);
        bottom = AnimationUtils.loadAnimation(this, R.anim.splash_bottom);
        logo = findViewById(R.id.splashScreenLogo);
        appName = findViewById(R.id.splashScreenAppName);
        animationView = findViewById(R.id.splashScreenAnimation);
    }

    private void initAnimation(){
        logo.setAnimation(top);
        appName.setAnimation(top);
        animationView.setAnimation(bottom);
    }

    private void goToMainActivity(){
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_SCREEN_DURATION);
    }
}