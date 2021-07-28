package com.srinija.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


//testing for merging branches

public class GameActivity extends AppCompatActivity {

    //tic(O)=1, tac(X)=2
    String playername1, playername2;
    String text1;
    int counter, counter2;
    boolean won;
    int[][] wins = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9},{3,5,7}};
    int[] positions = {0,0,0,0,0,0,0,0,0};
    TextView newText, pl1;
    TextView pl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        playername1 = intent.getStringExtra("Player1");
        playername2 = intent.getStringExtra("Player2");

        counter = 1;
        counter2 = 0;
        won = false;

        newText = (TextView) findViewById(R.id.textNew);
        pl1 = (TextView) findViewById(R.id.player1);
        pl2 = (TextView) findViewById(R.id.player2);
        newText.setText(playername1.toUpperCase()+" goes first!");
        pl1.setText(playername1.toUpperCase()+" - ");
        pl2.setText(playername2.toUpperCase()+" - ");

    }

    public void restart(View view)
    {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void  fade(View view){


        counter2++;

        //newText = (TextView) findViewById(R.id.textNew);
        newText.setAlpha(0f);

        ImageView coin = (ImageView) view;


        int pos = Integer.parseInt(coin.getTag().toString());
        if(positions[pos-1] == 0) {
            if (counter == 1) {
                coin.setImageResource(R.drawable.tic3);
                counter = 2;
                positions[pos - 1] = 1;
            } else if (counter == 2) {
                coin.setImageResource(R.drawable.tac3);
                counter = 1;
                positions[pos - 1] = 2;
            }
        }
        else {
            Toast.makeText(GameActivity.this, "Already taken!", Toast.LENGTH_SHORT).show();
        }

        for(int[] win: wins)
        {
            if(positions[win[0]-1] == positions[win[1]-1] && positions[win[1]-1] == positions[win[2]-1] && positions[win[0]-1]!=0)
            {
                won = true;
                if(positions[win[0]-1] == 1){
                    //Toast.makeText(GameActivity.this, playername1+" won!!!", Toast.LENGTH_SHORT).show();
                    text1 = playername1.toUpperCase()+" WON!!!";
                    newText.setText(text1);
                    newText.setAlpha(1f);
                }
                else{
                    //Toast.makeText(GameActivity.this, playername2+" won!!!", Toast.LENGTH_SHORT).show();
                    text1 = playername2.toUpperCase()+" WON!!!";
                    newText.setText(text1);
                    newText.setAlpha(1f);
                }
                Button reset = (Button) findViewById(R.id.reset);
                reset.setAlpha(1f);
                ImageView image = (ImageView) findViewById(R.id.board);
                image.setAlpha(0f);
                break;
            }
        }

        if(counter2==9 && won ==false)
        {
            text1 = "DRAW!!!";
            newText.setText(text1);
            newText.setAlpha(1f);
            Button reset = (Button) findViewById(R.id.reset);
            reset.setAlpha(1f);
            ImageView image = (ImageView) findViewById(R.id.board);
            image.setAlpha(0f);
        }



    }
}
