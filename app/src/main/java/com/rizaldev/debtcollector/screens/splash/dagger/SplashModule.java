package com.rizaldev.debtcollector.screens.splash.dagger;

import com.rizaldev.debtcollector.api.DebtApi;
import com.rizaldev.debtcollector.screens.splash.SplashActivity;
import com.rizaldev.debtcollector.screens.splash.core.SplashModel;
import com.rizaldev.debtcollector.screens.splash.core.SplashPresenter;
import com.rizaldev.debtcollector.screens.splash.core.SplashView;
import com.rizaldev.debtcollector.utils.rx.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by devel on 23/10/2017.
 */

@Module
public class SplashModule {


    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers,SplashView view ,SplashModel model){
        CompositeDisposable subscriptions = new CompositeDisposable();
       return new SplashPresenter(view,model, schedulers, subscriptions);
    }

    @SplashScope
    @Provides
    SplashView provideSplashView(SplashActivity context) {
        return new SplashView(context);
    }


    @SplashScope
    @Provides
    SplashModel provideSplashModel(SplashActivity context) {
        return new SplashModel(context);
    }
}
