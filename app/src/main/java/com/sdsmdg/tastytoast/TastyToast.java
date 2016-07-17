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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasty_toast);
    }
    public void showToast(View view) {
        // Toast.makeText(MyToast.this, "", Toast.LENGTH_SHORT).show();
        makeText(getApplicationContext(), "I am Rahul Yadav and I am awesome. I am Rahul Yadav and I am awesome. I am Rahul Yadav and I am awesome.", Toast.LENGTH_LONG);
    }

    public void makeText(Context myToast, String msg, int lenght) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_toast_layout,
                (ViewGroup) findViewById(R.id.root_layout));

        //Add separate drawable for each default type and then add through background resource
        // with rounded colore and alos specify default text coloe
        //for each
        TextView text = (TextView) layout.findViewById(R.id.toastMessage);
        text.setText(msg);
        text.setBackgroundResource(R.drawable.roundcorner);
        text.setTextColor(Color.parseColor("#FFFFFF"));
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
