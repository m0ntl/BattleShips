
package com.bs.battleships;

/**
 * Created by montl on 27/03/2016.
 * Cell class to construct the board array.
 */
public class Cell {
    private boolean hasShip;
    private int shipID;
    private boolean hit, drowned;

    public Cell() {
        this.hasShip = false;
        this.hit = false;
    }

    public boolean containsShip(){
        return hasShip;
    }
    public void addShip(int shipID){
        this.hasShip = true;
        this.shipID = shipID;
    }

    public boolean isHit() {
        return hit;
    }
    public void setHit() {
        this.hit = true;
    }
    public boolean isDrowned(){
        return drowned;
    }
    public void setDrowned(){
        this.drowned = true;
    }

    public int getImageId(){
        if(!isHit()){ //square not opened yet
            return R.drawable.unselected;
        } else if(containsShip()){//square opened and contains ship
            if(isDrowned()){//ship is drowned
                return R.drawable.ic_sunk_ship;
            }else {//ship not drowned
                return R.drawable.ic_ship;
            }
        }else {//cell is empty
            return R.drawable.ic_empty;
        }
    }
}
