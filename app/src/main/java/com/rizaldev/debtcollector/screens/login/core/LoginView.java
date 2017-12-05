package com.rizaldev.debtcollector.screens.login.core;

import android.app.ProgressDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.rizaldev.debtcollector.R;
import com.rizaldev.debtcollector.screens.login.LoginActivity;
import com.rizaldev.debtcollector.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;



public class LoginView {
    @BindView(R.id.editTextUsername)
    EditText editTextUsername;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;
    @BindView(R.id.buttonLogin)
    Button buttonLogin;
    @BindView(R.id.buttonRegister)
    TextView buttonRegister;
    private View view;
    LoginActivity context;
    ProgressDialog progressDialog;
    public LoginView(LoginActivity context) {
        this.context = context;
        context.requestWindowFeature(Window.FEATURE_NO_TITLE);
        context.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_login, parent, true);
        ButterKnife.bind(this, view);
    }
    io.reactivex.Observable<Object> buttonLoginClick(){
        return RxView.clicks(buttonLogin);
    }

    io.reactivex.Observable<Object> buttonRegisterClick(){
        return RxView.clicks(buttonRegister);
    }
    public void showLoading(String title,String mesage){
        progressDialog = UiUtils.showLoading(context,title,mesage);
    }
    public void dismissLoading(){
        UiUtils.dismissLoading(progressDialog);
    }
    public View constructView() {
        return view;
    }
}
