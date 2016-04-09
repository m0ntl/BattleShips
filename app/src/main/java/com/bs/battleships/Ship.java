package com.bs.battleships;

/**
 * Created by montl on 10/04/2016.
 */
public class Ship {
    private static int idCounter=0;
    private int id, length, numHits=0;
    private Coordinate start;
    private Orientation shipOrientation;

    public Ship(int length, Coordinate start, Orientation shipOrientation){
        this.length = length;
        this.start = start;
        this.shipOrientation = shipOrientation;
        this.id = idCounter;
        idCounter++;
    }
    public void hitShip(){
        this.numHits++;
    }
    public boolean isDrowned(){
        return length == numHits;
    }

}
