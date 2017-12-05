package com.rizaldev.debtcollector.screens.login.core;

import android.preference.PreferenceManager;
import android.util.Log;

import com.rizaldev.debtcollector.api.DebtApi;
import com.rizaldev.debtcollector.api.DebtPref;
import com.rizaldev.debtcollector.models.User;
import com.rizaldev.debtcollector.screens.login.LoginActivity;

import io.reactivex.Observable;



public class LoginModel {
    LoginActivity context;
    DebtApi api;

    public LoginModel(LoginActivity context,DebtApi api) {
        this.context = context;
        this.api = api;
    }



//   Observable<User> loginObservable(String username, String password){
//       Log.d("miaw", "masuk sini 2");
//        return api.login(username,password);
//    }

    public void saveToken(String token){
        DebtPref.saveTokenPref(token,context);
    }
    public void navigateToMain() {
        context.navigateToMain();
    }
    public void navigateToRegister() {
        context.navigateToRegister();
    }

}
