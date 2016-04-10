package com.bs.battleships;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class MainMenu extends AppCompatActivity {



    private int level = GameBoard.LEVEL_NORMAL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("gameLevel", level);
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.level_option1:
                if (checked)
                    level = GameBoard.LEVEL_EASY;
                    break;
            case R.id.level_option2:
                if (checked)
                    level = GameBoard.LEVEL_NORMAL;
                    break;
            case R.id.level_option3:
                if (checked)
                    level = GameBoard.LEVEL_HARD;
                    break;
        }
    }
}
