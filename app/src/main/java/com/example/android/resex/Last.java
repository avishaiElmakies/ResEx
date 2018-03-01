package com.example.android.resex;

import android.graphics.drawable.TransitionDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

public class Last extends AppCompatActivity {
    private ContentFrameLayout cfl;
    private ToggleButton[] buttons;
    private int counter;
    private TransitionDrawable transitionDrawable;
    private TransitionDrawable transitionDrawable2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);
        cfl = (ContentFrameLayout) findViewById(android.R.id.content);
        restart(cfl);
        buttons = new ToggleButton[6];
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


                } else if (v instanceof Button && v.getId() == R.id.button6) {
                    v.setEnabled(false);
                } else if (v instanceof ViewGroup) {
                    restart((ViewGroup) v);
                }
            }

        }
    }

    public void onClickLast(View v) {
        switch(v.getId()) {
            case R.id.button7: {
                CountDownTimer cdt = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (counter == 0) {
                            transitionDrawable = (TransitionDrawable) buttons[3].getBackground();
                            transitionDrawable.startTransition(1000);
                            transitionDrawable2 = (TransitionDrawable) buttons[2].getBackground();
                            transitionDrawable2.reverseTransition(1000);
                        }
                        if (counter == 1) {
                            transitionDrawable = (TransitionDrawable) buttons[4].getBackground();
                            transitionDrawable.reverseTransition(1000);
                            transitionDrawable2 = (TransitionDrawable) buttons[1].getBackground();
                            transitionDrawable2.reverseTransition(1000);
                        }
                        if (counter == 3) {
                            transitionDrawable = (TransitionDrawable) buttons[4].getBackground();
                            transitionDrawable.startTransition(1000);
                            transitionDrawable2 = (TransitionDrawable) buttons[1].getBackground();
                            transitionDrawable2.startTransition(1000);
                        }
                        counter++;
                    }

                    @Override
                    public void onFinish() {
                        transitionDrawable = (TransitionDrawable) buttons[5].getBackground();
                        transitionDrawable.reverseTransition(1000);
                        transitionDrawable2 = (TransitionDrawable) buttons[0].getBackground();
                        transitionDrawable2.reverseTransition(1000);
                        counter=0;
                    }

                }.start();
                findViewById(R.id.button6).setEnabled(true);
                findViewById(R.id.button7).setEnabled(false);

                break;
            }
            case R.id.button6:{

                CountDownTimer cdt = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        if (counter == 0) {
                            transitionDrawable = (TransitionDrawable) buttons[0].getBackground();
                            transitionDrawable.startTransition(1000);
                            transitionDrawable2 = (TransitionDrawable) buttons[5].getBackground();
                            transitionDrawable2.startTransition(1000);
                        }
                        if (counter == 1) {
                            transitionDrawable = (TransitionDrawable) buttons[4].getBackground();
                            transitionDrawable.reverseTransition(1000);
                            transitionDrawable2 = (TransitionDrawable) buttons[1].getBackground();
                            transitionDrawable2.reverseTransition(1000);
                        }
                        if (counter == 3) {
                            transitionDrawable = (TransitionDrawable) buttons[4].getBackground();
                            transitionDrawable.startTransition(1000);
                            transitionDrawable2 = (TransitionDrawable) buttons[1].getBackground();
                            transitionDrawable2.startTransition(1000);
                        }
                        counter++;
                    }

                    @Override
                    public void onFinish() {
                        transitionDrawable = (TransitionDrawable) buttons[2].getBackground();
                        transitionDrawable.reverseTransition(1000);
                        transitionDrawable2 = (TransitionDrawable) buttons[3].getBackground();
                        transitionDrawable2.reverseTransition(1000);
                        counter=0;
                    }

                }.start();

                findViewById(R.id.button7).setEnabled(true);
                findViewById(R.id.button6).setEnabled(false);

                break;
            }
        }

    }
}
