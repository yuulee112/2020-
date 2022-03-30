package com.example.ict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class NextActivityGym extends AppCompatActivity {
    TextView text;
    Button bte1, btf, btg, bth, bta, btb, btc, btd, bte;
    Intent intent;
    ImageView image;
    TableLayout table;

    @SuppressLint("StaticFieldLeak")
    public static Context gym_Context;
    public void start_gym(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        final Global_Class status = (Global_Class) getApplicationContext();

        gym_Context = this;
        status.kk = 9;
        status.intent_g = new Intent(NextActivityGym.this, Egg.class);

        text = findViewById(R.id.textView17);

        bte1 =  findViewById(R.id.button51);  //운동 하기
        bte1.setVisibility(View.INVISIBLE);

        btf =  findViewById(R.id.button43);  //다음->
        btf.setVisibility(View.VISIBLE);

        btg =  findViewById(R.id.button45);  //나가기
        btg.setVisibility(View.VISIBLE);

        bth =  findViewById(R.id.button47);  //분홍색 창
        bth.setVisibility(View.INVISIBLE);

        intent = new Intent(getApplicationContext(), Map_SungShin.class); //지도화면으로 가게 수정하기!!!!

        image =  findViewById(R.id.imageView21);  //가방

        table =  findViewById(R.id.table7);  //가방창
        table.setVisibility(View.INVISIBLE);

        bta =  findViewById(R.id.button155);  //칸 1
        btb =  findViewById(R.id.button156);  //칸 2
        btc =  findViewById(R.id.button157);  //칸 3
        btd =  findViewById(R.id.button158);  //칸 4
        bte =  findViewById(R.id.button159);  //칸 5

        bte1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//운동하기

                text.setText("잘 선택했어! 운동 열심히 하자!");
                bth.setText("운동 중~");
                bth.setVisibility(View.VISIBLE);
                btf.setVisibility(View.INVISIBLE);
                btg.setVisibility(View.INVISIBLE);

                status.setHealth(status.getHealth()+1);
                status.setFull(status.getFull()-1);

                Handler mHandler0 = new Handler();
                mHandler0.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.INVISIBLE);
                    }
                }, 200);

                Handler mHandler1 = new Handler();
                mHandler1.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.VISIBLE);
                        text.setText("몸이 가벼워진 느낌이다. \n (체력 지수 +1, 배부름지수 -1)");
                        bth.setVisibility(View.INVISIBLE);
                    }
                }, 7000);

                Handler mHandler2 = new Handler();
                mHandler2.postDelayed(new Runnable()  {
                    public void run() {
                        text.setText("이제 뭐 할까? ");
                        btf.setVisibility(View.VISIBLE);
                        btg.setVisibility(View.VISIBLE);
                    }
                }, 8000);
            }
        });

        btf.setOnClickListener(new View.OnClickListener() { //다음->
            int sum = 0;

            @Override
            public void onClick(View v) {
                sum++;
                if (sum == 1) text.setText(" 수정이들은 여기서 \n 운동을 하고 샤워도 할 수 있어.");
                else if (sum == 2) {
                    text.setText(" 운동 한번 하고 갈래?");
                    bte1.setVisibility(View.VISIBLE);
                }
            }
        });

        btg.setOnClickListener(new View.OnClickListener() {  //나가기
            @Override
            public void onClick(View view) {
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
                if(table.getVisibility()==View.INVISIBLE){
                    table.setVisibility(View.VISIBLE);
                }
                else{
                    table.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(NextActivityGym.this);
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
                ActivityCompat.finishAffinity(NextActivityGym.this);
                System.exit(0);
            }
        });
    }
}