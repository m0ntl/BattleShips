
package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by montl on 27/03/2016.
 * Cell class to construct the board array.
 */
public class Cell implements Parcelable{
    private boolean hasShip;
    private int shipID;
    private boolean hit;
    private boolean drowned;

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
    public int getShipID(){
        return shipID;
    }

    protected Cell(Parcel in) {
        hasShip = in.readByte() != 0x00;
        shipID = in.readInt();
        hit = in.readByte() != 0x00;
        drowned = in.readByte() != 0x00;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (hasShip ? 0x01 : 0x00));
        dest.writeInt(shipID);
        dest.writeByte((byte) (hit ? 0x01 : 0x00));
        dest.writeByte((byte) (drowned ? 0x01 : 0x00));
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Cell> CREATOR = new Parcelable.Creator<Cell>() {
        @Override
        public Cell createFromParcel(Parcel in) {
            return new Cell(in);
        }

        @Override
        public Cell[] newArray(int size) {
            return new Cell[size];
        }
    };
}
