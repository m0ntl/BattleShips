package com.bs.battleships;

/**
 * Created by montl on 10/04/2016.
 */
public class Coordinate {
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
}
