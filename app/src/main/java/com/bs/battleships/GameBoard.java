package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by montl on 27/03/2016.
 */
public class GameBoard /*implements Parcelable*/ {

    private int height, width;
    private ArrayList<Cell> boardArray;
    private ShipArray ships;

    public GameBoard(int width, int height) {
    //public GameBoard() {
        this.height = height;
        this.width = width;
        this.boardArray = new ArrayList<Cell>();
        //add cells to the cell array
        for (int i = 0; i < width*height; i++) {
            addCell(new Cell());
        }
        ships = new ShipArray();
    }

    private void addCell(Cell c){
        boardArray.add(c);
    }
    public boolean wonGame() {
        return ships.allShipsDrowned();
    }

    /*public Cell getCell(int position) {
        return boardArray.get(position);
    }

    public void addCell(Cell c) {
        boardArray.add(c);
    }*/

    public ArrayList getBoard() {
        return boardArray;
    }

    public void hit(int position){
        boardArray.get(position).setHit();
    }

    public int size() {
        return boardArray.size();
    }

    /*@Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeArray();
    }*/
}
