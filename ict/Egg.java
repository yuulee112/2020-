package com.example.ict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class Egg extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    Button but;
    int imageIndex = 0;
    Intent intent1, intent2, intent3, intent4, intent5, intent6, intent7, intent8, intent9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg);

        imageView = findViewById(R.id.imageView24);
        imageView2 = findViewById(R.id.imageView25);
        imageView3 = findViewById(R.id.imageView26);
        imageView4 = findViewById(R.id.imageView27);
        imageView5 = findViewById(R.id.imageView28);

        imageView.setVisibility(View.VISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        imageView4.setVisibility(View.INVISIBLE);
        imageView5.setVisibility(View.INVISIBLE);

        but = findViewById(R.id.button169);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
            }
        });


        intent1 = new Intent(this, EndingBreak.class);
        intent2 = new Intent(this, EndingFgrade.class);
        intent3 = new Intent(this, EndingForeign.class);
        intent4 = new Intent(this, EndingFull.class);
        intent5 = new Intent(this, EndingHealth.class);
        intent6 = new Intent(this, EndingOwl.class);
        intent7 = new Intent(this, EndingSleep.class);
        intent8 = new Intent(this, EndingTopgrade.class);
        intent9 = new Intent(this, EndingNormal.class);

    }
    public void changeImage() {
        if (imageIndex == 0) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            imageView4.setVisibility(View.INVISIBLE);
            imageView5.setVisibility(View.INVISIBLE);
        } else if (imageIndex == 1) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.VISIBLE);
            imageView4.setVisibility(View.INVISIBLE);
            imageView5.setVisibility(View.INVISIBLE);
        } else if (imageIndex == 2) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            imageView4.setVisibility(View.VISIBLE);
            imageView5.setVisibility(View.INVISIBLE);
        } else if (imageIndex == 3) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageView3.setVisibility(View.INVISIBLE);
            imageView4.setVisibility(View.INVISIBLE);
            imageView5.setVisibility(View.VISIBLE);
        }else if (imageIndex == 4){
            Global_Class status = (Global_Class) getApplicationContext();
            if(status.getSleep() >= 5){
                startActivity(intent7);
            }
            if(status.getKnow() < 0 || status.getHealth() < 0 || status.getWord() < 0 ||
                    status.getFull() < 0 || status.getLove() < 0 ){
                startActivity(intent1);
            }
            else if(status.getWord() >= 5){
                startActivity(intent3);
            }
            else if(status.getFull() >= 14){
                startActivity(intent4);
            }
            else if(status.getKnow() >= 20){
                startActivity(intent8);
            }
            else if(status.getHealth() >= 13){
                startActivity(intent5);
            }
            else if(status.getHealth() <= 5 && status.getKnow() >= 4){
                startActivity(intent6);
            }
            else{
                if(status.getExam() == 0){
                    startActivity(intent2);  //학고엔딩
                }
                if(status.getExam() >= 1){
                    startActivity(intent9);  //평범엔딩
                }
            }
        }
        imageIndex += 1;

    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(Egg.this);
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
                ActivityCompat.finishAffinity(Egg.this);
                System.exit(0);
            }
        });
    }
}