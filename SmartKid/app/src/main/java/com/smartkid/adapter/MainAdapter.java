package com.smartkid.adapter;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.smartkid.ui.fragment.LoginFragment;
import com.smartkid.ui.fragment.RegisterFragment;

public class MainAdapter extends FragmentPagerAdapter {
    private Context context;
    int nbreTabs;

    public MainAdapter(FragmentManager fm, Context context, int nbreTabs){
        super(fm);
        this.context = context;
        this.nbreTabs = nbreTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new RegisterFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nbreTabs;
    }
}
