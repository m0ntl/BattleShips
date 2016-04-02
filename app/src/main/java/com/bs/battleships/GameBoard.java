package com.bs.battleships;

import java.util.ArrayList;

/**
 * Created by montl on 27/03/2016.
 */
public class GameBoard extends ArrayList<Cell> {
    private int height, width;
    public GameBoard(int height, int width) {
        super(height * width);
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
