package com.rizaldev.debtcollector.screens.register.dagger;

import com.rizaldev.debtcollector.application.builder.AppComponent;
import com.rizaldev.debtcollector.screens.login.LoginActivity;
import com.rizaldev.debtcollector.screens.register.BiodataActivity;

import dagger.Component;

/**
 * Created by devel on 5/12/2017.
 */

@RegisterScope
@Component(modules = {RegisterModule.class}, dependencies = {AppComponent.class})
public interface RegisterComponent {
    void inject(BiodataActivity activity);
}