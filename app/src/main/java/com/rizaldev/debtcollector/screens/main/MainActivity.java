package com.rizaldev.debtcollector.screens.main;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import com.rizaldev.debtcollector.R;
import com.rizaldev.debtcollector.screens.history.HistoryFragment;
import com.rizaldev.debtcollector.screens.home.HomeFragment;
import com.rizaldev.debtcollector.screens.notification.NotificationActivity;
import com.rizaldev.debtcollector.screens.profile.ProfileFragment;
import com.rizaldev.debtcollector.utils.UiUtils;
import com.roughike.bottombar.BottomBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;
    View actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = UiUtils.getActionBar(this, "Debt Collector", false, true);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportFragmentManager().beginTransaction().add(R.id.contentContainer, new HomeFragment()).commit();
        bottomBar.setOnTabSelectListener(tabId -> {
            if (tabId == R.id.tab_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new HomeFragment()).commit();
            } else if (tabId == R.id.tab_history) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new HistoryFragment()).commit();
            } else if (tabId == R.id.tab_profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contentContainer, new ProfileFragment()).commit();
            }
        });
        setNotificationCount(10);
        ImageButton notification = actionBar.findViewById(R.id.buttonRight);
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setNotificationCount(int count) {
        TextView textNotificationCount = actionBar.findViewById(R.id.textNotificationCount);
        if (count != 0) {
            textNotificationCount.setVisibility(View.VISIBLE);
        } else {
            textNotificationCount.setVisibility(View.INVISIBLE);
        }
        textNotificationCount.setText(String.valueOf(count));
    }
}
