package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by montl on 10/04/2016.
 */
public class ShipArray implements Parcelable{
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

    protected ShipArray(Parcel in) {
        if (in.readByte() == 0x01) {
            shipArray = new ArrayList<Ship>();
            in.readList(shipArray, Ship.class.getClassLoader());
        } else {
            shipArray = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (shipArray == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(shipArray);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ShipArray> CREATOR = new Parcelable.Creator<ShipArray>() {
        @Override
        public ShipArray createFromParcel(Parcel in) {
            return new ShipArray(in);
        }

        @Override
        public ShipArray[] newArray(int size) {
            return new ShipArray[size];
        }
    };
}
