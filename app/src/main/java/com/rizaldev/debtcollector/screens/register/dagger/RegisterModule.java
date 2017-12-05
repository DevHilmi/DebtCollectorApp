package com.rizaldev.debtcollector.screens.register.dagger;

import android.content.Context;

import com.rizaldev.debtcollector.api.DebtApi;
import com.rizaldev.debtcollector.screens.login.LoginActivity;
import com.rizaldev.debtcollector.screens.login.dagger.LoginScope;
import com.rizaldev.debtcollector.screens.register.BiodataActivity;
import com.rizaldev.debtcollector.screens.register.RegisterActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by devel on 5/12/2017.
 */
@Module
public class RegisterModule {
    BiodataActivity biodataActivity;

    public RegisterModule(BiodataActivity biodataActivity) {
        this.biodataActivity = biodataActivity;
    }
    @RegisterScope
    @Provides
    BiodataActivity provideAPI(DebtApi api, Context context) {
        return new BiodataActivity(api,biodataActivity);
    }
}
