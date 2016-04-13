package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by montl on 27/03/2016.
 */
public class GameBoard /*implements Parcelable*/ {

    protected final static int LEVEL_EASY = 0;
    protected final static int LEVEL_NORMAL = 1;
    protected final static int LEVEL_HARD = 2;

    /* todo: change names to columns and rows */
    private final static int LEVEL_EASY_WIDTH = 8;
    private final static int LEVEL_EASY_HEIGHT = 6;
    private final static int LEVEL_NORMAL_WIDTH = 10;
    private final static int LEVEL_NORMAL_HEIGHT = 8;
    private final static int LEVEL_HARD_WIDTH = 13;
    private final static int LEVEL_HARD_HEIGHT = 7;

    private final static int COLUMN_COUNT[] =
            {LEVEL_EASY_WIDTH, LEVEL_NORMAL_WIDTH, LEVEL_HARD_WIDTH};
    private final static int ROW_COUNT[] =
            {LEVEL_EASY_HEIGHT, LEVEL_NORMAL_HEIGHT, LEVEL_HARD_HEIGHT};


    //(6,8),(6,10),(6,12)
 //   int boardHeight = 6;
 //   int boardWidth = 12;
  //  int numOfShips = 5;

    private static int level = LEVEL_NORMAL;

    private int height, width;
    private ArrayList<Cell> boardArray;
    private ShipArray ships;

    /* todo: remove? */
    public GameBoard(int width, int height) {
        this.height = height;
        this.width = width;
        this.boardArray = new ArrayList<>();
        //add cells to the cell array
        for (int i = 0; i < width * height; i++) {
            addCell(new Cell());
        }
        ships = new ShipArray();
    }

    public GameBoard(int l) {
        level = l;
        /* todo: remove use of width var */
        width = COLUMN_COUNT[l];
        this.boardArray = new ArrayList<>();
        //add cells to the cell array
        int celNum = COLUMN_COUNT[l] * ROW_COUNT[l];
        for (int i = 0; i < celNum; i++) {
            addCell(new Cell());
        }
        ships = new ShipArray();
    }


    private void addCell(Cell c) {
        boardArray.add(c);
    }

    public boolean wonGame() {
        return ships.allShipsDrowned();
    }

    public ArrayList getBoard() {
        return boardArray;
    }

    public int boardSize() {
        return boardArray.size();
    }

    public boolean addShip(Ship ship) {
        if (shipInBorder(ship) && notOverlappingShip(ship)) {
            ships.addShip(ship);
            updateBoard(ship);
            return true;
        }
        return false;
    }

    private void updateBoard(Ship ship) {
        //go over cells in board and update them that there is a ship there
        int stepSize, position = ship.getLocation();
        //check if the ship overlaps any other ship on the board
        if (ship.getOrientation() == Orientation.HORIZONTAL) {
            stepSize = 1;
        } else {
            stepSize = width;
        }
        for (int i = 0; i < ship.getLength(); i++) {
            //hitCell(position);
            //Log.i("***********", "position=" + position + " boardArray.size=" + boardArray.size());
            /* todo: check */
            if (position < boardArray.size()) {
                boardArray.get(position).addShip(ship.getID());
                position = position + stepSize;
            }
        }
    }

    private boolean shipInBorder(Ship ship) {
        //check that the ship is inside the borders of the game board
        if (ship.getOrientation() == Orientation.HORIZONTAL) {
            //check that the end of the ship is on the board
            if (ship.getLocation() + ship.getLength() >= boardSize()) {
                return false;
            }
            //check that the beginning and end of the ship fit on the same row
            if ((ship.getLocation() / width) != ((ship.getLocation() + ship.getLength()) / width)) {
                return false;
            }
        } else { //ship orientation is vertical
            //check that the ship is on the board
            if (ship.getLocation() + (ship.getLength() - 1) * width >= boardSize()) {
                return false;
            }
            //no need to check that the ship fits on the same row because if it does not the
            //end of the ship will be outside the board.
        }
        return true;
    }

    private boolean notOverlappingShip(Ship ship) {
        int stepSize, position = ship.getLocation();
        //check if the ship overlaps any other ship on the board
        if (ship.getOrientation() == Orientation.HORIZONTAL) {
            stepSize = 1;
        } else {
            stepSize = width;
        }
        for (int i = 0; i < ship.getLength(); i++) {
            if (cellHasShip(position)) {
                return false;
            }
            position = position + stepSize;
        }
        return true;
    }

    public boolean cellIsHit(int position) {
        return boardArray.get(position).isHit();
    }

    public void hitCell(int position) {
        boardArray.get(position).setHit();
        //if cell contains a ship
        if (boardArray.get(position).containsShip()) {
            //find the ship id
            int id = boardArray.get(position).getShipID();
            //hit the ship
            ships.hitShip(id);
            //if ship has drowned update all cells to know that
            if (ships.shipHasDrowned(id)) {
                updateShipDrowned(ships.getShipByID(id));
            }
        }

    }

    private void updateShipDrowned(Ship ship) {
        int stepSize, position = ship.getLocation();
        //check if the ship overlaps any other ship on the board
        if (ship.getOrientation() == Orientation.HORIZONTAL) {
            stepSize = 1;
        } else {
            stepSize = width;
        }
        for (int i = 0; i < ship.getLength(); i++) {
            //hitCell(position);
            boardArray.get(position).setDrowned();
            position = position + stepSize;
        }
    }

    private boolean cellHasShip(int position) {
        if (position >= boardArray.size()) {
            /* todo - check */
           // Log.i("********", "position=" + position + " boardArray.size=" + boardArray.size());
            return false;
        }
        return boardArray.get(position).containsShip();
    }

    protected static int getColumnCount() {
        return COLUMN_COUNT[level];
    }

    protected static void setLevel(int l) {
        level = l;

    }
}
