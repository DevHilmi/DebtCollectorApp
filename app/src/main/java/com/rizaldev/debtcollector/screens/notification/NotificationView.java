package com.rizaldev.debtcollector.screens.notification;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rizaldev.debtcollector.R;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableLinearLayout;
import io.nlopez.smartadapters.views.BindableRelativeLayout;

/**
 * Created by ASUS A46CM on 2017/12/05.
 */

public class NotificationView extends BindableRelativeLayout<Request> {

    @BindView(R.id.nameList)
    TextView name;

    @BindView(R.id.utangList)
    TextView utang;

    public NotificationView(Context context){
        super(context);
    }

    @Override
    public int getLayoutId() {
        // This is mandatory, and should return the id for the view layout of this view
        return R.layout.item_list;
    }

    @Override
    public void onViewInflated() {
        // Here we should assign the views or use ButterKnife
        ButterKnife.bind(this);
        // Fixes some horizontal fill layout
        setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void bind(Request request) {
        // In here we assign the model information values to our view widgets

        // Examples:
        name.setText(request.getName());
        utang.setText(request.getDebt());

        // and so on!
    }}
