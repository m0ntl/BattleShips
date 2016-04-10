package com.bs.battleships;

/**
 * Created by montl on 10/04/2016.
 */
public enum Orientation {
    HORIZONTAL(1),
    VERTICAL  (0)
    ;

    private final int shipOrientation;

    Orientation(int shipOrientation) {
        this.shipOrientation = shipOrientation;
    }

    public int getLevelCode() {
        return this.shipOrientation;
    }
}