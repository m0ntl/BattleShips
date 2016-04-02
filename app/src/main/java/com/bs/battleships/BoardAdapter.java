package com.bs.battleships;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by montl on 02/04/2016.
 */
public class BoardAdapter extends ArrayAdapter<Cell> {
    private Context mContext;
    private GameBoard board;

    public BoardAdapter(Context context, ArrayList<Cell> gameBoard) {
        super(context,6,gameBoard);
        this.mContext = context;
        this.board = (GameBoard)gameBoard;
    }

    /*public BoardAdapter(Context context, int resource) { //for testing, need to delete
        super(context, resource);
        this.mContext = context;
    }*/

    public int getCount() {
        return board.size();
    }
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        } else {
            imageView = (ImageView) convertView;
        }


        Cell cell = getItem(position);


        //imageView.setImageResource();
        imageView.setImageResource(cell.getImage());
        return imageView;
    }
}
