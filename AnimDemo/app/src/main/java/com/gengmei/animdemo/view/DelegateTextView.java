package com.gengmei.animdemo.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class DelegateTextView extends AppCompatTextView {

    private Context context;

    public DelegateTextView(Context context) {
        this(context, null);
    }

    public DelegateTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DelegateTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    @Override
    public void setText(CharSequence text, BufferType type) {
        super.setText(text, type);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), -(int) getLineSpacingExtra());
        }
    }

    private void init() {
        // 去除TextView上下白边
        setIncludeFontPadding(false);
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/icomoon.ttf");
        setTypeface(typeface);
    }
}
