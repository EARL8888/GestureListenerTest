package com.earl.gesturelistenertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Demo描述:
 * Activity和控件的手势操作GestureDetector
 * <p/>
 * Activity手势操作步骤:
 * 1 覆写Activity的onTouchEvent方法
 * 2 在onTouchEvent中将Touch事件交给GestureDetector处理即:
 * return mGestureDetector.onTouchEvent(event);
 * <p/>
 * 控件的手势操作步骤:
 * 1 为控件设置setOnTouchListener
 * 2 在该监听的onTouch方法中将事件交给GestureDetector处理即:
 * return mGestureDetector.onTouchEvent(event);
 * <p/>
 * 注意:
 * onScroll()和onFling()方法的区别:
 * 1 onScroll() happens after the user puts his finger down on
 * the screen and slides his finger across the screen without lifting it.
 * onFling() happens if the user scrolls and then lifts his finger.
 * A fling is triggered only if the motion was fast enough.
 * 2 onScroll()方法中两个参数MotionEvent e1, MotionEvent e2分别对应:
 * ACTION_DOWN(0)和ACTION_MOVE(2)
 * 但是:onFling()方法中两个参数MotionEvent e1, MotionEvent e2分别对应:
 * ACTION_DOWN(0)和ACTION_UP(1)
 */
public class MainActivity extends Activity {
    private GestureDetector mGestureDetector;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mGestureDetector = new GestureDetector(MainActivity.this, new GestureListenerImpl());
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent event) {
                return mGestureDetector.onTouchEvent(event);
            }
        });
    }

    //覆写Activity的onTouchEvent方法
    //将Touch事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    //以下为OnGestureListener的实现
    private class GestureListenerImpl implements GestureDetector.OnGestureListener {
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
            startActivity(new Intent(MainActivity.this, OntouchActivity.class));
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
}