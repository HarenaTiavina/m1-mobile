package com.smartkid.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.smartkid.ui.fragment.InscriptionProfilFragment;
import com.smartkid.ui.fragment.ListeProfilFragment;

public class ProfilAdapter extends FragmentPagerAdapter {
    private Context context;
    int nbreTabs;

    public ProfilAdapter(FragmentManager fm, Context context, int nbreTabs){
        super(fm);
        this.context = context;
        this.nbreTabs = nbreTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ListeProfilFragment();
            case 1:
                return new InscriptionProfilFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nbreTabs;
    }
}
