package com.rizaldev.debtcollector.screens.login.core;

import android.support.design.widget.Snackbar;
import android.util.Log;
import android.widget.Toast;

import com.rizaldev.debtcollector.api.DebtApi;
import com.rizaldev.debtcollector.models.User;
import com.rizaldev.debtcollector.utils.UiUtils;
import com.rizaldev.debtcollector.utils.rx.RxSchedulers;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter {
    private LoginView view;
    private LoginModel model;
    private RxSchedulers rxSchedulers;
    private CompositeDisposable subscriptions;
    private DebtApi api;
    public LoginPresenter(LoginView view, LoginModel model, RxSchedulers schedulers, CompositeDisposable subscriptions,DebtApi api) {
        this.view = view;
        this.model = model;
        this.subscriptions = subscriptions;
        this.rxSchedulers = schedulers;
        this.api = api;
    }
    public void onCreate() {
            respondLoginClick();
            respondRegisterClick();
    }

    private void respondLoginClick() {
        view.buttonLoginClick().subscribe(aVoid ->{
            view.showLoading("Sign in","Please Wait");
            api.login(view.editTextUsername.getText().toString(),view.editTextPassword.getText().toString()).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    User user = response.body();
                    if(user.getStatus().equals("success")){
                        model.saveToken(user.getToken());
                        view.dismissLoading();
                        model.navigateToMain();
                    }else {
                        view.dismissLoading();
                        UiUtils.showSnackbar(view.constructView(),"Username atau Password salah", Snackbar.LENGTH_LONG);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    view.dismissLoading();
                    Log.d("go here",t.getMessage());
                }
            });

        } );
    }
    private void respondRegisterClick(){
        view.buttonRegisterClick().subscribe(aVoid -> model.navigateToRegister());
    }

    public void onDestroy(){
        subscriptions.clear();
    }
}
