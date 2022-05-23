package com.smartkid.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.smartkid.R;
import com.smartkid.adapter.MainAdapter;
import com.smartkid.adapter.ProfilAdapter;
import com.smartkid.models.Profil;

public class ChoixProfilActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_profil);
        initComponent();
        initTab();
    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        getMenuInflater().inflate(R.menu.menu_profil, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {
        switch (item.getItemId()){
            case R.id.settings:
                Intent intent = new Intent(ChoixProfilActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initComponent(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_profil);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Profils");
    }

    private void initTab(){
        viewPager = findViewById(R.id.viewPager_profil);
        tabLayout = findViewById(R.id.main_tab_layout_profil);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        ProfilAdapter profilAdapter = new ProfilAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(profilAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Tous");
        tabLayout.getTabAt(1).setText("Créer nouveau");
    }
}