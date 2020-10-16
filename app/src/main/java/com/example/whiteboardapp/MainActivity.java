package com.example.whiteboardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import me.panavtec.drawableview.DrawableView;
import me.panavtec.drawableview.DrawableViewConfig;

public class MainActivity extends AppCompatActivity {

    DrawableView drawableView;
    DrawableViewConfig config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawableView = (DrawableView) findViewById(R.id.drawableView);

        config = new DrawableViewConfig();
        config.setStrokeColor(getResources().getColor(android.R.color.black));
        config.setShowCanvasBounds(true);
        config.setMaxZoom(3.0f);
        config.setMinZoom(1.0f);
        config.setCanvasHeight(1080);
        config.setCanvasWidth(1920);

        drawableView.setConfig(config);
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
    }
}