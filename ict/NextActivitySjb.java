package com.example.ict;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class NextActivitySjb extends AppCompatActivity {

    TextView text;  //말풍선
    Button btl, bts, btg, bto, btf, bta, btb, btc, btd, bte;
    ImageView image;
    TableLayout table;

    @SuppressLint("StaticFieldLeak")
    public static Context sjb_Context;

    public void start_sjb(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjb);

        final Global_Class status = (Global_Class) getApplicationContext();

        sjb_Context = this;
        status.kk = 2;
        status.intent_g = new Intent(NextActivitySjb.this, Egg.class);

        text =  findViewById(R.id.textView18);
        if(status.shop_count == 0) {
            text.setText("수정관에 도착했어. \n정말 멋진 건물이지?");
        }
        else {
            text.setText("굿즈 정말 귀여웠어~");
            status.shop_count = 0;
        }
        btl =  findViewById(R.id.button88);  //글로벌 라운지
        btl.setVisibility(View.INVISIBLE);

        bts =  findViewById(R.id.button89);  //수면실
        bts.setVisibility(View.INVISIBLE);

        btg =  findViewById(R.id.button90);  //굿즈샵
        btg.setVisibility(View.INVISIBLE);

        btf =  findViewById(R.id.button95);  //분홍색 바탕
        btf.setVisibility(View.INVISIBLE);

        bto =  findViewById(R.id.button93);  //나가기
        bto.setVisibility(View.INVISIBLE);

        image =  findViewById(R.id.imageView18);  //가방

        table =  findViewById(R.id.table4);  //가방창
        table.setVisibility(View.INVISIBLE);

        bta =  findViewById(R.id.button135);  //칸 1
        btb =  findViewById(R.id.button136);  //칸 2
        btc =  findViewById(R.id.button137);  //칸 3
        btd =  findViewById(R.id.button138);  //칸 4
        bte =  findViewById(R.id.button139);  //칸 5

        text.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                if(i == 0){
                    text.setText("어디 갈래?");
                    bto.setVisibility(View.VISIBLE);
                    btl.setVisibility(View.VISIBLE);
                    bts.setVisibility(View.VISIBLE);
                    btg.setVisibility(View.VISIBLE);
                    i++;
                }
            }
        });

        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btl.setVisibility(View.INVISIBLE);
                bts.setVisibility(View.INVISIBLE);
                btg.setVisibility(View.INVISIBLE);

                text.setText("내 유창한 영어실력을 보여줄께! ");
                btf.setText("영어 회화 중~");
                btf.setVisibility(View.VISIBLE);
                bto.setVisibility(View.INVISIBLE);

                status.setWord(status.getWord()+1);
                status.setHealth(status.getHealth()-1);

                Handler mHandler0 = new Handler();
                mHandler0.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.INVISIBLE);
                    }
                }, 1000);

                Handler mHandler = new Handler();
                mHandler.postDelayed(new Runnable()  {
                    public void run() {
                        btf.setText(getString(R.string.blanks, status.getRandomEng()));
                        btf.setTextSize(30);
                    }
                }, 3000);

                Handler mHandler2 = new Handler();
                mHandler2.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.VISIBLE);
                        text.setText("유창해진 느낌이다. \n (어학 지수 +1, 체력 지수 -1)");
                        btf.setVisibility(View.INVISIBLE);
                    }
                }, 8000);

                Handler mHandler3 = new Handler();
                mHandler3.postDelayed(new Runnable()  {
                    public void run() {
                        text.setText("이제 뭐 할까?");
                        bto.setVisibility(View.VISIBLE);
                        btl.setVisibility(View.VISIBLE);
                        bts.setVisibility(View.VISIBLE);
                        btg.setVisibility(View.VISIBLE);
                    }
                }, 10000);
            }
        });

        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btl.setVisibility(View.INVISIBLE);
                bts.setVisibility(View.INVISIBLE);
                btg.setVisibility(View.INVISIBLE);
                text.setText("잠이 온다... 조금만 자고 일어나자...");
                btf.setText("수면 중~");
                btf.setVisibility(View.VISIBLE);
                bto.setVisibility(View.INVISIBLE);

                status.setHealth(status.getHealth()-1);
                status.setSleep();

                Handler mHandler0 = new Handler();
                mHandler0.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.INVISIBLE);
                    }
                }, 1000);

                Handler mHandler2 = new Handler();
                mHandler2.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.VISIBLE);
                        text.setText("몸이 가뿐하고 정신이 맑아진거 같다.(체력 지수 +1)");
                        btf.setVisibility(View.INVISIBLE);
                    }
                }, 5000);

                Handler mHandler3 = new Handler();
                mHandler3.postDelayed(new Runnable()  {
                    public void run() {
                        text.setText("이제 뭐 할까? ");
                        bto.setVisibility(View.VISIBLE);
                        btl.setVisibility(View.VISIBLE);
                        bts.setVisibility(View.VISIBLE);
                        btg.setVisibility(View.VISIBLE);
                    }
                }, 6500);
            }
        });

        btg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btl.setVisibility(View.INVISIBLE);
                bts.setVisibility(View.INVISIBLE);
                btg.setVisibility(View.INVISIBLE);
                text.setText("난초방에 있는 귀여운 굿즈들을 보러가자! ");

                Handler mHandler0 = new Handler();
                mHandler0.postDelayed(new Runnable()  {
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), NextActivityShop.class);
                        startActivity(intent);
                    }
                }, 1000);

            }
        });

        bto.setOnClickListener(new View.OnClickListener() {
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
        final Dialog dialog = new Dialog(NextActivitySjb.this);
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
                ActivityCompat.finishAffinity(NextActivitySjb.this);
                System.exit(0);
            }
        });
    }
}
