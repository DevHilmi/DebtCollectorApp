package com.rizaldev.debtcollector.screens.login.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.rizaldev.debtcollector.R;
import com.rizaldev.debtcollector.screens.login.LoginActivity;

import butterknife.ButterKnife;

/**
 * Created by devel on 11/11/2017.
 */

public class LoginView {
    private View view;
    public LoginView(LoginActivity context) {
        context.requestWindowFeature(Window.FEATURE_NO_TITLE);
        context.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_login, parent, true);
        ButterKnife.bind(this, view);
    }
    public View constructView() {
        return view;
    }
}
