package com.smartkid.ui.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smartkid.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initComponent(savedInstanceState);
    }

    private void initComponent(Bundle savedInstanceState){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Préférences");
        actionBar.setDisplayHomeAsUpEnabled(true);

        if (findViewById(R.id.idFrameLayout) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getFragmentManager().beginTransaction().add(R.id.idFrameLayout, new SettingsFragment()).commit();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}