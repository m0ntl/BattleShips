package com.bs.battleships;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    GameBoard playerBoard;
    GameBoard opponentBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Board size should be received from the main activity
        int boradHeight = 8, boradWidth = 6;
        GameBoard playerBoard = new GameBoard(boradHeight, boradWidth);
        //GameBoard opponentBoard = new GameBoard(BoradHeight, BoradWidth);

        for(int i =0; i < (boradHeight*boradWidth);i++){
            playerBoard.add(new Cell());
        }

        GridView gridview = (GridView) findViewById(R.id.gameBoardContainer);
        gridview.setAdapter(new BoardAdapter(this,playerBoard));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(GameActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}