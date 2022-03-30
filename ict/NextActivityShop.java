package com.example.ict;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class NextActivityShop extends AppCompatActivity {

    Button button, button2, button3, bta, btb, btc, btd, bte, bt1;
    ImageView imageView, imageView2, imageView3;
    LinearLayout ad, dll, mr;
    ImageView image;
    TableLayout table;

    @SuppressLint("StaticFieldLeak")
    public static Context shop_Context;

    public void start_shop(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        final Global_Class status = (Global_Class) getApplicationContext();

        shop_Context = this;
        status.kk = 4;
        status.intent_g = new Intent(NextActivityShop.this, Egg.class);

        button =  findViewById(R.id.button);  //안대
        button2 =  findViewById(R.id.button2);  //인형
        button3 =  findViewById(R.id.button3);  //거울
        imageView =  findViewById(R.id.imageView);  //안대그럼
        imageView2 =  findViewById(R.id.imageView2);  //인형그림
        imageView3 =  findViewById(R.id.imageView3);  //거울그림
        mr =  findViewById(R.id.mr);  //거울 상세설명
        dll =  findViewById(R.id.dll);  //인형 상세설명
        ad =  findViewById(R.id.ad);  //안대 상세설명

        imageView.setVisibility(View.INVISIBLE);
        imageView2.setVisibility(View.INVISIBLE);
        imageView3.setVisibility(View.INVISIBLE);
        mr.setVisibility(View.INVISIBLE);
        dll.setVisibility(View.INVISIBLE);
        ad.setVisibility(View.INVISIBLE);

        image = findViewById(R.id.imageView29);  //가방

        table =  findViewById(R.id.table9);  //가방창
        table.setVisibility(View.INVISIBLE);

        bta =  findViewById(R.id.button176);  //칸 1
        btb =  findViewById(R.id.button177);  //칸 2
        btc =  findViewById(R.id.button178);  //칸 3
        btd =  findViewById(R.id.button179);  //칸 4
        bte =  findViewById(R.id.button180);  //칸 5

        bt1 =  findViewById(R.id.button182); //나가기

        bt1.setOnClickListener(new View.OnClickListener() {
            Global_Class status = (Global_Class) getApplicationContext();
            @Override
            public void onClick(View view) {
                status.shop_count = 1;
                Intent intent = new Intent(getApplicationContext(), NextActivitySjb.class);
                startActivity(intent);
            }
        });

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView.getVisibility()==View.INVISIBLE || dll.getVisibility() == View.VISIBLE || mr.getVisibility() == View.VISIBLE){
                    imageView.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                    ad.setVisibility(View.INVISIBLE);
                    mr.setVisibility(View.INVISIBLE);
                    dll.setVisibility(View.INVISIBLE);
                }else{
                    imageView.setVisibility(View.INVISIBLE);
                    ad.setVisibility(View.INVISIBLE);
                }
            }
        }) ;
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView2.getVisibility()==View.INVISIBLE || ad.getVisibility() == View.VISIBLE || mr.getVisibility() == View.VISIBLE){
                    imageView.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.VISIBLE);
                    imageView3.setVisibility(View.INVISIBLE);
                    ad.setVisibility(View.INVISIBLE);
                    mr.setVisibility(View.INVISIBLE);
                }else {
                    imageView2.setVisibility(View.INVISIBLE);
                }
                dll.setVisibility(View.INVISIBLE);
            }
        }) ;

        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageView3.getVisibility()==View.INVISIBLE || dll.getVisibility() == View.VISIBLE || ad.getVisibility() == View.VISIBLE){
                    imageView.setVisibility(View.INVISIBLE);
                    imageView2.setVisibility(View.INVISIBLE);
                    imageView3.setVisibility(View.VISIBLE);
                    ad.setVisibility(View.INVISIBLE);
                    mr.setVisibility(View.INVISIBLE);
                    dll.setVisibility(View.INVISIBLE);
                }else {
                    imageView3.setVisibility(View.INVISIBLE);
                    mr.setVisibility(View.INVISIBLE);
                }
            }
        }) ;

        imageView.setOnClickListener(new ImageView.OnClickListener() {
            Global_Class status = (Global_Class) getApplicationContext();
            @Override
            public void onClick(View view) {
                if(ad.getVisibility()==View.INVISIBLE){
                    ad.setVisibility(View.VISIBLE);
                    dll.setVisibility(View.INVISIBLE);
                    mr.setVisibility(View.INVISIBLE);

                    Button buy1 =  findViewById(R.id.buy1);

                    buy1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(status.getCoin() >= 2) {
                                status.setBag(100);
                                status.setCoin(status.getCoin() - 2);
                                status.setLove(status.getLove() + 2);
                                Toast.makeText(NextActivityShop.this, "수룡이 헤어밴드 구매 완료!", Toast.LENGTH_SHORT).show();
                                status.setBag(101);
                                status.setAn(status.getAn()+1);
                            } else {
                                Toast.makeText(NextActivityShop.this, "코인이 부족합니다.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    );
                }else{
                    ad.setVisibility(View.INVISIBLE);
                }
            }
        });

        imageView2.setOnClickListener(new ImageView.OnClickListener() {
            Global_Class status = (Global_Class) getApplicationContext();
            @Override
            public void onClick(View view) {
                if(dll.getVisibility()==View.INVISIBLE){
                    ad.setVisibility(View.INVISIBLE);
                    dll.setVisibility(View.VISIBLE);
                    mr.setVisibility(View.INVISIBLE);

                    Button buy2 =  findViewById(R.id.buy2);

                    buy2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(status.getCoin() >= 4) {
                                Toast.makeText(NextActivityShop.this, "베이비 수룡 인형 구매 완료!", Toast.LENGTH_SHORT).show();
                                status.setBag(100);
                                status.setCoin(status.getCoin() - 4);
                                status.setBag(102);
                                status.setDoll(status.getDoll() + 1);
                                status.setLove(status.getLove() + 4);
                            } else {
                                Toast.makeText(NextActivityShop.this, "코인이 부족합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    dll.setVisibility(View.INVISIBLE);
                }
            }
        });

        imageView3.setOnClickListener(new ImageView.OnClickListener() {
            Global_Class status = (Global_Class) getApplicationContext();
            @Override
            public void onClick(View view) {
                if(mr.getVisibility()==View.INVISIBLE){
                    ad.setVisibility(View.INVISIBLE);
                    dll.setVisibility(View.INVISIBLE);
                    mr.setVisibility(View.VISIBLE);

                    Button buy3 =  findViewById(R.id.buy3);

                    buy3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(status.getCoin() >= 1) {
                                Toast.makeText(NextActivityShop.this, "수정구 거울 구매 완료!", Toast.LENGTH_SHORT).show();
                                status.setBag(100);
                                status.setCoin(status.getCoin() - 1);
                                status.setBag(103);
                                status.setMi(status.getMi() + 1);
                                status.setLove(status.getLove() + 1);
                            } else {
                                Toast.makeText(NextActivityShop.this, "코인이 부족합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    mr.setVisibility(View.INVISIBLE);
                }
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
        final Dialog dialog = new Dialog(NextActivityShop.this);
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