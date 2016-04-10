package com.bs.battleships;

import java.util.ArrayList;

/**
 * Created by montl on 10/04/2016.
 */
public class ShipArray {
    private ArrayList<Ship> shipArray;

    public ShipArray(){
        shipArray = new ArrayList<>();
    }
    public void addShip(Ship ship){
        shipArray.add(ship);
    }
    public boolean allShipsDrowned(){
        for(Ship s:shipArray){
            if(!s.isDrowned()){
                return false;
            }
        }
        return true;
    }
    //public Ship(int length, Coordinate start, Orientation shipOrientation)
    //private Ship initShip(int shipNum){
        Orientation orientation = GameLogic.randomOrientation();
        //Coordinate start = GameLogic.shipLocation(orientation,shipLength[shipNum],shipArray);   here is where I am working
        //return new Ship(shipLengthMeter[shipNum],new Coordinate(1,1),orientation);//here also, think about coordinate of start
    //}
}
