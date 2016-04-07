// Jiwoo Lee <jlee29@stanford.edu>
// GuessTheNumberGame
// The app generates a random number for the user to guess. Each incorrect guess will alert the user
// by telling them if their number was too low or too high. The game ends when the user gets the number.
// The user can also press the give up button which will show the correct number.

package com.example.jiwoo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random randomGenerator = new Random();
        number = randomGenerator.nextInt(1000);
    }

    public void updateMessage(View view) {
        TextView higherOrLower = (TextView) findViewById(R.id.HigherOrLower);
        EditText field = (EditText) findViewById(R.id.textField);
        String stringGuess = field.getText().toString();
        int guess = Integer.valueOf(stringGuess);
        if (guess == number) {
            higherOrLower.setText("Good job!");
        }
        if (guess > number) {
            higherOrLower.setText("Too high!");
        }
        if (guess < number) {
            higherOrLower.setText("Too low!");
        }
    }

    public void giveUp(View view) {
        TextView higherOrLower = (TextView) findViewById(R.id.HigherOrLower);
        higherOrLower.setText("The answer was " + number + "!");
    }
}
