package com.sdsmdg.tastytoast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Modified by chankruze on 24/08/2018.
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

    abstract void startAnim();
    abstract void stopAnim();

    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}