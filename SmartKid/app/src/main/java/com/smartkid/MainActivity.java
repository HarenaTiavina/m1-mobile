package com.smartkid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.smartkid.ui.activity.LoaderDialog;
import com.smartkid.ui.activity.MainAdapter;
import com.smartkid.ui.activity.MainViewModel;
import com.smartkid.ui.fragment.LogProfile;
import com.smartkid.ui.fragment.LoginFragment;
import com.smartkid.ui.fragment.RegisterFragment;
import com.smartkid.ui.fragment.RegisterProfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initTab();
    }

    private void init(){
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);;
        mainViewModel.setLoader(new LoaderDialog(this));
    }

    private void initTab(){
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.main_tab_layout);

        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(mainAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Se connecter");
        tabLayout.getTabAt(1).setText("S'inscrire");
    }
}
