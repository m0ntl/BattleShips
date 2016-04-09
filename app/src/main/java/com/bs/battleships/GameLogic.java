package com.bs.battleships;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by montl on 10/04/2016.
 */
public class GameLogic {
    public static void GameLogic(){
    }

    public static void opponentNextTurn(GameBoard board){
        int location, max = board.boardSize();
        boolean legalHit = false;
        Random RANDOM = new Random();
        //while(!legalHit){
            //Choose a random location to hit
            //location = RANDOM.nextInt(max + 1);
            //check that location is legal
            //if(!board.getCell(location).isHit()){
                //hit location and exit loop
                //board.getCell(location).setHit();
                //legalHit=true;
            //}
        //}
    }

    public static Orientation randomOrientation(){
        Random RANDOM = new Random();
        return Orientation.values()[RANDOM.nextInt(Orientation.values().length)];
    }

    public static Coordinate shipLocation(Orientation orientation,int shipLength, ArrayList<Ship> shipArray, int boardHeight, int boardWidth){
        Random RANDOM = new Random();
        int widthLimit, heightLimit;
        //determine edge location to place the ship taking in to account ship length and it's orientation
        if(orientation == Orientation.HORIZONTAL){
            widthLimit = boardWidth - shipLength;
            heightLimit = boardHeight;
        } else {
            widthLimit = boardWidth;
            heightLimit = boardHeight - shipLength;
        }

        Coordinate c = new Coordinate(RANDOM.nextInt(widthLimit+1),RANDOM.nextInt(heightLimit+1));


        return c;
    }

    /*public static boolean shipOverlapps(Coordinate start, Orientation orientation, int shipLength, GameBoard board){
        int stepSize;
        if(orientation == Orientation.HORIZONTAL){
            stepSize=1;
        } else {
            stepSize = board.
        }
        return false;
    }*/
}







