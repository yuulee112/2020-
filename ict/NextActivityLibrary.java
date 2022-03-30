package com.example.ict;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Random;

public class NextActivityLibrary extends AppCompatActivity {

    TextView text;
    Button bt1, bt2, bt3, bt4, bt5, bta1, btb1, btc1, bta, btb, btc, btd, bte;
    ImageView image;
    TableLayout table;

    @SuppressLint("StaticFieldLeak")
    public static Context lib_Context;
    public void start_lib(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        final Global_Class status = (Global_Class) getApplicationContext();

        lib_Context = this;
        status.kk = 6;
        status.intent_g = new Intent(NextActivityLibrary.this, Egg.class);

        text =  findViewById(R.id.textView15);

        bt1 =  findViewById(R.id.button26);  //시험 보기
        bt1.setVisibility(View.INVISIBLE);

        bt2 =  findViewById(R.id.button25);  //밤샘 공부 하기
        bt2.setVisibility(View.INVISIBLE);

        bt3 =  findViewById(R.id.button28);  //나가기
        bt3.setVisibility(View.INVISIBLE);

        bt4 =  findViewById(R.id.button29);  //분홍색 바탕
        bt4.setVisibility(View.INVISIBLE);

        bt5 =  findViewById(R.id.button33);  //문제 버튼
        bt5.setVisibility(View.INVISIBLE);

        bta1 =  findViewById(R.id.button35);  //틀렸다
        bta1.setVisibility(View.INVISIBLE);

        btb1 =  findViewById(R.id.button36);  //맞았다
        btb1.setVisibility(View.INVISIBLE);

        btc1 = findViewById(R.id.button37);  //다음 문제
        btc1.setVisibility(View.INVISIBLE);

        image =  findViewById(R.id.imageView19);  //가방

        table =  findViewById(R.id.table5);  //가방창
        table.setVisibility(View.INVISIBLE);

        bta =  findViewById(R.id.button142);  //칸 1
        btb =  findViewById(R.id.button143);  //칸 2
        btc =  findViewById(R.id.button144);  //칸 3
        btd =  findViewById(R.id.button145);  //칸 4
        bte =  findViewById(R.id.button146);  //칸 5

        text.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                if(i == 0){
                    text.setText("시험 볼래? 밤샘 공부 할래?");
                    bt1.setVisibility(View.VISIBLE);
                    bt2.setVisibility(View.VISIBLE);
                    bt3.setVisibility(View.VISIBLE);
                    i++;
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status.setExam();
                text.setText("시험 한 문제 맞출 때 마다 지식 지수가 1씩 올라! 그럼 화이팅!");

                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable()  {
                    public void run() {
                        bt5.setText("");
                        text.setVisibility(View.INVISIBLE);
                        bt4.setText("");
                        bt4.setBackgroundColor(Color.parseColor("#D1B2FF"));
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        btc1.setText("시험 시작");
                        btc1.setVisibility(View.VISIBLE);
                        bt3.setVisibility(View.INVISIBLE);
                    }
                }, 1500);
                btc1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btc1.setText("");
                        btc1.setVisibility(View.INVISIBLE);
                        status.setCount(0);
                        Random random = new Random();          //'맞았다'와 '틀렸다' 문제 중 고르기
                        status.setNum(random.nextInt(2));

                        bt5.setTextSize(30);
                        bt5.setText(status.getRandomTQuiz(status.getNum()));
                        bta1.setVisibility(View.VISIBLE);
                        btb1.setVisibility(View.VISIBLE);

                        bta1.setOnClickListener(new View.OnClickListener() {//'틀렸다' 버튼 누른경우
                            @Override
                            public void onClick(View view) {
                                if(status.getNum() == 1 && status.getCount() == 0) {
                                    bt5.setTextSize(40);
                                    bt5.setText("정답이야!");
                                    status.setKnow(status.getKnow()+1);
                                    status.setScore(status.getScore()+1);
                                    btc1.setText("다음 문제");
                                    btc1.setVisibility(View.VISIBLE);
                                }
                                else if(status.getNum() == 0 && status.getCount() == 0) {
                                    bt5.setTextSize(40);
                                    bt5.setText("오답이야!");
                                    btc1.setText("다음 문제");
                                    btc1.setVisibility(View.VISIBLE);
                                }
                                status.setCount(1);
                            }
                        });

                        btb1.setOnClickListener(new View.OnClickListener() {  //'맞았다' 버튼 누른경우
                            @Override
                            public void onClick(View view) {
                                if(status.getNum() == 0 && status.getCount() == 0) {
                                    bt5.setTextSize(40);
                                    bt5.setText("정답이야!");
                                    status.setKnow(status.getKnow()+1);
                                    status.setScore(status.getScore()+1);
                                    btc1.setText("다음 문제");
                                    btc1.setVisibility(View.VISIBLE);
                                }
                                else if(status.getNum() == 1 && status.getCount() == 0) {
                                    bt5.setTextSize(40);
                                    bt5.setText("오답이야!");
                                    btc1.setText("다음 문제");
                                    btc1.setVisibility(View.VISIBLE);
                                }
                                status.setCount(1);
                            }
                        });
                        if(status.sum == 10){
                            text.setVisibility(View.VISIBLE);
                            text.setText(getString(R.string.test, status.getScore()));
                            status.setScore(0);
                            bt4.setText("");
                            bt4.setBackgroundColor(Color.parseColor("#FFDCFF"));
                            bt4.setVisibility(View.INVISIBLE);
                            bt5.setVisibility(View.INVISIBLE);
                            bta1.setVisibility(View.INVISIBLE);
                            btb1.setVisibility(View.INVISIBLE);
                            bt3.setVisibility(View.VISIBLE);
                            status.sum = 0;
                            Handler mHandler = new Handler();
                            mHandler.postDelayed(new Runnable()  {
                                public void run() {
                                    text.setText("이제 뭐할까?");
                                }
                            }, 1500);
                        }
                        status.sum++;
                    }
                });
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("좋아! 열심히 공부하자! ");
                bt4.setText("밤샘 중~");
                bt4.setVisibility(View.VISIBLE);
                bt3.setVisibility(View.INVISIBLE);

                status.setHealth(status.getHealth()-1);

                Handler mHandler0 = new Handler();
                mHandler0.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.INVISIBLE);
                    }
                }, 300);

                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable()  {
                    public void run() {
                        bt4.setText(getString(R.string.info, status.getRandomBam()));
                        bt4.setTextSize(30);
                    }
                }, 3000);

                Handler mHandler2 = new Handler();
                mHandler2.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.VISIBLE);
                        text.setText("똑똑해진 느낌이다. \n (체력 지수 -1)");
                        bt4.setVisibility(View.INVISIBLE);
                    }
                }, 7000);

                Handler mHandler3 = new Handler();
                mHandler3.postDelayed(new Runnable()  {
                    public void run() {
                        text.setText("이제 뭐 할까? ");
                        bt3.setVisibility(View.VISIBLE);
                    }
                }, 7500);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
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
        final Dialog dialog = new Dialog(NextActivityLibrary.this);
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
                ActivityCompat.finishAffinity(NextActivityLibrary.this);
                System.exit(0);
            }
        });
    }
}