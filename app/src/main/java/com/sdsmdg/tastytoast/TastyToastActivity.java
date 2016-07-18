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

public class TastyToastActivity extends AppCompatActivity {

    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    public static final int SUCCESS = 1;
    public static final int DANGER = 2;

    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_toast);
    }

    public void showSucessToast(View view) {
        makeText(getApplicationContext(), "This is an example of Custom Toast.", TastyToastActivity.LENGTH_LONG,
                TastyToastActivity.SUCCESS);
    }

    public void showDangerToast(View view) {
        makeText(getApplicationContext(), "This is an example of Custom Toast.", TastyToastActivity.LENGTH_LONG,
                TastyToastActivity.DANGER);
    }

    public void makeText(Context context, String msg, int length, int type) {
        count = msg.length();

        Toast toast = new Toast(context);

        toast.show();
    }
}
