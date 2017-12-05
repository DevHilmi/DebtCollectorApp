package com.rizaldev.debtcollector.api;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by devel on 4/12/2017.
 */

public class DebtPref {
    public static String SHAREDPREF_KEY_TOKEN = "token";
    public static void saveTokenPref(String token,Context context){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(DebtPref.SHAREDPREF_KEY_TOKEN, token).apply();
    }
    public static String getTokenPref(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(SHAREDPREF_KEY_TOKEN, "failed");
    }
}
