package com.rizaldev.debtcollector.screens.utang_baru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rizaldev.debtcollector.R;
import com.rizaldev.debtcollector.screens.main.MainActivity;
import com.squareup.haha.perflib.Main;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailUtangBaruActivity extends AppCompatActivity {
    @BindView(R.id.buttonUtang)
    Button buttonUtang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_utang_baru);
        ButterKnife.bind(this);
        buttonUtang.setOnClickListener(v -> {
            Intent intent = new Intent(DetailUtangBaruActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
