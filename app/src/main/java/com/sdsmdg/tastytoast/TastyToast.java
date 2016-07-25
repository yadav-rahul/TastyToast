package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class TastyToast extends AppCompatActivity {

    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    SuccessToastView successToastView;
    WarningToastView warningToastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tasty_toast);
    }

    public void showSuccessToast(View view) {
        makeText(getApplicationContext(), "Download Successful !", TastyToast.LENGTH_LONG,
                TastyToast.SUCCESS);
    }

    public void showWarningToast(View view) {
        makeText(getApplicationContext(), "Are you sure ?", TastyToast.LENGTH_LONG,
                TastyToast.WARNING);
    }


    public void makeText(Context context, String msg, int length, int type) {
        LayoutInflater inflater = getLayoutInflater();
        Toast toast = new Toast(context);

        switch (type) {
            case 1: {
                View layout = inflater.inflate(R.layout.success_toast_layout,
                        (ViewGroup) findViewById(R.id.root_layout));

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                successToastView = (SuccessToastView) layout.findViewById(R.id.successView);
                successToastView.startAnim();
                text.setBackgroundResource(R.drawable.success_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                break;
            }
            case 2: {
                View layout = inflater.inflate(R.layout.warning_toast_layout,
                        (ViewGroup) findViewById(R.id.root_layout));

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                warningToastView = (WarningToastView) layout.findViewById(R.id.warningView);
                warningToastView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.warning_anim));
                warningToastView.startAnim();
                text.setBackgroundResource(R.drawable.warning_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                break;
            }
        }

        toast.setDuration(length);
        toast.show();
    }
}
