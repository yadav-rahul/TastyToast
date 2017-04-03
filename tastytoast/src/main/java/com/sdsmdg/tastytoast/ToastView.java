package com.sdsmdg.tastytoast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by suyash on 26/2/17.
 */

public abstract class ToastView extends View {
    public ToastView(Context context) {
        super(context);
    }

    public ToastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ToastView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }

    public abstract void startAnim();
    public abstract void stopAnim();

    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}