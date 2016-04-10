package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

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

    public int boardSize() {
        return boardArray.size();
    }

    public boolean addShip(Ship ship){
        if(shipInBorder(ship) && notOverlappingShip(ship)){
            ships.addShip(ship);
            updateBoard(ship);
            return true;
        }
        return false;
    }

    private void updateBoard(Ship ship) {
        //go over cells in board and update them that there is a ship there
        int stepSize,position = ship.getLocation();
        //check if the ship overlaps any other ship on the board
        if(ship.getOrientation() == Orientation.HORIZONTAL){
            stepSize = 1;
        } else {
            stepSize = width;
        }
        for(int i=0;i<ship.getLength();i++){
            //hitCell(position);
            boardArray.get(position).addShip(ship.getID());
            position = position + stepSize;
        }
    }

    private boolean shipInBorder(Ship ship) {
        //check that the ship is inside the borders of the game board
        if(ship.getOrientation() == Orientation.HORIZONTAL){
            //check that the end of the ship is on the board
            if(ship.getLocation()+ship.getLength() >= boardSize()){
                return false;
            }
            //check that the beginning and end of the ship fit on the same row
            if (ship.getLocation() % width != ship.getLocation()+ship.getLength() % width){
                return false;
            }
        } else { //ship orientation is vertical
            //check that the ship is on the board
            if(ship.getLocation()+ (ship.getLength()-1)*width > boardSize()){
                return false;
            }
            //no need to check that the ship fits on the same row because if it does not the
            //end of the ship will be outside the board.
        }
        return true;
    }
    private boolean notOverlappingShip(Ship ship){
        int stepSize=3,position = ship.getLocation();
        //check if the ship overlaps any other ship on the board
        if(ship.getOrientation() == Orientation.HORIZONTAL){
            stepSize = 1;
            Log.i("Adam ship", "I added a ship horizontally: ");
        } else if(ship.getOrientation() == Orientation.VERTICAL){
            stepSize = width;
            Log.i("Adam ship", "I added a ship vertically: ");
        }
        for(int i=0;i<ship.getLength();i++){
            if(checkCellHit(position)){
                return false;
            }
            position = position + stepSize;
        }
        return true;
    }
    public boolean checkCellHit(int position){
        return boardArray.get(position).isHit();
    }
    public void hitCell(int position){
        boardArray.get(position).setHit();
    }
}
