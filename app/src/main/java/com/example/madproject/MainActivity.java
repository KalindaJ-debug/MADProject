package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];

    private boolean player1turn = true;

    private int roundCount;

    private int player1points;
    private int player2points;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++)
            {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                resetGame();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")){
            return;
        }

        if (player1turn) {
            ((Button) v).setText("X");
        }
        else
        {
            ((Button) v).setText("o");
        }

        roundCount++;
        if (checkforWin())
        {
            if(player1turn){
                player1Wins();
            }
            else
            {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else
        {
            player1turn = !player1turn;
        }

    }

    private boolean checkforWin()
    {
        String[][] feild = new String[3][3];

        for (int i = 0; i < 3; i++)
        {
            for (int j=0; j < 3; j++)
            {
                feild[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 3; i++)
        {
            if (feild[i][0].equals(feild[i][1]) && feild[i][0].equals(feild[i][2]) && !feild[i][0].equals("")){
                return true;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if (feild[0][i].equals(feild[1][i]) && feild[0][i].equals(feild[2][i]) && !feild[0][i].equals("")){
                return true;
            }
        }

        if (feild[0][0].equals(feild[1][1]) && feild[0][0].equals(feild[2][2]) && !feild[0][0].equals("")){
            return true;
        }

        if (feild[0][2].equals(feild[1][1]) && feild[0][2].equals(feild[2][0]) && !feild[0][2].equals("")){
            return true;
        }
        return false;
    }

    private void player1Wins()
    {
        player1points++;
        Toast.makeText(this,"Player 1 wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2points++;
        Toast.makeText(this,"Player 2 wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw()
    {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText()
    {
        textViewPlayer1.setText("Player 1: " + player1points);
        textViewPlayer2.setText("Player 2: " + player2points);
    }
    private void resetBoard()
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                buttons[i][j].setText("");
            }
        }

        roundCount = 0;
        player1turn = true;
    }
    private void resetGame(){
        player2points = 0;
        player1points = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", roundCount);
        outState.putInt("player1Points", player1points);
        outState.putInt("player2Points", player2points);
        outState.putBoolean("player1Turn", player1turn);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        roundCount = savedInstanceState.getInt("roundCount");
        player1points = savedInstanceState.getInt("player1Points");
        player2points = savedInstanceState.getInt("player2Points");
        player1turn = savedInstanceState.getBoolean("player1Turn");
    }

    public void reDirect(View view){
        Intent intent= new Intent(this, ResultsPage.class);
        startActivity(intent);
    }
}
