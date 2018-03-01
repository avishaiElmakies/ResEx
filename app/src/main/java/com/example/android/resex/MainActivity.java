package com.example.android.resex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createLayout();

    }
    public void createLayout(){

        LinearLayout linearLayout=new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout,layoutParams);
        txt=new TextView(this);
        LinearLayout.LayoutParams txtParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        txtParams.gravity= Gravity.CENTER_HORIZONTAL;
        txt.setLayoutParams(txtParams);
        txt.setText("Test me");
        txt.setTextSize(getResources().getDimension(R.dimen.text_size));
        txt.setGravity(Gravity.CENTER_HORIZONTAL);
        linearLayout.addView(txt);
        Button red=createButton(getString(R.string.c_red));
        linearLayout.addView(red);
        Button blue=createButton(getString(R.string.c_blue));
        linearLayout.addView(blue);
        Button green=createButton(getString(R.string.c_green));
        linearLayout.addView(green);
        Button yellow=createButton(getString(R.string.c_Yellow));
        linearLayout.addView(yellow);
    }
    public Button createButton(final String str){
        Button btn=new Button(this);
        LinearLayout.LayoutParams btnParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        btn.setLayoutParams(btnParams);
        btn.setText(str);
        btn.setTextSize(getResources().getDimension(R.dimen.text_size));
        btn.setGravity(Gravity.CENTER_HORIZONTAL);
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeColor(str);
            }
        };
        btn.setOnClickListener(onClickListener);
        return btn;
    }
    public void changeColor(String str){
        txt.setText("you chose " +str);
        txt.setTextColor(getResources().getColor(getResources().getIdentifier(str,"color",getPackageName())));
    }

}
