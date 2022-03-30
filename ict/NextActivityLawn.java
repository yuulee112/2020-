package com.example.ict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class NextActivityLawn extends AppCompatActivity {

    TextView text;
    Button btf, btg, bth, bta, btb, btc, btd, bte;
    ImageView rotc, image_bag;
    Intent intent, intent2;
    TableLayout table_bag;

    @SuppressLint("StaticFieldLeak")
    public static Context lawn_Context;

    public void start_lawn(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_lawn);

        final Global_Class status = (Global_Class) getApplicationContext();

        lawn_Context = this;
        status.kk = 7;
        status.intent_g = new Intent(NextActivityLawn.this, Egg.class);

        text =  findViewById(R.id.textView26);

        rotc =  findViewById(R.id.imageView7);
        rotc.setVisibility(View.INVISIBLE);

        btf =  findViewById(R.id.button111);  //나가기
        btf.setVisibility(View.VISIBLE);

        btg =  findViewById(R.id.button112);  //다음
        btg.setVisibility(View.VISIBLE);

        bth =  findViewById(R.id.button115);  //게임하기
        bth.setVisibility(View.INVISIBLE);

        intent = new Intent(getApplicationContext(), Map_SungShin.class); //지도화면으로 가게 수정하기!!!!
        intent2 = new Intent(getApplicationContext(), RotcGame.class);  //게임장

        image_bag =  findViewById(R.id.imageView17);  //가방

        table_bag =  findViewById(R.id.table3);  //가방창
        table_bag.setVisibility(View.INVISIBLE);

        bta =  findViewById(R.id.button128);  //칸 1
        btb =  findViewById(R.id.button129);  //칸 2
        btc =  findViewById(R.id.button130);  //칸 3
        btd =  findViewById(R.id.button131);  //칸 4
        bte =  findViewById(R.id.button132);  //칸 5

        btg.setOnClickListener(new View.OnClickListener() { //다음->
            int sum = 0;

            @Override
            public void onClick(View v) {
                sum++;
                if (sum == 1) {
                    rotc.setVisibility(View.VISIBLE);
                    text.setText(getString(R.string.rotc));
                }
                else if (sum == 2) text.setText(getString(R.string.rotc2));
                else if (sum == 3) text.setText("우리가 주는 쪽지를 열면 \n 랜덤성신코인을 줄게!");
                else if (sum == 4) {
                    text.setText("다만 코인이 감점될 위험도 있어. \n 열어볼래? ");
                    bth.setVisibility(View.VISIBLE);
                    btg.setVisibility(View.INVISIBLE);
                }
            }
        });

        bth.setOnClickListener(new View.OnClickListener() {  //게임하기
            @Override
            public void onClick(View view) {
                startActivity(intent2);
            }
        });


        btf.setOnClickListener(new View.OnClickListener() {  //나가기
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        image_bag.setOnClickListener(new View.OnClickListener() {
            Global_Class status = (Global_Class) getApplicationContext();

            @Override
            public void onClick(View view) {

                if (status.bag[0] == 100){
                    bta.setBackgroundResource(R.drawable.coinbag);
                    bta.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[1] == 100){
                    btb.setBackgroundResource(R.drawable.coinbag);
                    btb.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[2] == 100){
                    btc.setBackgroundResource(R.drawable.coinbag);
                    btc.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[3] == 100){
                    btd.setBackgroundResource(R.drawable.coinbag);
                    btd.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[4] == 100){
                    bte.setBackgroundResource(R.drawable.coinbag);
                    bte.setText(getString(R.string.blank, status.getCoin()));
                }
                if(status.bag[0] == 101){
                    bta.setBackgroundResource(R.drawable.andaebag);
                    bta.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[1] == 101){
                    btb.setBackgroundResource(R.drawable.andaebag);
                    btb.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[2] == 101){
                    btc.setBackgroundResource(R.drawable.andaebag);
                    btc.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[3] == 101){
                    btd.setBackgroundResource(R.drawable.andaebag);
                    btd.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[4] == 101){
                    bte.setBackgroundResource(R.drawable.andaebag);
                    bte.setText(getString(R.string.blank, status.getAn()));
                }
                if(status.bag[0] == 102){
                    bta.setBackgroundResource(R.drawable.dollbag);
                    bta.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[1] == 102){
                    btb.setBackgroundResource(R.drawable.dollbag);
                    btb.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[2] == 102){
                    btc.setBackgroundResource(R.drawable.dollbag);
                    btc.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[3] == 102){
                    btd.setBackgroundResource(R.drawable.dollbag);
                    btd.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[4] == 102){
                    bte.setBackgroundResource(R.drawable.dollbag);
                    bte.setText(getString(R.string.blank, status.getDoll()));
                }
                if(status.bag[0] == 103){
                    bta.setBackgroundResource(R.drawable.sujeongbag);
                    bta.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[1] == 103){
                    btb.setBackgroundResource(R.drawable.sujeongbag);
                    btb.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[2] == 103){
                    btc.setBackgroundResource(R.drawable.sujeongbag);
                    btc.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[3] == 103){
                    btd.setBackgroundResource(R.drawable.sujeongbag);
                    btd.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[4] == 103){
                    bte.setBackgroundResource(R.drawable.sujeongbag);
                    bte.setText(getString(R.string.blank, status.getMi()));
                }
                if(status.bag[0] == 104){
                    bta.setBackgroundResource(R.drawable.biscuit);
                    bta.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[1] == 104){
                    btb.setBackgroundResource(R.drawable.biscuit);
                    btb.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[2] == 104){
                    btc.setBackgroundResource(R.drawable.biscuit);
                    btc.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[3] == 104){
                    btd.setBackgroundResource(R.drawable.biscuit);
                    btd.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[4] == 104){
                    bte.setBackgroundResource(R.drawable.biscuit);
                    bte.setText(getString(R.string.blank, status.getBis()));
                }
                if(table_bag.getVisibility()==View.INVISIBLE){
                    table_bag.setVisibility(View.VISIBLE);
                }
                else{
                    table_bag.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(NextActivityLawn.this);
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
                ActivityCompat.finishAffinity(NextActivityLawn.this);
                System.exit(0);
            }
        });
    }
}