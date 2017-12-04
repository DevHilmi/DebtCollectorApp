package com.rizaldev.debtcollector.screens.splash.core;

import com.rizaldev.debtcollector.utils.rx.RxSchedulers;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter {

    private SplashView view;
    private SplashModel model;
    private RxSchedulers rxSchedulers;
    private CompositeDisposable subscriptions;

    public SplashPresenter(SplashView view,SplashModel model, RxSchedulers schedulers, CompositeDisposable subscriptions) {
        this.view = view;
        this.model = model;
        this.rxSchedulers = schedulers;
        this.subscriptions = subscriptions;
    }

    public void onCreate() {
        subscriptions.add(model.delaySplash().doOnNext(o -> model.navigateToLogin()).subscribe());
        view.showAnimation(2000);
    }

    public void onDestroy() {
        subscriptions.clear();
    }

}
