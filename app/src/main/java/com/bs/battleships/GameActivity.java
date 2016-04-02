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
        int boradHeight = 8, boradWidth = 6;
        this.playerBoard = new GameBoard(boradHeight, boradWidth);
        //GameBoard opponentBoard = new GameBoard(BoradHeight, BoradWidth);

        for(int i =0; i < (boradHeight*boradWidth);i++){
            playerBoard.add(new Cell());
        }

        GridView gridview = (GridView) findViewById(R.id.gameBoardContainer);
        this.playerBoardAdapter = new BoardAdapter(this,playerBoard);
        gridview.setAdapter(playerBoardAdapter);
        gridview.setOnItemClickListener(itemClickedListener);

        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                playerBoard.get(position).isHit();
                /*playerBoardAdapter.notifyDataSetChanged();

            }
        });*/
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

            /*Cell cell = cells.get(position);
            if (cell.getStatus() != Cell.FLAGGED) {

                cell.setClickable(false);
                Log.d("prss on: ", " " + position);

                if (!isGameStart()) {
                    startTime();
                    setRandomMines(position, level);
                    putNumbers();
                }

                if (cell.getIsMined()) {
                    setEndGame(position);
                }

                if (cell.getNumberOfMines() > 0) {
                    cell.setStatus(Cell.NUMBER);
                    numberOfOpenCell++;
                    openCells.add(cell);
                }

                if (cell.getNumberOfMines() == 0) {
                    openRec(cell);
                }

                //String s1 = String.valueOf(numberOfMinesInGame-flags.size());
                String s1 = String.format("%d",numberOfMinesInGame-flags.size());
                flagesView.setText(s1);
                //flagesView.setText(""+(numberOfMinesInGame-flags.size()));
                adapter.notifyDataSetChanged();
                Log.d("numberOfOpenCell: ", " " + numberOfOpenCell);

                if(row*col-numberOfMinesInGame == numberOfOpenCell)
                    winGame();
            }
        }*/


    };
}