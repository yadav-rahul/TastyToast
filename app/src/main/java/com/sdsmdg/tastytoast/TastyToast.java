package com.sdsmdg.tastytoast;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.Toast;

/**
 * Created by rahul on 17/7/16.
 */
public class TastyToast extends View {

    private int textLength = 0;
    public TastyToast(Context context, int textLength) {
        super(context);
        this.textLength = textLength;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Get length of string the user has entered
        switch ((textLength)/10){
            case 0:{
                //Add only three default blocks

            }
            case 1:{
                //Add four blocks
            }
            case 2:{
                //Add five blocks
            }
            case 3:{

            }
        }

        super.onDraw(canvas);
    }
}
