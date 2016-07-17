package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TastyToast extends AppCompatActivity {

    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    public static final int SUCCESS = 1;
    public static final int DANGER = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_toast);
    }

    public void showSuccessToast(View view) {
        makeText(getApplicationContext(), "Download Successful !", TastyToast.LENGTH_LONG,
                TastyToast.SUCCESS);
    }

    public void showDangerToast(View view) {
        makeText(getApplicationContext(), "Are you sure ?", TastyToast.LENGTH_LONG,
                TastyToast.DANGER);
    }


    public void makeText(Context context, String msg, int length, int type) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_toast_layout,
                (ViewGroup) findViewById(R.id.root_layout));

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        text.setText(msg);
       // LinearLayout baseLayout = (LinearLayout) layout.findViewById(R.id.base_layout);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);

        switch (type) {
            case 1: {
                imageView.setImageResource(R.drawable.success_image);
                text.setBackgroundResource(R.drawable.success_toast);
                imageView.setAnimation(animation);
                break;
            }
            case 2: {
                imageView.setImageResource(R.drawable.warning_image);
                text.setBackgroundResource(R.drawable.warning_toast);
                imageView.setAnimation(animation);
            }
        }
        text.setTextColor(Color.parseColor("#FFFFFF"));
        Toast toast = new Toast(context);
        toast.setDuration(length);
        toast.setView(layout);
        toast.show();
    }
}
