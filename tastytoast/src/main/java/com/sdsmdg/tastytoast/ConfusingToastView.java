package com.sdsmdg.tastytoast;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by Anas Altair on 8/31/2016.
 * Modified by rahul on 16/09/2016
 */
public class ConfusingToastView extends View {

    Bitmap eye;
    ValueAnimator valueAnimator;
    float angle = 0f;
    private Paint mPaint;
    private float mWidth = 0f;
    private float mHeight = 0f;

    public ConfusingToastView(Context context) {
        super(context);
    }

    public ConfusingToastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ConfusingToastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        initPaint();
        initPath();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#FE9D4D"));
    }

    private void initPath() {
        Path mPath = new Path();
        RectF rectF = new RectF(mWidth / 2f - dip2px(1.5f), mHeight / 2f - dip2px(1.5f)
                , mWidth / 2f + dip2px(1.5f), mHeight / 2f + dip2px(1.5f));
        mPath.addArc(rectF, 180f, 180f);
        rectF.set(rectF.left - dip2px(3), rectF.top - dip2px(1.5f), rectF.right, rectF.bottom + dip2px(1.5f));
        mPath.addArc(rectF, 0f, 180f);
        rectF.set(rectF.left, rectF.top - dip2px(1.5f), rectF.right + dip2px(3), rectF.bottom + dip2px(1.5f));
        mPath.addArc(rectF, 180f, 180f);
        rectF.set(rectF.left - dip2px(3), rectF.top - dip2px(1.5f), rectF.right, rectF.bottom + dip2px(1.5f));
        mPath.addArc(rectF, 0f, 180f);

        eye = Bitmap.createBitmap((int) mWidth, (int) mHeight, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(eye);
        mPaint.setStrokeWidth(dip2px(1.7f));
        c.drawPath(mPath, mPaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.rotate(angle, mWidth / 4f, mHeight * 2f / 5f);
        canvas.drawBitmap(eye, mWidth / 4f - (eye.getWidth() / 2f), mHeight * 2f / 5f - (eye.getHeight() / 2f), mPaint);
        canvas.restore();
        canvas.save();
        canvas.rotate(angle, mWidth * 3f / 4f, mHeight * 2f / 5f);
        canvas.drawBitmap(eye, mWidth * 3f / 4f - (eye.getWidth() / 2f), mHeight * 2f / 5f - (eye.getHeight() / 2f), mPaint);
        canvas.restore();

        mPaint.setStrokeWidth(dip2px(2f));
        canvas.drawLine(mWidth / 4f, mHeight * 3f / 4f, mWidth * 3f / 4f, mHeight * 3f / 4f, mPaint);
    }

    public float dip2px(float dpValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return dpValue * scale;
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

                angle += 4;
                postInvalidate();
            }
        });

        if (!valueAnimator.isRunning()) {
            valueAnimator.start();

        }
        return valueAnimator;
    }
}