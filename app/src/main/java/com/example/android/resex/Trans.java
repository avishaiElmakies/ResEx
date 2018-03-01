package com.example.android.resex;

import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

public class Trans extends AppCompatActivity {
    private ContentFrameLayout cfl;
    private ToggleButton[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        cfl = (ContentFrameLayout) findViewById(android.R.id.content);
        restart(cfl);
        buttons = new ToggleButton[4];
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
                if (v instanceof ToggleButton) {
                    ToggleButton btn = (ToggleButton) v;
                    TransitionDrawable transitionDrawable = (TransitionDrawable) btn.getBackground();

                    if (btn.getTag() != null) {
                        String str = btn.getTag().toString();

                        if (str.equals("false")) {
                           transitionDrawable.startTransition(1);
                        }
                    }


                } else if(v instanceof Button && v.getId()==R.id.button5){
                    v.setEnabled(false);
                }
                else if (v instanceof ViewGroup) {
                    restart((ViewGroup) v);
                }
            }

        }
    }
    public void onClickTrans(View view){
        TransitionDrawable transitionDrawable = (TransitionDrawable) buttons[0].getBackground();
        //transitionDrawable0.startTransition((1000));
        TransitionDrawable transitionDrawable1 = (TransitionDrawable) buttons[1].getBackground();
        //transitionDrawable1.startTransition(1000);
            TransitionDrawable transitionDrawable3 = (TransitionDrawable) buttons[2].getBackground();
        //    transitionDrawable3.startTransition((1000));
            TransitionDrawable transitionDrawable2 = (TransitionDrawable) buttons[3].getBackground();
         //   transitionDrawable2.startTransition(1000);
        switch (view.getId()){
            case R.id.button4:{
                transitionDrawable2.reverseTransition(1000);
                transitionDrawable3.startTransition(1000);
                transitionDrawable.reverseTransition(1000);
                transitionDrawable1.startTransition(1000);
                findViewById(R.id.button4).setEnabled(false);
                findViewById(R.id.button5).setEnabled(true);
                break;
            }
            case R.id.button5:{
                transitionDrawable2.startTransition(1000);
                transitionDrawable3.reverseTransition(1000);
                transitionDrawable.reverseTransition(1000);
                transitionDrawable1.reverseTransition(1000);

                findViewById(R.id.button5).setEnabled(false);
                findViewById(R.id.button4).setEnabled(true);
                break;
            }
        }


    }
}
