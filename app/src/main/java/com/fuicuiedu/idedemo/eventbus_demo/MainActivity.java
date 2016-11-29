package com.fuicuiedu.idedemo.eventbus_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //注册eventBus
        EventBus.getDefault().register(this);

        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn_try);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event){
        String msg = "onEvent接受到了消息：" + event.getMessage();
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();

        tv.setText(msg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //反注册eVentBus
        EventBus.getDefault().unregister(this);
    }


}
