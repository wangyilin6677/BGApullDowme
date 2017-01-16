package com.learn.bgapulldowme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.learn.bgapulldowme.ui.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button btn;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        btn = getViewById(R.id.btn);
    }

    @Override
    protected void setListener() {
        btn.setOnClickListener(this);
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {

    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId())
        {
            case R.id.btn:
                showLoadingDialog();
                break;
        }

    }
}
