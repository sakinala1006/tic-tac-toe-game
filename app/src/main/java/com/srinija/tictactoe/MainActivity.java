package com.srinija.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void entered(View view)
    {
        Intent intent = new Intent(this, GameActivity.class);
        EditText player1 = (EditText) findViewById(R.id.player1);
        String playerOne = player1.getText().toString();
        EditText player2 = (EditText) findViewById(R.id.player2);
        String playerTwo = player2.getText().toString();

        intent.putExtra("Player1", playerOne);
        intent.putExtra("Player2",playerTwo);

        startActivity(intent);
    }
}