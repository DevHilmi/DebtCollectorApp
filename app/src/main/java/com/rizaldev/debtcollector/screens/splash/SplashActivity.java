package com.rizaldev.debtcollector.screens.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rizaldev.debtcollector.application.AppController;
import com.rizaldev.debtcollector.screens.login.LoginActivity;
import com.rizaldev.debtcollector.screens.splash.core.SplashPresenter;
import com.rizaldev.debtcollector.screens.splash.core.SplashView;
import com.rizaldev.debtcollector.screens.splash.dagger.DaggerSplashComponent;
import com.rizaldev.debtcollector.screens.splash.dagger.SplashContextModule;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity  {

    @Inject
    SplashPresenter splashPresenter;
    @Inject
    SplashView splashView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSplashComponent.builder().
                appComponent(AppController.getNetComponent()).
                splashContextModule(new SplashContextModule(this)).
                build().inject(this);
        setContentView(splashView.constructView());
        splashPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }

    public void navigateToLogin() {
        Intent mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
        SplashActivity.this.startActivity(mainIntent);
        SplashActivity.this.finish();
    }

}
