package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class TastyToast extends AppCompatActivity {

    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;
    public static final int SUCCESS = 1;
    public static final int DANGER = 2;
    SuccessToastView successToastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_tasty_toast);
    }

    public void showSuccessToast(View view) {
        //TODO Show view in a smooth way
        makeText(getApplicationContext(), "Download Successful !", TastyToast.LENGTH_LONG,
                TastyToast.SUCCESS);
    }

    public void showDangerToast(View view) {
        //TODO Make separate view for it.
        makeText(getApplicationContext(), "Are you sure ?", TastyToast.LENGTH_LONG,
                TastyToast.DANGER);
    }

    //Custom toast method

    public void makeText(Context context, String msg, int length, int type) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_toast_layout,
                (ViewGroup) findViewById(R.id.root_layout));

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(msg);

        switch (type) {
            case 1: {
//                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
//                imageView.setBackgroundResource(R.drawable.success_frame_animation);
//
//                AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
//                animationDrawable.start();
//                imageView.setAnimation(animation);
                successToastView = (SuccessToastView) layout.findViewById(R.id.successView);
                successToastView.startAnim();
                text.setBackgroundResource(R.drawable.success_toast);
                break;
            }
            case 2: {
//                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
//                imageView.setImageResource(R.drawable.warning_image);
//                text.setBackgroundResource(R.drawable.warning_toast);
//                imageView.setAnimation(animation);
                break;
            }
        }
        text.setTextColor(Color.parseColor("#FFFFFF"));
        Toast toast = new Toast(context);
        toast.setDuration(length);
        toast.setView(layout);
        toast.show();
    }
}
