package com.bs.battleships;

/**
 * Created by montl on 10/04/2016.
 */
public enum Orientation {
    HORIZONTAL(0),
    VERTICAL  (1)
    ;

    private final int shipOrientation;

    Orientation(int shipOrientation) {
        this.shipOrientation = shipOrientation;
    }

    public int getLevelCode() {
        return this.shipOrientation;
    }
}