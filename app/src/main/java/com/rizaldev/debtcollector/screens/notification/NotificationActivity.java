package com.rizaldev.debtcollector.screens.notification;

import android.app.Notification;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.rizaldev.debtcollector.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.SmartAdapter;
import retrofit2.http.POST;

public class NotificationActivity extends AppCompatActivity {
    @BindView(R.id.list_view)
    RecyclerView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        ButterKnife.bind(this);
        initView();

    }

    public void initView() {
        listView.setLayoutManager(new LinearLayoutManager(this));
        List<Request> list = new ArrayList<>();
        Request entry = new Request("Billy Kaleb", "12ribu desu");
        list.add(entry);
        Request entry2 = new Request("Hilmi", "2ribu desu");
        list.add(entry2);
        SmartAdapter.items(list)
                .map(Request.class, NotificationView.class)
                .into(listView);

    }

}
