package com.rizaldev.debtcollector.screens.notification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.rizaldev.debtcollector.R;
import com.rizaldev.debtcollector.models.User;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.nlopez.smartadapters.SmartAdapter;
import io.nlopez.smartadapters.adapters.MultiAdapter;

public class NotificationActivity extends AppCompatActivity {

    @BindView(R.id.listViewNotification)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<Request> list = new ArrayList<>();
        Request entry = new Request("Billy Kaleb", "12ribu desu");
        list.add(entry);
        Request entry2 = new Request("Hilmi", "2ribu desu");
        list.add(entry2);
        MultiAdapter adapter = SmartAdapter.empty().map(Request.class, NotificationView.class).into(listView);
        adapter.addItems(list);
    }
}
