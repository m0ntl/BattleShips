package com.bs.battleships;

import android.util.Log;

/**
 * Created by montl on 10/04/2016.
 */
public class Ship implements Comparable<Ship> {
    private static int idCounter=0;
    private int id, location, length, numHits=0;
    //private Coordinate start;
    private Orientation shipOrientation;

    public Ship(int length, int location, Orientation shipOrientation){
        Log.i("In ship constructor", "the orientation is: "+shipOrientation.name());
        this.length = length;
        this.location = location;
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
    public Orientation getOrientation() {
        return shipOrientation;
    }
    public int getLocation() {
        return location;
    }
    public int getLength() {
        return length;
    }
    public int getID(){
        return id;
    }

    @Override
    public int compareTo(Ship other) {
        return this.id - other.id;
    }
}
