package com.example.ict;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class NextActivity4 extends AppCompatActivity {

    TextView text;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, btc, btaa, btbb, btcc, btdd, btee;
    ImageView image, image2, image3;
    TableLayout table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next4);

        text = findViewById(R.id.textView);

        bt1 =  findViewById(R.id.button7);  //성신관
        bt1.setVisibility(View.INVISIBLE);

        bt2 =  findViewById(R.id.button8);  //수정관
        bt2.setVisibility(View.INVISIBLE);

        bt3 =  findViewById(R.id.button10);  //중앙도서관
        bt3.setVisibility(View.INVISIBLE);

        bt4 =  findViewById(R.id.button11);  //난향관
        bt4.setVisibility(View.INVISIBLE);

        bt5 =  findViewById(R.id.button12);  //조형관
        bt5.setVisibility(View.INVISIBLE);

        bt6 =  findViewById(R.id.button14);  //미술관
        bt6.setVisibility(View.INVISIBLE);

        bt7 =  findViewById(R.id.button15);  //체육관
        bt7.setVisibility(View.INVISIBLE);

        btc =  findViewById(R.id.button23);  //다음 장소
        btc.setVisibility(View.INVISIBLE);

        image =  findViewById(R.id.imageView9);  // 포러스 수룡이

        image2 =  findViewById(R.id.imageView22);  // 느낌표
        image2.setVisibility(View.INVISIBLE);

        image3 =  findViewById(R.id.imageView23);  //가방
        image3.setVisibility(View.INVISIBLE);

        table =  findViewById(R.id.table8);  //가방창
        table.setVisibility(View.INVISIBLE);

        btaa =  findViewById(R.id.button163);  //칸 1
        btbb =  findViewById(R.id.button164);  //칸 2
        btcc =  findViewById(R.id.button165);  //칸 3
        btdd =  findViewById(R.id.button166);  //칸 4
        btee =  findViewById(R.id.button167);  //칸 5

        text.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            @Override
            public void onClick(View v) {
                if(i == 0) {
                    image.setBackgroundResource(R.drawable.forusone);
                    text.setText("\n자주 다니는 건물은 이렇게 있어");
                    bt1.setVisibility(View.VISIBLE);
                    bt2.setVisibility(View.VISIBLE);
                    bt3.setVisibility(View.VISIBLE);
                    bt4.setVisibility(View.VISIBLE);
                    bt5.setVisibility(View.VISIBLE);
                    bt6.setVisibility(View.VISIBLE);
                    bt7.setVisibility(View.VISIBLE);
                    btc.setVisibility(View.VISIBLE);
                    i++;
                }
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText("수정관에는 모든 편의시설이 있어 \n 카페, 식당, 복사실, 도서관, 강의실, 수면실 등 없는게 없어");
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText("성신관은 학생지원팀, 행정사무실 등 행정 업무를 처리하는 곳과 도서관, 강의실이 있어.");
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText("중앙도서관은 쾌적한 환경에서 독서와 공부를 할 수 있는 정말 좋은 도서관이야!");
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText("난향관에는 맛있는 학식을 먹을 수 있는 식당과 휴식할 수 있는 공간이 있어. 이 곳에서 강의도 진행 돼.");
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText("조형관은 미대 수업과 실습이 이뤄지는 곳이야. \n조형1,2관으로 나눠져 있어.");
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText("음악관은 음대 학생들의 수업과 실습이 이뤄지는 곳이야. ");
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                text.setText("체육관은 수정이들이 운동을 하고 체력을 기르는 곳이야.");
            }
        });


        btc.setOnClickListener(new View.OnClickListener() {
            int i = 0;
            Global_Class status = (Global_Class) getApplicationContext();
            @Override
            public void onClick(View v) {
                if(i == 0) {
                    image.setBackgroundResource(R.drawable.forus);
                    bt1.setVisibility(View.INVISIBLE);
                    bt2.setVisibility(View.INVISIBLE);
                    bt3.setVisibility(View.INVISIBLE);
                    bt4.setVisibility(View.INVISIBLE);
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    btc.setVisibility(View.INVISIBLE);
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wave);
                    image2.startAnimation(anim);
                    image2.setVisibility(View.VISIBLE);
                    text.setText("잠깐만!! 기다려봐!");
                    i++;
                    btc.setVisibility(View.INVISIBLE);
                }
                else if(i == 1) {
                    status.time_start.start();
                    Intent intent = new Intent(getApplicationContext(), Map_SungShin.class);
                    startActivity(intent);
                }
            }
        });


        image2.setOnClickListener(new View.OnClickListener() {
            int i = 0;

            @Override
            public void onClick(View view) {
                if(i == 0) {
                    text.setText("(가방을 받으라는 듯이 준다. 가방을 클릭해 보자)");
                    image2.setImageResource(R.drawable.inven);
                    i++;
                }
                else if(i == 1){
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha);
                    image2.startAnimation(anim);
                    Handler m31Handler3 = new Handler();
                    m31Handler3.postDelayed(new Runnable()  {
                        public void run() {
                            image2.setVisibility(View.INVISIBLE);
                            image3.setVisibility(View.VISIBLE);
                            text.setText("입학 선물이야! 오른쪽위에 가방을 클릭해서 열고닫을 수 있어");
                        }
                    }, 1000);

                    Handler m21Handler3 = new Handler();
                    m21Handler3.postDelayed(new Runnable()  {
                        public void run() {
                            text.setText("그럼 유용히 쓰길바래!");
                        }
                    }, 3000);

                    Handler m30Handler3 = new Handler();
                    m30Handler3.postDelayed(new Runnable()  {
                        @SuppressLint("SetTextI18n")
                        public void run() {
                            text.setText("아차, 탐방시간은 400초야!");
                            btc.setVisibility(View.VISIBLE);
                            btc.setText("언덕 올라가기");
                        }
                    }, 4000);
                }
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            Global_Class status = (Global_Class) getApplicationContext();
            @Override
            public void onClick(View view) {
                if (status.bag[0] == 100){
                    btaa.setBackgroundResource(R.drawable.coinbag);
                    btaa.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[1] == 100){
                    btbb.setBackgroundResource(R.drawable.coinbag);
                    btbb.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[2] == 100){
                    btcc.setBackgroundResource(R.drawable.coinbag);
                    btcc.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[3] == 100){
                    btdd.setBackgroundResource(R.drawable.coinbag);
                    btdd.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[4] == 100){
                    btee.setBackgroundResource(R.drawable.coinbag);
                    btee.setText(getString(R.string.blank, status.getCoin()));
                }
                if(status.bag[0] == 101){
                    btaa.setBackgroundResource(R.drawable.andaebag);
                    btaa.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[1] == 101){
                    btbb.setBackgroundResource(R.drawable.andaebag);
                    btbb.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[2] == 101){
                    btcc.setBackgroundResource(R.drawable.andaebag);
                    btcc.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[3] == 101){
                    btdd.setBackgroundResource(R.drawable.andaebag);
                    btdd.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[4] == 101){
                    btee.setBackgroundResource(R.drawable.andaebag);
                    btee.setText(getString(R.string.blank, status.getAn()));
                }
                if(status.bag[0] == 102){
                    btaa.setBackgroundResource(R.drawable.dollbag);
                    btaa.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[1] == 102){
                    btbb.setBackgroundResource(R.drawable.dollbag);
                    btbb.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[2] == 102){
                    btcc.setBackgroundResource(R.drawable.dollbag);
                    btcc.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[3] == 102){
                    btdd.setBackgroundResource(R.drawable.dollbag);
                    btdd.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[4] == 102){
                    btee.setBackgroundResource(R.drawable.dollbag);
                    btee.setText(getString(R.string.blank, status.getDoll()));
                }
                if(status.bag[0] == 103){
                    btaa.setBackgroundResource(R.drawable.sujeongbag);
                    btaa.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[1] == 103){
                    btbb.setBackgroundResource(R.drawable.sujeongbag);
                    btbb.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[2] == 103){
                    btcc.setBackgroundResource(R.drawable.sujeongbag);
                    btcc.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[3] == 103){
                    btdd.setBackgroundResource(R.drawable.sujeongbag);
                    btdd.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[4] == 103){
                    btee.setBackgroundResource(R.drawable.sujeongbag);
                    btee.setText(getString(R.string.blank, status.getMi()));
                }
                if(status.bag[0] == 104){
                    btaa.setBackgroundResource(R.drawable.biscuit);
                    btaa.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[1] == 104){
                    btbb.setBackgroundResource(R.drawable.biscuit);
                    btbb.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[2] == 104){
                    btcc.setBackgroundResource(R.drawable.biscuit);
                    btcc.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[3] == 104){
                    btdd.setBackgroundResource(R.drawable.biscuit);
                    btdd.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[4] == 104){
                    btee.setBackgroundResource(R.drawable.biscuit);
                    btee.setText(getString(R.string.blank, status.getBis()));
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
        final Dialog dialog = new Dialog(NextActivity4.this);
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
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(NextActivity4.this);
                System.exit(0);
            }
        });
    }
}