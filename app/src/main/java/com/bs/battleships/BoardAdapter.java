package com.bs.battleships;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Gallery;
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

    public BoardAdapter(Context context, GameBoard gameBoard) {
        super(context, 0, gameBoard.getBoard());
        this.mContext = context;
        this.board = gameBoard;
    }

    public int getCount() {
        return board.boardSize();
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

            final int dimenPix = (int) mContext.getResources().getDimension(R.dimen.dimen_imageview_width_dp);//84
           // imageView.setLayoutParams(new GridView.LayoutParams(dimenPix, dimenPix));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            //imageView.setPadding(2,2, 2, 2);



//            //get windows display size in pixels
//            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
//            Display display = wm.getDefaultDisplay();
//            Point size = new Point();
//            display.getSize(size);
//            double dispWidth = size.x;
//            double dispHeight = size.y;
//
//          //  double iconWidth = ( dispWidth - dispWidth/2 - board.getWidth()*5)/board.getWidth();
//            /*Log.i("Adam: ", "dispWidth: "+new Double(dispWidth).toString());
//            Log.i("Adam: ", "dispWidth - dispWidth/2: "+new Double(dispWidth - dispWidth/2).toString());
//            Log.i("Adam: ", "board.getWidth(): "+new Double(board.getWidth()).toString());
//            Log.i("Adam: ", "dispWidth - dispWidth/2 - board.getWidth()*5: "+new Double(dispWidth - dispWidth/2 - board.getWidth()*5).toString());
//            Log.i("Adam: ", "( dispWidth - dispWidth/2 - board.getWidth()*5)/board.getWidth(): " + new Double(iconWidth).toString());*/
//
//          //  double iconHeight = ((dispHeight/3)*2 - 450 - board.getHeight()*10)/board.getHeight();
//            /*Log.i("Adam: ", "dispHeight: "+new Double(dispHeight).toString());
//            Log.i("Adam: ", "dispHeight/3: "+new Double(dispHeight/3).toString());
//            Log.i("Adam: ", "(dispHeight/3)*2: "+new Double((dispHeight/3)*2).toString());
//            Log.i("Adam: ", "board.getHeight()*5: "+new Double(board.getHeight()*5).toString());
//            Log.i("Adam: ", "dispHeight/3)*2 - 40 - board.getHeight()*5: "+new Double(dispWidth - dispWidth/2 - board.getWidth()*5).toString());
//            Log.i("Adam: ", "((dispHeight/3)*2 - 40 - board.getHeight()*5)/board.getHeight(): "+new Double(iconHeight).toString());*/
////
//          //  imageView.setLayoutParams(new GridView.LayoutParams((int)(iconWidth), (int)(iconHeight)));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//           // imageView.setPadding(10,10,0,20);
        } else {
            imageView = (ImageView) convertView;
        }

        Cell cell = getItem(position);
        imageView.setImageResource(cell.getImageId());
        return imageView;
    }
}
