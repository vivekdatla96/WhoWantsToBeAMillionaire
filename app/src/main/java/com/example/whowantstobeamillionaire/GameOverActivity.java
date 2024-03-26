package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameOverActivity extends AppCompatActivity {

    private TextView finalEarningsTextView;
    private Button restartGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        // Initialize views
        finalEarningsTextView = findViewById(R.id.final_earnings_text_view);
        restartGameButton = findViewById(R.id.restart_game_button);

        // Get the total earnings from the Intent that started this activity
        int totalEarnings = getIntent().getIntExtra("TOTAL_EARNINGS", 0);

        // Display the total earnings
        finalEarningsTextView.setText(getString(R.string.final_earnings, totalEarnings));

        // Set up the listener for the restart game button
        restartGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to restart the game, which will navigate back to the MainActivity
                Intent restartIntent = new Intent(GameOverActivity.this, MainActivity.class);
                restartIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(restartIntent);
                finish();
            }
        });
    }
}




