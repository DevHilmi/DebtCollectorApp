package com.rizaldev.debtcollector.screens.login.dagger;

import com.rizaldev.debtcollector.screens.login.LoginActivity;
import com.rizaldev.debtcollector.screens.splash.dagger.SplashScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by devel on 11/11/2017.
 */
@Module
public class LoginContextModule {
    LoginActivity loginContext;

    public LoginContextModule(LoginActivity context) {
        this.loginContext = context;
    }
    @LoginScope
    @Provides
    LoginActivity provideLoginContext() {
        return loginContext;
    }
}
