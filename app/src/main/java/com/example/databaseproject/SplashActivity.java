package com.example.databaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.CubeGrid;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashActivity.this,SignInActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

        ProgressBar progressBar = (ProgressBar)findViewById(R.id.spin_kit);
        Sprite CubeGrid = new CubeGrid();
        progressBar.setIndeterminateDrawable(CubeGrid);

    }
}