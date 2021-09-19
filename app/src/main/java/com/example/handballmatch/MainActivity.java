package com.example.handballmatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int mTeamAScore = 0, mTeamBScore = 0;
    private TextView mTeamAScoreTv, mTeamBScoreTv, mTeamAText, mTeamBText;
    private Button mTeamA3points, mTeamA2points, mTeamAFree,
            mTeamB3points, mTeamB2points, mTeamBFree, mReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handball_match);

        initializeViews();
        initializeClickListener();
    }

    private void initializeViews(){
        mTeamAScoreTv = findViewById(R.id.teamA_score);
        mTeamBScoreTv = findViewById(R.id.teamB_score);
        mTeamAText = findViewById(R.id.teamA_text);
        mTeamBText = findViewById(R.id.teamB_text);
        mTeamA3points = findViewById(R.id.teamA_3points);
        mTeamA2points = findViewById(R.id.teamA_2points);
        mTeamAFree = findViewById(R.id.teamA_free_throw);
        mTeamB3points = findViewById(R.id.teamB_3points);
        mTeamB2points = findViewById(R.id.teamB_2points);
        mTeamBFree = findViewById(R.id.teamB_free_throw);
        mReset = findViewById(R.id.reset_btn);
    }

    private void initializeClickListener(){
        mTeamA3points.setOnClickListener(this);
        mTeamA2points.setOnClickListener(this);
        mTeamAFree.setOnClickListener(this);
        mTeamB3points.setOnClickListener(this);
        mTeamB2points.setOnClickListener(this);
        mTeamBFree.setOnClickListener(this);
        mReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.teamA_3points) {
            mTeamAScore = mTeamAScore + 3;
        }else if(view.getId() == R.id.teamA_2points){
            mTeamAScore = mTeamAScore + 2;
        } else if(view.getId() == R.id.teamA_free_throw){
            mTeamAScore = mTeamAScore + 1;
        } else if(view.getId() == R.id.teamB_3points){
            mTeamBScore = mTeamBScore + 3;
        } else if(view.getId() == R.id.teamB_2points){
            mTeamBScore = mTeamBScore + 2;
        } else if(view.getId() == R.id.teamB_free_throw){
            mTeamBScore = mTeamBScore + 1;
        } else if(view.getId() == R.id.reset_btn){
            mTeamAScore = 0;
            mTeamBScore = 0;
            mTeamAScoreTv.setText("0");
            mTeamBScoreTv.setText("0");
        }
        mTeamAScoreTv.setText(String.valueOf(mTeamAScore));
        mTeamBScoreTv.setText(String.valueOf(mTeamBScore));

        if(mTeamAScore >= 40)
            openTeamAScreen();
        else if(mTeamBScore >= 40)
            openTeamBScreen();
    }

    private void openTeamAScreen(){
        Intent intent = new Intent(this, WinnerScreen.class);
        intent.putExtra("Msg", mTeamAText.getText().toString());
        startActivity(intent);
    }
    private void openTeamBScreen(){
        Intent intent = new Intent(this, WinnerScreen.class);
        intent.putExtra("Msg", mTeamBText.getText().toString());
        startActivity(intent);
    }
}