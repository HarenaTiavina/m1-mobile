package com.smartkid.ui.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import com.smartkid.R;

public class LoaderDialog {
    private Activity activity;
    private AlertDialog alertDialog;

    public LoaderDialog(Activity activity){
        this.activity = activity;
        initAlertDialog();
    }

    private void initAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.fragment_loader, null));
        builder.setCancelable(true);
        alertDialog = builder.create();
    }

    public void show(){
        alertDialog.show();
    }

    public void dismiss(){
        alertDialog.dismiss();
    }
}
