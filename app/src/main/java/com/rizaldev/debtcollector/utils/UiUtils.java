package com.rizaldev.debtcollector.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import timber.log.Timber;
import android.support.design.widget.Snackbar;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rizaldev.debtcollector.R;

/**
 * Created by devel on 22/10/2017.
 */

public class UiUtils {

    public static void handleThrowable(Throwable throwable) {
        Timber.e(throwable, throwable.toString());
    }

    public static void showSnackbar(View view, String message, int length) {
        Snackbar.make(view, message, length).setAction("Action", null).show();
    }

    public static ProgressDialog showLoading(Context context, String title, String message){
        ProgressDialog progress = new ProgressDialog(context);
        progress.setTitle(title);
        progress.setMessage(message);
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        return progress;
    }

    public static void dismissLoading(ProgressDialog progressDialog){
        progressDialog.dismiss();
    }
    public static View getActionBar(AppCompatActivity activity, String title, boolean buttonLeftVisible, boolean buttonRightVisible){
        activity.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        activity.getSupportActionBar().setDisplayShowCustomEnabled(true);
        activity.getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View viewActionBar = activity.getSupportActionBar().getCustomView();
        ImageButton buttonLeft =viewActionBar.findViewById(R.id.buttonLeft);
        ImageButton buttonRight =viewActionBar.findViewById(R.id.buttonRight);
        TextView textViewTitle = viewActionBar.findViewById(R.id.textViewTitle);
        buttonLeft.setVisibility(buttonLeftVisible ? View.VISIBLE : View.INVISIBLE);
        buttonRight.setVisibility(buttonRightVisible ? View.VISIBLE : View.INVISIBLE);
        textViewTitle.setText(title.trim());
        return viewActionBar;
    }
}
