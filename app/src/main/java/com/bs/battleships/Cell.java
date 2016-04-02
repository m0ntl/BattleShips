
package com.bs.battleships;

/**
 * Created by montl on 27/03/2016.
 * Cell class to construct the board array.
 */
public class Cell {
    private boolean hasShip;
    private int shipID;
    boolean hit;

    public Cell(boolean hasShip, int shipID) {
        this.hasShip = hasShip;
        this.shipID = shipID;
        this.hit = false;
    }

    public Cell() {
        this.hasShip = false;
        this.hit = false;
    }

    public boolean containsShip(){
        return hasShip;
    }
    public boolean addShip(int shipID){
        if (containsShip()) {
            return false;
        }
        this.hasShip = true;
        this.shipID = shipID;
        return true;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit() {
        this.hit = true;
    }

    public int getImage(){
        if(!isHit()){
            return R.drawable.empty;
        } else if(containsShip()){
            return R.drawable.fire;
        } else {
            return R.drawable.water;
        }
    }

    public String toString(){
        if(hit){
            return "Was hit";
        }
        return "Not hit" ;
    }
}
