package com.rizaldev.debtcollector.screens.login.dagger;

import com.rizaldev.debtcollector.api.DebtApi;
import com.rizaldev.debtcollector.screens.login.LoginActivity;
import com.rizaldev.debtcollector.screens.login.core.LoginModel;
import com.rizaldev.debtcollector.screens.login.core.LoginPresenter;
import com.rizaldev.debtcollector.screens.login.core.LoginView;

import com.rizaldev.debtcollector.screens.splash.dagger.SplashScope;
import com.rizaldev.debtcollector.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by devel on 11/11/2017.
 */


@Module
public class LoginModule {

    LoginActivity loginActivity;

    public LoginModule(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
    }
    @LoginScope
    @Provides
    LoginPresenter providePresenter(RxSchedulers schedulers, LoginView view , LoginModel model,DebtApi api){
        CompositeDisposable subscriptions = new CompositeDisposable();
        return new LoginPresenter(view,model, schedulers, subscriptions,api);
    }

    @LoginScope
    @Provides
    LoginView provideSplashView() {
        return new LoginView(loginActivity);
    }


    @LoginScope
    @Provides
    LoginModel provideSplashModel( DebtApi api) {
        return new LoginModel(loginActivity,api);
    }
}

