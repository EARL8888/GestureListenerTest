package com.earl.gesturelistenertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * onScroll的滑动一手指开始滑动的地方为（0，0），以右和下为正方向
 */
public class OnGestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_gesture);
        initView();
    }

    private void initView() {
        mGestureDetector = new GestureDetector(this);
    }

    //覆写Activity的onTouchEvent方法
    //将Touch事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("Fling", "Activity onTouchEvent!");
        return this.mGestureDetector.onTouchEvent(event);
    }

    //触摸屏幕时均会调用该方法
    @Override
    public boolean onDown(MotionEvent e) {
        System.out.println("---> 手势中的 onDown 方法");
        return false;
    }

    //手指在屏幕上拖动后会调用该方法
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        System.out.println("---> 手势中的 onFling 方法");
        System.out.println("e1.getAction()=" + e1.getAction() + ",e2.getAction()=" + e2.getAction());
        System.out.println("velocityX=" + velocityX + ",velocityY=" + velocityY);
        return false;
    }

    //长按触摸屏幕时均会调用该方法
    @Override
    public void onLongPress(MotionEvent e) {
        System.out.println("---> 手势中的 onLongPress 方法");
    }

    //手指在屏幕上滚动时会调用该方法
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        System.out.println("---> 手势中的 onScroll 方法");
        System.out.println("e1.getAction()=" + e1.getAction() + ",e2.getAction()=" + e2.getAction());
        System.out.println("distanceX=" + distanceX + ",distanceY=" + distanceY);
        return false;
    }

    //在触摸屏上按下,且未移动和松开时调用该方法
    @Override
    public void onShowPress(MotionEvent e) {
        System.out.println("---> 手势中的 onShowPress 方法");
    }

    //轻击屏幕时调用该方法
    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        System.out.println("---> 手势中的 onSingleTapUp 方法");
        return false;
    }
}
