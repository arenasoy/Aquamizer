package com.app.aquamizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    //TODO fix
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent goToTips = new Intent(SplashActivity.this, TipsActivity.class);
        startActivity(goToTips);
        finish();

    }
}