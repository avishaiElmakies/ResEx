package com.example.android.resex;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Road extends AppCompatActivity {
    private ContentFrameLayout cfl;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);
        cfl = (ContentFrameLayout) findViewById(android.R.id.content);
        restart(cfl);
        buttons = new Button[4];
        for (int i = 0; i < buttons.length; i++) {
            String id = "button" + i;
            int intid = getResources().getIdentifier(id, "id", getPackageName());
            buttons[i] = findViewById(intid);
        }


    }

    public void restart(ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View v = parent.getChildAt(i);
            {
                if (v instanceof Button) {
                    Button btn = (Button) v;
                    if (btn.getTag() != null) {
                        String str = btn.getTag().toString();

                        if (str.equals("false")) {
                            btn.setBackgroundResource(R.drawable.button_shape_off);
                        }
                    }
                } else if (v instanceof ViewGroup) {
                    restart((ViewGroup) v);
                }
            }

        }
    }

    public void onClickChange(View v) {

        if (v instanceof Button) {
 //          TransitionDrawable transitionDrawable = (TransitionDrawable)v.getBackground();
            Button btn = (Button) v;
            switch (btn.getId()) {
                case R.id.button4: {
                    for (int i = 0; i < buttons.length; i++) {
                        if (i == 2) {
                            buttons[i].setBackgroundResource(R.drawable.button_shape_off);
                        }
                        if (i == 3) {
                            buttons[i].setBackgroundResource(R.drawable.button_shape_green);
                        }
                        if (i == 0) {
                            buttons[i].setBackgroundResource(R.drawable.button_shape);
                        }
                        if (i == 1) {
                            buttons[i].setBackgroundResource(R.drawable.button_shape_off);
                        }


                    }

                    break;
                }
                case R.id.button5: {
                    for (int i = 0; i < buttons.length; i++) {
                        if (i == 2) {
                           buttons[i].setBackgroundResource(R.drawable.button_shape);
                        }
                        if (i == 3) {
                            buttons[i].setBackgroundResource(R.drawable.button_shape_off);
                        }
                        if (i == 0) {
                            buttons[i].setBackgroundResource(R.drawable.button_shape_off);
                        }
                        if (i == 1) {
                            buttons[i].setBackgroundResource(R.drawable.button_shape_green);
                        }


                    }
                    break;


                }
            }
        }
    }
}








