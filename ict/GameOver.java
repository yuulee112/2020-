package com.example.ict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class GameOver extends AppCompatActivity {

    Button first, exit;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        first = findViewById(R.id.button54);  //처음으로
        first.setVisibility(View.VISIBLE);

        exit = findViewById(R.id.button55);  //나가기
        exit.setVisibility(View.VISIBLE);

        intent = new Intent(getApplicationContext(), MainActivity.class);

        first.setOnClickListener(new View.OnClickListener() {  //처음으로
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {  //나가기
            @Override
            public void onClick(View view) {
                ActivityCompat.finishAffinity(GameOver.this);
                System.exit(0);
            }
        });
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(GameOver.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_activity);
        dialog.show();
        Button button = dialog.findViewById(R.id.backbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button button1 = dialog.findViewById(R.id.exitbtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(GameOver.this);
                System.exit(0);
            }
        });
    }
}