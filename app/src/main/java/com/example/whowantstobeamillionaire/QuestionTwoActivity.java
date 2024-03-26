package com.example.whowantstobeamillionaire;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class QuestionTwoActivity extends AppCompatActivity {

    private TextView currentEarnings;
    private RadioGroup answersGroup;
    private Button submitButton;
    private int previousQuestionEarnings; // Variable to hold earnings from the previous question

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_two); // Make sure this is the correct layout

        // Initialize views
        currentEarnings = findViewById(R.id.current_earnings);
        answersGroup = findViewById(R.id.answers_group);
        submitButton = findViewById(R.id.submit_button);

        // Get earnings from the previous question
        previousQuestionEarnings = getIntent().getIntExtra("QUESTION_EARNINGS", 0);
        // Update the earnings display to show earnings from the previous question
        currentEarnings.setText("Earnings : $" + previousQuestionEarnings);

        // Set up the submit button click listener
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = answersGroup.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(selectedId);

                // Check if the selected answer is correct
                if (isCorrectAnswer(selectedRadioButton)) {
                    // Correct answer, set earnings for this question
                    int questionEarnings = 500; // Earnings for answering this question correctly
                    Toast.makeText(QuestionTwoActivity.this, "Correct! You've won $" + questionEarnings, Toast.LENGTH_SHORT).show();

                    // Update the display to show earnings for this question
                    currentEarnings.setText("Earnings for This Question: $" + questionEarnings);

                    // Proceed to the next step (e.g., another question, winning screen, etc.)
                    Intent intent = new Intent(QuestionTwoActivity.this, QuestionThreeActivity.class);
                    // Optionally pass questionEarnings if needed for the next activity
                    intent.putExtra("QUESTION_EARNINGS", questionEarnings);
                    startActivity(intent);
                    finish(); // End this activity
                } else {
                    // Incorrect answer, go to game over screen
                    Toast.makeText(QuestionTwoActivity.this, "Incorrect! Game Over", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(QuestionTwoActivity.this, GameOverActivity.class);
                    intent.putExtra("TOTAL_EARNINGS", previousQuestionEarnings); // Pass the total earnings before the wrong answer
                    startActivity(intent);
                    finish(); // End this activity
                }
            }
        });
    }

    // Method to check if the selected answer is correct
    private boolean isCorrectAnswer(RadioButton selectedRadioButton) {
        // Implement the logic to check if the selected answer is correct
        // For demonstration, this example assumes the correct answer is "Option A"
        return selectedRadioButton.getText().toString().equalsIgnoreCase("Leonardo da Vinci");
    }
}



