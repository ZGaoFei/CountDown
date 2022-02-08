package com.demo.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.countdownlibrary.CountDownManager;
import com.demo.countdownlibrary.TimeCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv60;
    private TextView tv30;
    private TextView tv45;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        tv60 = findViewById(R.id.tv_60s);
        tv30 = findViewById(R.id.tv_30s);
        tv45 = findViewById(R.id.tv_45s);
        findViewById(R.id.tv_cancel).setOnClickListener(this);
        tv60.setOnClickListener(this);
        tv30.setOnClickListener(this);
        tv45.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_60s) {
            CountDownManager.getInstance().addCountDown(60, new TimeCallback() {
                @Override
                public void onTime(int time) {
                    tv60.setText("当前时间(60)：" + time);
                }

                @Override
                public void timeUp() {
                    tv60.setText("当前时间(60)：结束");
                }
            });
        } else if (v.getId() == R.id.tv_45s) {
            CountDownManager.getInstance().addCountDown("45s", 45, new TimeCallback() {
                @Override
                public void onTime(int time) {
                    tv45.setText("当前时间(45)：" + time);
                }

                @Override
                public void timeUp() {
                    tv45.setText("当前时间(45)：结束");
                }
            });
        } else if (v.getId() == R.id.tv_30s) {
            CountDownManager.getInstance().addCountDown("30s", 30, new TimeCallback() {
                @Override
                public void onTime(int time) {
                    tv30.setText("当前时间(30)：" + time);
                }

                @Override
                public void timeUp() {
                    tv30.setText("当前时间(30)：结束");
                }
            });
        } else if (v.getId() == R.id.tv_cancel) {
            CountDownManager.getInstance().cancelTime("45s");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        CountDownManager.getInstance().destroy();
    }
}