package com.gengmei.animdemo.activity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.gengmei.animdemo.HorizontalActivity;
import com.gengmei.animdemo.R;

import androidx.constraintlayout.widget.ConstraintLayout;

public class MSecondActivity extends HorizontalActivity implements View.OnTouchListener, View.OnClickListener {

    private ImageView ivMove;
    private int lastX, lastY;
    private Button switch_button;
    private ConstraintLayout constraintLayout;
    private boolean switchAlpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_second);
        ivMove = findViewById(R.id.iv_move);
        constraintLayout = findViewById(R.id.constraintLayout);
        ivMove.setOnTouchListener(this);
        switch_button =  findViewById(R.id.switch_button);
        switch_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchAlpha = !switchAlpha;
                startAnim();
            }
        });
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

    }

    private ObjectAnimator alpha;
    private void startAnim() {
        ObjectAnimator translate = ObjectAnimator.ofFloat(ivMove, View.TRANSLATION_Y, 0, 300);
        translate.setDuration(500);
        translate.start();
        if (alpha != null && alpha.isRunning()) {
            alpha.end();
        }
        if (switchAlpha) {
            alpha = ObjectAnimator.ofFloat(ivMove, View.ALPHA, 1f, 0);
        } else {
            alpha = ObjectAnimator.ofFloat(ivMove, View.ALPHA, 0, 1f);
        }
        alpha.setDuration(300);
        alpha.setInterpolator(new LinearInterpolator());
        alpha.start();
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) ivMove.getLayoutParams();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                lastX = (int) event.getRawX();
//                lastY = (int) event.getRawY();
                int dx = (int) event.getRawX() - lastX;
                int dy = (int) event.getRawY() - lastY;
                int left = view.getLeft() + dx;
                int top = view.getTop() + dy;

                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_MOVE:
                //计算出需要移动的距离
                dx = (int) event.getRawX() - lastX;
                dy = (int) event.getRawY() - lastY;
//将移动距离加上，现在本身距离边框的位置
                left = view.getLeft() + dx;
                top = view.getTop() + dy;
                layoutParams.leftMargin = left;
                layoutParams.topMargin = top;
                ivMove.setLayoutParams(layoutParams);

                lastX = (int) event.getRawX();
                lastY = (int) event.getRawY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        ivMove.invalidate();
        return true;
    }

    @Override
    public void onClick(View v) {
        v.setVisibility(View.GONE);
    }
}
