package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    public void showSucessToast(View view) {
        makeText(getApplicationContext(), "This is an example of Custom Toast.", TastyToast.LENGTH_LONG,
                TastyToast.SUCCESS);
    }

    public void showDangerToast(View view) {
        makeText(getApplicationContext(), "This is an example of Custom Toast.", TastyToast.LENGTH_LONG,
                TastyToast.DANGER);
    }


    public void makeText(Context context, String msg, int lenght, int type) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_toast_layout,
                (ViewGroup) findViewById(R.id.root_layout));

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(msg);

        text.setBackgroundResource(R.drawable.success_toast);
        switch (type) {
            case 1: {
                text.setBackgroundResource(R.drawable.success_toast);
                break;
            }
            case 2: {
                text.setBackgroundResource(R.drawable.danger_toast);

            }
        }
        text.setTextColor(Color.parseColor("#FFFFFF"));
        Toast toast = new Toast(context);
        toast.setDuration(lenght);
        toast.setView(layout);
        toast.show();
    }
}
