package com.example.handballmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WinnerScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_screen);

        TextView nextView = findViewById(R.id.team_name);

        String incomingMsg = getIntent().getStringExtra("Msg");
        nextView.setText(incomingMsg);
    }
}