package com.earl.gesturelistenertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

public class OntouchActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ontouch);
        findViewById(R.id.button2).setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("ACTION_DOWN");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("ACTION_UP");
                startActivity(new Intent(OntouchActivity.this, OnGestureActivity.class));
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("ACTION_MOVE");
                break;
        }
        return false;
    }
}
