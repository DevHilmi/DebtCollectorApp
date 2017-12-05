package com.rizaldev.debtcollector.screens.login.dagger;

import com.rizaldev.debtcollector.application.builder.AppComponent;
import com.rizaldev.debtcollector.screens.login.LoginActivity;

import dagger.Component;

/**
 * Created by devel on 11/11/2017.
 */
@LoginScope
@Component(modules = {LoginModule.class}, dependencies = {AppComponent.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}
