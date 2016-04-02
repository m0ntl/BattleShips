package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by montl on 27/03/2016.
 */
public class GameBoard /*implements Parcelable*/{

    private int height, width;
    ArrayList<Cell> boardArray;

    public GameBoard(int height, int width) {
        this.height = height;
        this.width = width;
        this.boardArray = new ArrayList<Cell>(height*width);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    public boolean wonGame(){
        for(Cell c : boardArray){
            if((!c.isHit()) && c.containsShip()){
                return false;
            }
        }
        return true;
    }

    public Cell get(int position){
        return boardArray.get(position);
    }

    public void add(Cell c){
        boardArray.add(c);
    }

    public ArrayList getBoard(){
        return boardArray;
    }

    public int size(){
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
