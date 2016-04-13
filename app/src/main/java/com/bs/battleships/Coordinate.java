package com.bs.battleships;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by montl on 10/04/2016.
 */
public class Coordinate implements Parcelable{
    private int x,y;
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void settX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }

    protected Coordinate(Parcel in) {
        x = in.readInt();
        y = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(x);
        dest.writeInt(y);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Coordinate> CREATOR = new Parcelable.Creator<Coordinate>() {
        @Override
        public Coordinate createFromParcel(Parcel in) {
            return new Coordinate(in);
        }

        @Override
        public Coordinate[] newArray(int size) {
            return new Coordinate[size];
        }
    };
}
