package com.example.ict;

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

import androidx.appcompat.app.AppCompatActivity;

public class NextActivitySsb extends AppCompatActivity {

    TextView text, text1, text2, text3, text4, text5;
    ImageView image;
    Button bt1, bt2, bta, btb, btc, btd, bte, time;
    TableLayout table, table2;
    public TextView timedisplay;

    @SuppressLint("StaticFieldLeak")
    public static Context ssb_Context;

    public void start_ssb(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ssb);

        ssb_Context = this;

        final Global_Class status = (Global_Class) getApplicationContext();
        status.kk = 1;
        status.intent_g = new Intent(NextActivitySsb.this, Egg.class);

        text =  findViewById(R.id.textView);

        timedisplay =  findViewById(R.id.textView29);
        timedisplay.setVisibility(View.INVISIBLE);

        text1 =  findViewById(R.id.textView6);  //지식 지수
        text2 =  findViewById(R.id.textView8);  //체력 지수
        text3 =  findViewById(R.id.textView9);  //어학 지수
        text4 =  findViewById(R.id.textView11);  //배부름 지수
        text5 =  findViewById(R.id.textView12);  //성신사랑 지수

        bt1 =  findViewById(R.id.button20);  //스탯 보기
        bt1.setVisibility(View.INVISIBLE);

        bt2 =  findViewById(R.id.button21);  //나가기
        bt2.setVisibility(View.INVISIBLE);

        table =  findViewById(R.id.table);  //내 정보창
        table.setVisibility(View.INVISIBLE);

        image =  findViewById(R.id.imageView16);  //가방

        table2 =  findViewById(R.id.table2);  //가방창
        table2.setVisibility(View.INVISIBLE);

        bta =  findViewById(R.id.button121);  //칸 1
        btb =  findViewById(R.id.button122);  //칸 2
        btc =  findViewById(R.id.button123);  //칸 3
        btd =  findViewById(R.id.button124);  //칸 4
        bte =  findViewById(R.id.button127);  //칸 5

        time =  findViewById(R.id.button174);  //시간 보기
        time.setVisibility(View.VISIBLE);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("내 스탯창을 볼래?");
                bt1.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.VISIBLE);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {

            Global_Class status = (Global_Class) getApplicationContext();
            int i = 0;

            @Override
            public void onClick(View v) {
                if(i == 0) {
                    text1.setText(getString(R.string.blank, status.getKnow()));
                    text2.setText(getString(R.string.blank, status.getHealth()));
                    text3.setText(getString(R.string.blank, status.getWord()));
                    text4.setText(getString(R.string.blank, status.getFull()));
                    text5.setText(getString(R.string.blank, status.getLove()));
                    table.setVisibility(View.VISIBLE);
                    i++;
                    bt1.setText("창 닫기");
                }
                else{
                    bt1.setText("스탯 보기");
                    table.setVisibility(View.INVISIBLE);
                    i--;
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Map_SungShin.class);
                startActivity(intent);
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
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

                if(table2.getVisibility()==View.INVISIBLE){
                    table2.setVisibility(View.VISIBLE);
                }
                else{
                    table2.setVisibility(View.INVISIBLE);
                }
            }
        });

        time.setOnClickListener(new View.OnClickListener(){
            int i = 0;
            @Override
            public void onClick(View view) {
                if(i == 0) {
                    timedisplay.setVisibility(View.VISIBLE);
                    resetText();
                    i++;
                }
                else{
                    timedisplay.setVisibility(View.INVISIBLE);
                    i--;
                }
            }
        });
    }

    protected void resetText() {
        Global_Class status = (Global_Class) getApplicationContext();
        timedisplay.setText(getString(R.string.time, status.watch));
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(NextActivitySsb.this);
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
                moveTaskToBack(true);
                finishAndRemoveTask();
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }
}
