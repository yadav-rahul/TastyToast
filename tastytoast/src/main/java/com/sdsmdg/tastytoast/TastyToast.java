package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rahul on 28/7/16.
 */
public class TastyToast {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;


    public static final int SUCCESS = 1;
    public static final int WARNING = 2;
    public static final int ERROR = 3;
    public static final int INFO = 4;
    public static final int DEFAULT = 5;
    public static final int CONFUSING = 6;

    public static Toast makeText(Context context, String msg, int length, int type) {

        Toast toast = new Toast(context);


        switch (type) {
            case 1: {
                View layout = LayoutInflater.from(context).inflate(R.layout.success_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                text.setBackgroundResource(R.drawable.success_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                layout.findViewById(R.id.successView);
                break;
            }
            case 2: {
                View layout = LayoutInflater.from(context).inflate(R.layout.warning_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                text.setBackgroundResource(R.drawable.warning_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                layout.findViewById(R.id.warningView);
                break;
            }
            case 3: {
                View layout = LayoutInflater.from(context).inflate(R.layout.error_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                text.setBackgroundResource(R.drawable.error_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                layout.findViewById(R.id.errorView);
                break;
            }
            case 4: {
                View layout = LayoutInflater.from(context).inflate(R.layout.info_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                text.setBackgroundResource(R.drawable.info_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                layout.findViewById(R.id.infoView);
                break;
            }
            case 5: {
                View layout = LayoutInflater.from(context).inflate(R.layout.default_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                text.setBackgroundResource(R.drawable.default_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                layout.findViewById(R.id.defaultView);
                break;
            }
            case 6: {
                View layout = LayoutInflater.from(context).inflate(R.layout.confusing_toast_layout, null, false);

                TextView text = (TextView) layout.findViewById(R.id.toastMessage);
                text.setText(msg);
                text.setBackgroundResource(R.drawable.confusing_toast);
                text.setTextColor(Color.parseColor("#FFFFFF"));
                toast.setView(layout);
                layout.findViewById(R.id.confusingView);
                break;
            }
        }
        toast.setDuration(length);
        toast.show();
        return toast;
    }

}
