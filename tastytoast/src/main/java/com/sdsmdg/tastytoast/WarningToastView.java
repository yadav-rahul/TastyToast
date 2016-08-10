package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by rahul on 25/7/16.
 */
public class WarningToastView extends View {

    RectF rectFOne = new RectF();
    RectF rectFTwo = new RectF();
    RectF rectFThree = new RectF();
    private Paint mPaint;
    private float mWidth = 0f;
    private float mHeight = 0f;
    private float mStrokeWidth = 0f;
    private float mPadding = 0f;
    private float mPaddingBottom = 0f;
    private float endAngle = 0f;

    public WarningToastView(Context context) {
        super(context);
    }


    public WarningToastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WarningToastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initPaint();
        initRect();
        mHeight = getMeasuredHeight();
        mWidth = getMeasuredWidth();
        mPadding = convertDpToPixel(2);
        mPaddingBottom = mPadding * 2;
        mStrokeWidth = convertDpToPixel(2);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.parseColor("#f0ad4e"));
        mPaint.setStrokeWidth(mStrokeWidth);
    }

    private void initRect() {
        rectFOne = new RectF(mPadding, 0, mWidth - mPadding, mWidth - mPaddingBottom);
        rectFTwo = new RectF((float) (1.5 * mPadding), convertDpToPixel(6) + mPadding +
                mHeight / 3, mPadding + convertDpToPixel(9), convertDpToPixel(6) + mPadding + mHeight / 2);
        rectFThree = new RectF(mPadding + convertDpToPixel(9), convertDpToPixel(3) + mPadding +
                mHeight / 3, mPadding + convertDpToPixel(18), convertDpToPixel(3) + mPadding + mHeight / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectFOne, 170, -144, false, mPaint);
        canvas.drawLine(mWidth - convertDpToPixel(3) - mStrokeWidth, (float) (mPadding +
                        mHeight / 6), mWidth - convertDpToPixel(3) - mStrokeWidth,
                mHeight - convertDpToPixel(2) - mHeight / 4, mPaint);

        canvas.drawLine(mWidth - convertDpToPixel(3) - mStrokeWidth - convertDpToPixel(8), (float) (mPadding +
                        mHeight / 8.5), mWidth - convertDpToPixel(3) - mStrokeWidth - convertDpToPixel(8),
                (float) (mHeight - convertDpToPixel(3) - mHeight / 2.5), mPaint);

        canvas.drawLine(mWidth - convertDpToPixel(3) - mStrokeWidth - convertDpToPixel(17), (float) (mPadding +
                        mHeight / 10), mWidth - convertDpToPixel(3) - mStrokeWidth - convertDpToPixel(17),
                (float) (mHeight - convertDpToPixel(3) - mHeight / 2.5), mPaint);

        canvas.drawLine(mWidth - convertDpToPixel(3) - mStrokeWidth - convertDpToPixel(26), (float) (mPadding +
                        mHeight / 10), mWidth - convertDpToPixel(3) - mStrokeWidth - convertDpToPixel(26),
                (float) (mHeight - convertDpToPixel(2) - mHeight / 2.5), mPaint);

        canvas.drawArc(rectFTwo, 170, 180, false, mPaint);
        canvas.drawArc(rectFThree, 175, -150, false, mPaint);
    }

    public float convertDpToPixel(float dp) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}