package com.rizaldev.debtcollector.screens.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rizaldev.debtcollector.application.AppController;
import com.rizaldev.debtcollector.screens.login.core.LoginPresenter;
import com.rizaldev.debtcollector.screens.login.core.LoginView;
import com.rizaldev.debtcollector.screens.login.dagger.DaggerLoginComponent;
import com.rizaldev.debtcollector.screens.login.dagger.LoginContextModule;
import com.rizaldev.debtcollector.screens.main.MainActivity;
import com.rizaldev.debtcollector.screens.register.RegisterActivity;

import javax.inject.Inject;



public class LoginActivity extends AppCompatActivity {
    @Inject
    LoginPresenter loginPresenter;
    @Inject
    LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerLoginComponent.builder().appComponent(AppController.getNetComponent()).loginContextModule(new LoginContextModule(this)).build().inject(this);
        setContentView(loginView.constructView());
        loginPresenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    public void navigateToRegister() {
        Intent mainIntent = new Intent(LoginActivity.this, RegisterActivity.class);
        LoginActivity.this.startActivity(mainIntent);
        LoginActivity.this.finish();
    }

    public void navigateToMain() {
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.startActivity(mainIntent);
        LoginActivity.this.finish();
    }
}
