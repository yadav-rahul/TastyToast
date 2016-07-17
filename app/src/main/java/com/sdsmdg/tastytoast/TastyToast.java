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

    public static int LENGTH_SHORT = 0;
    public static int LENGTH_LONG = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_toast);
    }
    public void showToast(View view) {
        makeText(getApplicationContext(), "This is an example of Custom Toast.", TastyToast.LENGTH_LONG);
    }


    public void makeText(Context context, String msg, int lenght) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_toast_layout,
                (ViewGroup) findViewById(R.id.root_layout));

        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(msg);
        text.setBackgroundResource(R.drawable.sucess_toast);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(lenght);
        toast.setView(layout);
        toast.show();
    }
}
