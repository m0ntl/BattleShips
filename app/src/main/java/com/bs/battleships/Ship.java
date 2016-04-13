package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by montl on 10/04/2016.
 */
public class Ship implements Comparable<Ship>,Parcelable {
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

    protected Ship(Parcel in) {
        id = in.readInt();
        location = in.readInt();
        length = in.readInt();
        numHits = in.readInt();
        shipOrientation = (Orientation) in.readValue(Orientation.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(location);
        dest.writeInt(length);
        dest.writeInt(numHits);
        dest.writeValue(shipOrientation);
    }

    public static final Parcelable.Creator<Ship> CREATOR = new Parcelable.Creator<Ship>() {
        @Override
        public Ship createFromParcel(Parcel in) {
            return new Ship(in);
        }

        @Override
        public Ship[] newArray(int size) {
            return new Ship[size];
        }
    };
}
