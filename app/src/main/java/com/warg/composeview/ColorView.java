package com.warg.composeview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Test on 18.04.2016.
 */

public class ColorView extends LinearLayout implements View.OnClickListener {

    public static final String KEY_NAME_COLOR = "name";
    public static final String KEY_VALUE_COLOR = "value";
    TextView tvTitleColor;
    View vColor;
    View vColorBox;
    boolean state = true;
    ArrayList<HashMap<String, Object>> colorsArray;
    int position = 0;

    public ColorView(Context context) {
        this(context, null);
    }

    public ColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Options, 0, 0);
        String tittleText = array.getString(R.styleable.Options_titleText);
        //int valueColor = array.getColor(R.styleable.Options_valueColor, context.getResources().getColor(android.R.color.holo_blue_light));
        array.recycle();
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.color_view, this, true);
        tvTitleColor = (TextView) findViewById(R.id.tvComposeView);
        vColor = (View) findViewById(R.id.vComposeView);
        tvTitleColor.setText(tittleText);
        //vColor.setBackgroundColor(valueColor);
        //vColorBox = findViewById(R.id.vColorBox);
        setOnClickListener(this);
    }

    public void setColorBox(int color, String name) {
        tvTitleColor.setText(name);
        vColor.setBackgroundColor(color);
        vColorBox.setBackgroundColor(color);
    }

    public void attachToColorBox(View view) {
        vColorBox = view;
    }

    @Override
    public void onClick(View v) {

        HashMap<String, Object> localColor = colorsArray.get(position);
        String nameColor = (String) localColor.get(KEY_NAME_COLOR);
        int valueColor = (int) localColor.get(KEY_VALUE_COLOR);
        setColorBox(valueColor, nameColor);
        position = (position + 1) % colorsArray.size();

        /*if (state) {
            vColorBox.setBackgroundColor(Color.MAGENTA);
            vColor.setBackgroundColor(Color.MAGENTA);
            tvTitleColor.setText("Magenta");
        } else {
            vColorBox.setBackgroundColor(Color.GREEN);
            vColor.setBackgroundColor(Color.GREEN);
            tvTitleColor.setText("Green");
        }
        state = !state;*/
    }

    public void initColors(ArrayList<HashMap<String, Object>> colors) {
        colorsArray = colors;
    }
}