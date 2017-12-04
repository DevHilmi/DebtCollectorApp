package com.rizaldev.debtcollector.screens.login.core;

import com.rizaldev.debtcollector.screens.login.LoginActivity;

import io.reactivex.Observable;



public class LoginModel {
    LoginActivity context;

    public LoginModel(LoginActivity context) {
        this.context = context;
    }

    private boolean login(String username,String password){

        return false;
    }

   Observable<Boolean> loginObserable(String username, String password){
        return Observable.just(login(username,password));
    }

}
