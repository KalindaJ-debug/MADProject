package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class enterWordPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_word_page);
    }


    public void goToGame(View view) {
        Intent intent = new Intent(this, HangManPage.class);
        startActivity(intent);
    }
}
