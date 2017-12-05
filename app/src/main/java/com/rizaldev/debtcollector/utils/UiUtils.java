package com.rizaldev.debtcollector.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;

import timber.log.Timber;
import android.support.design.widget.Snackbar;
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

}
