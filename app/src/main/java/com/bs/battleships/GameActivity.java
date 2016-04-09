package com.bs.battleships;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    //Player board creation
    private GridView playerGridView;
    private GameBoard playerBoard;
    private BoardAdapter playerBoardAdapter;


    //Opponent board creation
    GridView opponentGridview;
    private GameBoard opponentBoard;
    private BoardAdapter opponentBoardAdapter;

    //other variable creation
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity_view);

        //write to log
        Log.i("PlayerTurnActivity", "creating now: ");

        //save context for reference inside inner classes
        context = getApplicationContext();

        //Board size should be received from the main activity
        //(6,8),(6,10),(6,12)
        int boardHeight = 6, boardWidth = 12;

        //Player board init
        // this.playerBoard = new GameBoard(boardHeight, boardWidth);
        this.playerBoard = new GameBoard(boardWidth,boardHeight);


        //Player grid view init
        playerGridView = (GridView) findViewById(R.id.playerTurnView);
        playerBoardAdapter = new BoardAdapter(this, playerBoard);
        playerGridView.setAdapter(playerBoardAdapter);
        playerGridView.setOnItemClickListener(itemClickedListener);
        playerGridView.setNumColumns(boardWidth);

        this.opponentBoard = new GameBoard(boardWidth,boardHeight);

        //Opponent grid view init
        opponentGridview = (GridView) findViewById(R.id.opponentTurnView);
        opponentBoardAdapter = new BoardAdapter(this, opponentBoard);
        opponentGridview.setAdapter(opponentBoardAdapter);
        opponentGridview.setNumColumns(boardWidth);

    }

    AdapterView.OnItemClickListener itemClickedListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            /*Toast.makeText(GameActivity.this, "item at pos: " + position,
                    Toast.LENGTH_SHORT).show();
                    */
            playerBoard.hitCell(position);
            playerBoardAdapter.notifyDataSetChanged();

            if (playerBoard.wonGame()) {//will change to move to score activity
                //Toast.makeText(GameActivity.this,"You have won",Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(GameActivity.this, "Opponent's turn now", Toast.LENGTH_SHORT).show();
            opponentTurn();
        }
    };

    private void opponentTurn() {

    }

}