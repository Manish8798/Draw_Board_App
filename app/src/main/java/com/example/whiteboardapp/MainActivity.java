package com.example.whiteboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends AppCompatActivity {

    DrawableView drawableView;
    DrawableViewConfig config;
    Button erase_btn, pen_btn;
    float penSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawableView = (DrawableView) findViewById(R.id.drawableView);
        erase_btn = (Button) findViewById(R.id.eraser);
        pen_btn = (Button) findViewById(R.id.pen);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        config = new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        config.setShowCanvasBounds(true);
        config.setMaxZoom(5.0f);
        config.setMinZoom(1.0f);
        config.setCanvasHeight(height);
        config.setCanvasWidth(width);

        drawableView.setConfig(config);
        penSize = config.getStrokeWidth();
    }

    public void plus(View view) {
        config.setStrokeWidth(config.getStrokeWidth()+5);
    }

    public void sub(View view) {
        config.setStrokeWidth(config.getStrokeWidth()-5);
    }

    public void color(View view) {
    }

    public void undo(View view) {
        drawableView.undo();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        pen_btn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        erase_btn.setBackgroundColor(getResources().getColor(R.color.purple_200));
    }

    public void erase(View view) {
        config.setStrokeColor(getResources().getColor(android.R.color.white));
        erase_btn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        pen_btn.setBackgroundColor(getResources().getColor(R.color.purple_200));
        config.setStrokeWidth(penSize+10);
    }

    public void pen(View view) {
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        pen_btn.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        erase_btn.setBackgroundColor(getResources().getColor(R.color.purple_200));
        config.setStrokeWidth(penSize);
    }
}