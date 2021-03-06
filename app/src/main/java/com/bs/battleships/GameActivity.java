package com.bs.battleships;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    private static int[] shipLengthIndex = {2, 3, 3, 4, 4}; //used to define ship length by ship number
    private Random RANDOM = new Random();
    int numOfShips;
    int boardHeight, boardWidth;
    boolean legalTurn;

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
        Intent myIntent = getIntent(); // gets the previously created intent
        int level = myIntent.getIntExtra("gameLevel", GameBoard.LEVEL_NORMAL);

        setContentView(R.layout.game_activity_view);

        //write to log
        Log.i("PlayerTurnActivity", "creating now: ");

        //save context for reference inside inner classes
        context = getApplicationContext();

        /*  todo: move */
        numOfShips = 5;
        GameBoard.setLevel(level);
        this.playerBoard = new GameBoard(level);
        callAddShips(numOfShips, playerBoard);

        //Player grid view init
        playerGridView = (GridView) findViewById(R.id.playerTurnView);
        playerBoardAdapter = new BoardAdapter(this, playerBoard);
        playerGridView.setAdapter(playerBoardAdapter);
        playerGridView.setOnItemClickListener(itemClickedListener);
        playerGridView.setNumColumns(GameBoard.getColumnCount());

        //Opponent init
        this.opponentBoard = new GameBoard(level);
        callAddShips(numOfShips, opponentBoard);

        //Opponent grid view init
        opponentGridview = (GridView) findViewById(R.id.opponentTurnView);
        opponentBoardAdapter = new BoardAdapter(this, opponentBoard);
        opponentGridview.setAdapter(opponentBoardAdapter);
        opponentGridview.setNumColumns(GameBoard.getColumnCount());
    }

    AdapterView.OnItemClickListener itemClickedListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            /*Toast.makeText(GameActivity.this, "item at pos: " + position,
                    Toast.LENGTH_SHORT).show();
                    */
            if (!playerBoard.cellIsHit(position)) {
                playerBoard.hitCell(position);
                playerBoardAdapter.notifyDataSetChanged();
                if (playerBoard.wonGame()) {//will change to move to score activity
                    //Toast.makeText(GameActivity.this,"You have won",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, ResultActivity.class);
                    intent.putExtra("ResultMessage", "You have won!!!");
                    startActivity(intent);
                } else {
                    //Toast.makeText(GameActivity.this, "Opponent's turn now", Toast.LENGTH_SHORT).show();
                    opponentTurn();
                }
            }
        }
    };

    private void opponentTurn() {
        //Log.i("opponent turn ", "playing opponent now");
        boolean legalTurn = false;
        int hitPosition = 0;
        while (!legalTurn) {
            hitPosition = RANDOM.nextInt(opponentBoard.boardSize());
            if (!opponentBoard.cellIsHit(hitPosition)) {
                legalTurn = true;
            }
        }
        opponentBoard.hitCell(hitPosition);
        opponentBoardAdapter.notifyDataSetChanged();
        if (opponentBoard.wonGame()) {
            Toast.makeText(GameActivity.this, "Opponent has won", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("ResultMessage", "You have lost!!!");
            startActivity(intent);
        }
        //Toast.makeText(GameActivity.this, "Your turn now", Toast.LENGTH_SHORT).show();
    }

    private void callAddShips(int numShips, GameBoard board) {
        int position, ori;
        Orientation o;
        //loop for number of ships
        while (numShips > 0) {
            //Random position
            position = RANDOM.nextInt(board.boardSize() + 1);
            //Random Orientation
            ori = RANDOM.nextInt(2);
            o = Orientation.values()[ori];
            //Log.i("Adam in loop111 ", Integer.toString(ori));
            //If adding the ship succeeds reduce the number of ships left to add.
            if (board.addShip(new Ship(shipLengthIndex[numShips - 1], position, o))) {
                numShips--;
            }
        }
    }

}