package com.rizaldev.debtcollector.api;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by devel on 4/12/2017.
 */

public class DebtPref {
    public static String SHAREDPREF_KEY_TOKEN = "token";
    public static String SHAREDPREF_KEY_NAME = "name";
    public static String SHAREDPREF_KEY_EMAIL = "email";
    public static String SHAREDPREF_KEY_DEBT = "debt";
    public static String SHAREDPREF_KEY_CREDIT = "credit";
    public static void saveTokenPref(String token,Context context){
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(DebtPref.SHAREDPREF_KEY_TOKEN, token).apply();
    }
    public static String getTokenPref(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context).getString(SHAREDPREF_KEY_TOKEN, "failed");
    }
    public static void saveNamePref(String name,Context context){

    }
    public static void getNamePref(String name,Context context){

    }
    public static void saveEmailPref(String name,Context context){

    }
    public static void getEmailPref(String name,Context context){

    }
    public static void saveDebtPref(String name,Context context){

    }
    public static void getDebtPref(String name,Context context){

    }
    public static void saveCreditPref(String name,Context context){

    }
    public static void getCreditPref(String name,Context context){

    }
}
