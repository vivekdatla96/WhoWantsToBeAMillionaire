package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class VictoryActivity extends AppCompatActivity {

    private static final int DISPLAY_DURATION = 5000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(VictoryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DISPLAY_DURATION);
    }
}


