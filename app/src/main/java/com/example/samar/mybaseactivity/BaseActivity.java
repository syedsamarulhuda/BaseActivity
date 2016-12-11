package com.example.samar.mybaseactivity;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseActivity extends AppCompatActivity {

    public ViewGroup mContentContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }


    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void initData();


    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mContentContainer = (ViewGroup) findViewById(R.id.content_frame_layout);



        if (getLayoutId() != 0 && getLayoutId() != -1) {
            View layoutView = LayoutInflater.from(this).inflate(getLayoutId(), null);
            mContentContainer.addView(layoutView);
        } else {
            if (getLayoutId() == -1) {
                mContentContainer.setVisibility(View.GONE);
            }
        }

        initViews();
        initData();

    }
}
