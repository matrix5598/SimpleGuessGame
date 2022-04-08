package com.iliasdev.whoseturn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText player1, player2, player1number, player2number;
    TextView winnertitle, winnertxt, randnumbertitle, randnumber;
    Button start, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.btn_start);
        reset = findViewById(R.id.btn_reset);
        player1 = findViewById(R.id.ed_player1);
        player2 = findViewById(R.id.ed_player2);

        player1number = findViewById(R.id.ed_player1number);
        player2number = findViewById(R.id.ed_player2number);
        winnertitle = findViewById(R.id.winnertitle);
        winnertxt = findViewById(R.id.winnertxt);
        randnumbertitle = findViewById(R.id.randnumbertitle);
        randnumber = findViewById(R.id.randnumber);

        winnertitle.setVisibility(View.INVISIBLE);
        winnertxt.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.INVISIBLE);
        randnumbertitle.setVisibility(View.INVISIBLE);
        randnumber.setVisibility(View.INVISIBLE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String P1Name = player1.getText().toString().trim();
                String P2Name = player2.getText().toString().trim();
                String P1 = player1number.getText().toString().trim();
                String P2 = player2number.getText().toString().trim();

                if (player1.length() == 0 && player2.length() == 0 && player1number.length() == 0 && player2number.length() == 0){
                    player1.setError("?!");
                }
                else if (player1.length() == 0){
                    player1.setError("?!");
                }
                else if (player2.length() == 0){
                    player2.setError("?!");
                }
                else if (player1number.length() == 0){
                    player1number.setError("?!");
                }
                else if (player2number.length() == 0){
                    player2number.setError("?!");
                }
                else{
                    int p1  = Integer.parseInt(P1);
                    int p2 = Integer.parseInt(P2);
                    reset.setVisibility(View.VISIBLE);

                    Random r = new Random();
                    int low = 10;
                    int high = 100;
                    int result = r.nextInt(high-low) + low;

                    winnertxt.setVisibility(View.VISIBLE);
                    winnertitle.setVisibility(View.VISIBLE);
                    randnumbertitle.setVisibility(View.VISIBLE);
                    randnumber.setVisibility(View.VISIBLE);
                    String RandNumber = String.valueOf(result);
                    randnumber.setText(RandNumber);

                    int difp1 = result - p1;
                    int difp2 = result - p2;
                    if (difp1 > difp2){
                        winnertxt.setText(P2Name);
                    }
                    else if (difp1 < difp2){
                        winnertxt.setText(P1Name);
                    }

                    reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            startActivity(new Intent(MainActivity.this, MainActivity.class));
                        }
                    });
                }
            }
        });
    }
}