package com.nedashkovskiy.randomuserviewer.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.nedashkovskiy.randomuserviewer.R;
import com.nedashkovskiy.randomuserviewer.api_connection.Parser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FloatingActionButton fab;
    private View decorView;
    private static FragmentActivity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                decorView.setSystemUiVisibility(hideSystemsBars());
            }
        });
        fab = findViewById(R.id.main_activty_fab);
        fab.setOnClickListener(this);
    }

    public static Activity getActivity() {
        return activity;
    }

    //    _______________________________________________

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus){
            decorView.setSystemUiVisibility(hideSystemsBars());
        }
    }

    private int hideSystemsBars(){
        return   View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION|
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_IMMERSIVE;
    }

    @Override
    public void onClick(View v) {
        Parser parser = new Parser();
        parser.startApiConnection();
    }
}