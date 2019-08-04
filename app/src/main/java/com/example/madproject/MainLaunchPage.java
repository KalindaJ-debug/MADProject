package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainLaunchPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_launch_page);
    }

    public void quickToGame(View view)
    {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void customGame(View view){
        Intent intent= new Intent(this, MainPage.class);
        startActivity(intent);
    }

    public void highScore(View view)
    {
        Intent intent= new Intent(this, HighScore.class);
        startActivity(intent);
    }
}
