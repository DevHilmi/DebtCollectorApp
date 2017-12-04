package com.rizaldev.debtcollector.screens.login.core;

import com.rizaldev.debtcollector.screens.splash.core.SplashModel;
import com.rizaldev.debtcollector.screens.splash.core.SplashView;
import com.rizaldev.debtcollector.utils.rx.RxSchedulers;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by devel on 11/11/2017.
 */

public class LoginPresenter {
    private LoginView view;
    private LoginModel model;
    private RxSchedulers rxSchedulers;
    private CompositeDisposable subscriptions;
    public LoginPresenter(LoginView view, LoginModel model, RxSchedulers schedulers, CompositeDisposable subscriptions) {
        this.view = view;
        this.model = model;
        this.subscriptions = subscriptions;
    }
    public void onCreate() {

    }

    public void onDestroy(){
        subscriptions.clear();
    }
}
