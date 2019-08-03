package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.hangman.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goSinglePlayer(View view) {
        Intent intent = new Intent(this, HangManPage.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
       // string message = editText.getText().toString();
        //intent.putExra(EXTRA_MESSAGE, message)

        startActivity(intent);
    }

    public void goMultiPlayer(View view) {
        Intent intent = new Intent(this, multiplayerPage.class);
        startActivity(intent);
    }
}
