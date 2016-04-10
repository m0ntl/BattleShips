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
    private int findShipPositionByID(int ID){
        for(Ship s: shipArray){
            if(s.getID() == ID){
                return shipArray.indexOf(s);
            }
        }
        return -1;
    }
    public void hitShip(int id){
        shipArray.get(findShipPositionByID(id)).hitShip();
    }
    public boolean shipHasDrowned(int id){
        return shipArray.get(findShipPositionByID(id)).isDrowned();
    }
    public Ship getShipByID(int id){
        return shipArray.get(findShipPositionByID(id));
    }
}
