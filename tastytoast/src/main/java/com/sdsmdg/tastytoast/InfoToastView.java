package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by rahul on 27/7/16.
 */
public class InfoToastView extends View {

    RectF rectF = new RectF();
    ValueAnimator valueAnimator;
    float mAnimatedValue = 0f;
    private String TAG = "com.sdsmdg.tastytoast";
    private Paint mPaint;
    private float mWidth = 0f;
    private float mEyeWidth = 0f;
    private float mPadding = 0f;
    private float endPoint = 0f;
    private boolean isEyeLeft = false;
    private boolean isEyeRight = false;
    private boolean isEyeMiddle = false;

    public InfoToastView(Context context) {
        super(context);
    }


    public InfoToastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InfoToastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initPaint();
        initRect();
        mWidth = getMeasuredWidth();
        mPadding = dip2px(10);
        mEyeWidth = dip2px(3);
        endPoint = mPadding;
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#337ab7"));
        mPaint.setStrokeWidth(dip2px(2));

    }

    private void initRect() {
        rectF = new RectF(mPadding, mPadding, mWidth - mPadding, mWidth - mPadding);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(mPadding, mWidth - 3 * mPadding / 2, endPoint, mWidth - 3 * mPadding / 2, mPaint);
        mPaint.setStyle(Paint.Style.FILL);

        if (isEyeLeft) {
            canvas.drawCircle(mPadding + mEyeWidth, mWidth / 3, mEyeWidth, mPaint);
            canvas.drawCircle(mWidth - mPadding - 2 * mEyeWidth, mWidth / 3, mEyeWidth, mPaint);
        }
        if (isEyeMiddle) {
            canvas.drawCircle(mPadding + (3 * mEyeWidth / 2), mWidth / 3, mEyeWidth, mPaint);
            canvas.drawCircle(mWidth - mPadding - (5 * mEyeWidth / 2), mWidth / 3, mEyeWidth, mPaint);
        }
        if (isEyeRight) {
            canvas.drawCircle(mPadding + 2 * mEyeWidth, mWidth / 3, mEyeWidth, mPaint);
            canvas.drawCircle(mWidth - mPadding - mEyeWidth, mWidth / 3, mEyeWidth, mPaint);
        }
    }

    public int dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void startAnim() {
        stopAnim();
        startViewAnim(0f, 1f, 2000);
    }

    public void stopAnim() {
        if (valueAnimator != null) {
            clearAnimation();
            isEyeLeft = false;
            isEyeMiddle = false;
            isEyeRight = false;
            endPoint = mPadding;
            mAnimatedValue = 0f;
            valueAnimator.end();
        }
    }

    private ValueAnimator startViewAnim(float startF, final float endF, long time) {
        valueAnimator = ValueAnimator.ofFloat(startF, endF);
        valueAnimator.setDuration(time);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                mAnimatedValue = (float) valueAnimator.getAnimatedValue();

                //   Log.i(TAG, "Value : " + mAnimatedValue);
                if (mAnimatedValue < 0.90) {
                    endPoint = ((2 * (mWidth) - (4 * mPadding)) * (mAnimatedValue / 2)) + mPadding;
                } else {
                    endPoint = mWidth - 5 * mPadding / 4;
                }

                if (mAnimatedValue < 0.16) {
                    isEyeRight = true;
                    isEyeLeft = false;
                } else if (mAnimatedValue < 0.32) {
                    isEyeRight = false;
                    isEyeLeft = true;
                } else if (mAnimatedValue < 0.48) {
                    isEyeRight = true;
                    isEyeLeft = false;
                } else if (mAnimatedValue < 0.64) {
                    isEyeRight = false;
                    isEyeLeft = true;
                } else if (mAnimatedValue < 0.80) {
                    isEyeRight = true;
                    isEyeLeft = false;
                } else if (mAnimatedValue < 0.96) {
                    isEyeRight = false;
                    isEyeLeft = true;
                } else {
                    isEyeLeft = false;
                    isEyeMiddle = true;
                    isEyeRight = false;
                }

                postInvalidate();
            }
        });

        if (!valueAnimator.isRunning()) {
            valueAnimator.start();

        }
        return valueAnimator;
    }

}
