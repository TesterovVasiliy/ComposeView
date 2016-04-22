package com.warg.composeview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorView colorView = (ColorView) findViewById(R.id.cvChangeColor);
        colorView.attachToColorBox(findViewById(R.id.vColorBox));
        colorView.setColorBox(Color.GREEN, "Green");

        ArrayList<HashMap<String, Object>> colors = new ArrayList<>();
        HashMap<String, Object> color = new HashMap<>();
        color.put(ColorView.KEY_NAME_COLOR, "GRAY");
        color.put(ColorView.KEY_VALUE_COLOR, Color.GRAY);
        colors.add(color);
        HashMap<String, Object> color1 = new HashMap<>();
        color1.put(ColorView.KEY_NAME_COLOR, "BLACK");
        color1.put(ColorView.KEY_VALUE_COLOR, Color.BLACK);
        colors.add(color1);
        HashMap<String, Object> color2 = new HashMap<>();
        color2.put(ColorView.KEY_NAME_COLOR, "CYAN");
        color2.put(ColorView.KEY_VALUE_COLOR, Color.CYAN);
        colors.add(color2);
        HashMap<String, Object> color3 = new HashMap<>();
        color3.put(ColorView.KEY_NAME_COLOR, "MAGENTA");
        color3.put(ColorView.KEY_VALUE_COLOR, Color.MAGENTA);
        colors.add(color3);
        HashMap<String, Object> color4 = new HashMap<>();
        color4.put(ColorView.KEY_NAME_COLOR, "DKGRAY");
        color4.put(ColorView.KEY_VALUE_COLOR, Color.DKGRAY);
        colors.add(color4);
        colorView.initColors(colors);
    }
}
