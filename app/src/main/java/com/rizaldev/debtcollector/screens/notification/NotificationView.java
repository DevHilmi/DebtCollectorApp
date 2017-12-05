package com.rizaldev.debtcollector.screens.notification;

import android.content.Context;

import com.rizaldev.debtcollector.R;

import io.nlopez.smartadapters.views.BindableLinearLayout;
import io.nlopez.smartadapters.views.BindableRelativeLayout;

/**
 * Created by devel on 5/12/2017.
 */

public class NotificationView extends BindableRelativeLayout<Request> {
    public NotificationView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.view_request;
    }

    @Override
    public void bind(Request request) {

    }
}
