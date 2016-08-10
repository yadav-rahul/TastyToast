package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by rahul on 27/7/16.
 */
public class DefaultToastView extends View {

    ValueAnimator valueAnimator;
    float mAnimatedValue = 0f;
    private Paint mPaint, mSpikePaint;
    private float mWidth = 0f;
    private float mPadding = 0f;
    private float mSpikeLength;


    public DefaultToastView(Context context) {
        super(context);
    }

    public DefaultToastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DefaultToastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initPaint();
        mWidth = getMeasuredWidth();
        mPadding = dip2px(5);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#222222"));
        mPaint.setStrokeWidth(dip2px(2));

        mSpikePaint = new Paint();
        mSpikePaint.setAntiAlias(true);
        mSpikePaint.setStyle(Paint.Style.STROKE);
        mSpikePaint.setColor(Color.parseColor("#222222"));
        mSpikePaint.setStrokeWidth(dip2px(4));

        mSpikeLength = dip2px(4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawCircle(mWidth / 2, mWidth / 2, mWidth / 4, mPaint);

        for (int i = 0; i < 360; i += 40) {

            int angle = (int) (mAnimatedValue * 40 + i);
            float initialX = (float) ((mWidth / 4) * Math.cos(angle * Math.PI / 180));
            float initialY = (float) ((mWidth / 4) * Math.sin(angle * Math.PI / 180));
            float finalX = (float) ((mWidth / 4 + mSpikeLength) * Math.cos(angle * Math.PI / 180));
            float finalY = (float) ((mWidth / 4 + mSpikeLength) * Math.sin(angle * Math.PI / 180));
            canvas.drawLine(mWidth / 2 - initialX, mWidth / 2 - initialY, mWidth / 2 - finalX,
                    mWidth / 2 - finalY, mSpikePaint);
        }
        canvas.restore();
    }


    public void startAnim() {
        stopAnim();
        startViewAnim(0f, 1f, 2000);
    }

    public void stopAnim() {
        if (valueAnimator != null) {
            clearAnimation();

            valueAnimator.end();
            postInvalidate();
        }
    }

    private ValueAnimator startViewAnim(float startF, final float endF, long time) {
        valueAnimator = ValueAnimator.ofFloat(startF, endF);
        valueAnimator.setDuration(time);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                mAnimatedValue = (float) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });

        if (!valueAnimator.isRunning()) {
            valueAnimator.start();

        }
        return valueAnimator;
    }

    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale);
    }
}
