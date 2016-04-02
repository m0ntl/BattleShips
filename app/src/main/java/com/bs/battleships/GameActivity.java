package com.bs.battleships;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    private GameBoard playerBoard, opponentBoard;
    private BoardAdapter playerBoardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Board size should be received from the main activity
        int boardHeight = 8, boardWidth = 6;
        this.playerBoard = new GameBoard(boardHeight, boardWidth);

        for(int i =0; i < (boardHeight*boardWidth);i++){
            playerBoard.add(new Cell());
        }

        GridView gridview = (GridView) findViewById(R.id.gameBoardContainer);
        this.playerBoardAdapter = new BoardAdapter(this,playerBoard);
        gridview.setAdapter(playerBoardAdapter);
        gridview.setOnItemClickListener(itemClickedListener);
        gridview.setNumColumns(boardWidth);
    }

    AdapterView.OnItemClickListener itemClickedListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            /*Toast.makeText(GameActivity.this, "item at pos: " + position,
                    Toast.LENGTH_SHORT).show();
                    */
            playerBoard.get(position).setHit();
            playerBoardAdapter.notifyDataSetChanged();

        }
    };
}