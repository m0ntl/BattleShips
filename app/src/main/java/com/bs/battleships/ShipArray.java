package com.bs.battleships;

import java.util.ArrayList;

/**
 * Created by montl on 08/04/2016.
 */
public class ShipArray {
    private ArrayList<Ship> shipArray;
    private static int[] shipLength = {2,3,4,4,5};

    public ShipArray(int numOfShips){

    }
    //public Ship(int length, Coordinate start, Orientation shipOrientation)
    private Ship initShip(int shipNum){
        Orientation orientation = GameLogic.randomOrientation();
        //Coordinate start = GameLogic.shipLocation(orientation,shipLength[shipNum],shipArray);   here is where I am working
        return new Ship(shipLength[shipNum],new Coordinate(1,1),orientation);//here also, think about coordinate of start
    }
}
