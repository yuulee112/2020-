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

import java.util.Random;

public class NextActivityHill extends AppCompatActivity {

    TextView text;
    ImageView image, image1, image2, image3, imagea, imageb, imagec, imaged, imagee;
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bta, btb, btc, btd, bte;
    TableLayout table;

    @SuppressLint("StaticFieldLeak")
    public static Context hill_Context;
    public void start_hill(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hill);

        final Global_Class status = (Global_Class) getApplicationContext();

        hill_Context = this;
        status.kk = 8;
        status.intent_g = new Intent(NextActivityHill.this, Egg.class);

        text =  findViewById(R.id.textView20);

        bt1 =  findViewById(R.id.button98);  //대자보 보기
        bt1.setVisibility(View.INVISIBLE);

        bt2 =  findViewById(R.id.button101);  //나가기
        bt2.setVisibility(View.INVISIBLE);

        bt3 =  findViewById(R.id.button71);  //대자보 내용
        bt3.setVisibility(View.INVISIBLE);

        image1 =  findViewById(R.id.imageView7);  //대자보 닫기
        image1.setVisibility(View.INVISIBLE);

        image2 =  findViewById(R.id.imageView8);  //회색바닥
        image2.setVisibility(View.INVISIBLE);

        imagea =  findViewById(R.id.imageView10);  //고양이1
        imagea.setVisibility(View.INVISIBLE);

        imageb =  findViewById(R.id.imageView11);  //고양이2
        imageb.setVisibility(View.INVISIBLE);

        imagec =  findViewById(R.id.imageView12);  //고양이3
        imagec.setVisibility(View.INVISIBLE);

        imaged =  findViewById(R.id.imageView13);  //고양이4
        imaged.setVisibility(View.INVISIBLE);

        imagee =  findViewById(R.id.imageView14);  //고양이5
        imagee.setVisibility(View.INVISIBLE);

        image3 =  findViewById(R.id.imageView15);  //선택한 고양이
        image3.setVisibility(View.INVISIBLE);

        bt4 =  findViewById(R.id.button102);  //진한 보라색
        bt4.setVisibility(View.INVISIBLE);

        bt5 =  findViewById(R.id.button103);  //고등어 버튼
        bt5.setVisibility(View.INVISIBLE);

        bt6 =  findViewById(R.id.button104);  //민현이 버튼
        bt6.setVisibility(View.INVISIBLE);

        bt7 =  findViewById(R.id.button105);  //삼색이 버튼
        bt7.setVisibility(View.INVISIBLE);

        bt8 =  findViewById(R.id.button108);  //다시 돌아가기
        bt8.setVisibility(View.INVISIBLE);

        bt9 =  findViewById(R.id.button110);  //검은색 박스
        bt9.setVisibility(View.INVISIBLE);

        image =  findViewById(R.id.imageView20);  //가방

        table =  findViewById(R.id.table6);  //가방창
        table.setVisibility(View.INVISIBLE);

        bta =  findViewById(R.id.button149);  //칸 1
        btb =  findViewById(R.id.button150);  //칸 2
        btc =  findViewById(R.id.button151);  //칸 3
        btd =  findViewById(R.id.button152);  //칸 4
        bte =  findViewById(R.id.button153);  //칸 5

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("학교 소식을 볼래?");
                bt1.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.VISIBLE);
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setVisibility(View.INVISIBLE);
                bt1.setVisibility(View.INVISIBLE);
                bt2.setVisibility(View.INVISIBLE);
                bt3.setText(getString(R.string.tip, status.getRandomTip()));
                bt3.setVisibility(View.VISIBLE);
                image1.setVisibility(View.VISIBLE);
            }
        });

        image1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bt1.setVisibility(View.VISIBLE);
                bt3.setVisibility(View.INVISIBLE);
                image1.setVisibility(View.INVISIBLE);
                text.setVisibility(View.VISIBLE);
                bt2.setVisibility(View.VISIBLE);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler m1Handler3 = new Handler();
                m1Handler3.postDelayed(new Runnable()  {
                    public void run() {
                        text.setText("어디선가 울음소리가 들려 돌아봤더니 고양이의 그림자가 보인다.");
                        bt2.setVisibility(View.INVISIBLE);
                    }
                }, 1000);

                Handler m2Handler3 = new Handler();
                m2Handler3.postDelayed(new Runnable()  {
                    public void run() {
                        text.setVisibility(View.INVISIBLE);
                        bt9.setVisibility(View.VISIBLE);
                        image2.setVisibility(View.VISIBLE);
                        imagea.setVisibility(View.VISIBLE);
                        imageb.setVisibility(View.VISIBLE);
                        imagec.setVisibility(View.VISIBLE);
                        imaged.setVisibility(View.VISIBLE);
                        imagee.setVisibility(View.VISIBLE);
                        image.setVisibility(View.INVISIBLE);
                        table.setVisibility(View.INVISIBLE);
                    }
                }, 2000);

                Handler m31Handler3 = new Handler();
                m31Handler3.postDelayed(new Runnable()  {
                    public void run() {
                        bt9.setVisibility(View.INVISIBLE);
                    }
                }, 3000);
            }
        });

        imagea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                status.setNum(random.nextInt(5));
                switch (status.getNum()){
                    case 0:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catmin);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catgo);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catsum);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    default:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.windy);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setVisibility(View.VISIBLE);
                        bt4.setText("아무도 없다.");
                        bt8.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        imageb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                status.setNum(random.nextInt(5));
                switch (status.getNum()){
                    case 0:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catmin);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catgo);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catsum);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    default:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.windy);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("아무도 없다.");
                        bt4.setVisibility(View.VISIBLE);
                        bt8.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        imagec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                status.setNum(random.nextInt(5));
                switch (status.getNum()){
                    case 0:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catmin);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catgo);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catsum);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    default:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.windy);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("아무도 없다.");
                        bt4.setVisibility(View.VISIBLE);
                        bt8.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        imaged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                status.setNum(random.nextInt(5));
                switch (status.getNum()){
                    case 0:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catmin);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catgo);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catsum);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    default:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.windy);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("아무도 없다.");
                        bt4.setVisibility(View.VISIBLE);
                        bt8.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        imagee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                status.setNum(random.nextInt(5));
                switch (status.getNum()){
                    case 0:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catmin);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catgo);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.catsum);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("다음 중 위에 고양이의 이름은?");
                        bt4.setVisibility(View.VISIBLE);
                        bt5.setVisibility(View.VISIBLE);
                        bt6.setVisibility(View.VISIBLE);
                        bt7.setVisibility(View.VISIBLE);
                        break;
                    default:
                        imagea.setVisibility(View.INVISIBLE);
                        imageb.setVisibility(View.INVISIBLE);
                        imagec.setVisibility(View.INVISIBLE);
                        imaged.setVisibility(View.INVISIBLE);
                        imagee.setVisibility(View.INVISIBLE);
                        image3.setImageResource(R.drawable.windy);
                        image3.setVisibility(View.VISIBLE);
                        bt4.setText("아무도 없다.");
                        bt4.setVisibility(View.VISIBLE);
                        bt8.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status.getNum() == 0){
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    bt8.setText("틀렸다. 다시 돌아가자.");
                    bt8.setVisibility(View.VISIBLE);
                }
                else if(status.getNum() == 1){
                    Random random = new Random();
                    int num = random.nextInt(5);
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    if(num <= 2) {
                        status.setBag(100);
                        status.setCoin(status.getCoin() + ++num);
                        bt8.setText(getString(R.string.coin, num));
                    }
                    else{
                        status.setBag(104);
                        status.setBis(status.getBis() + ++num);
                        bt8.setText(getString(R.string.bis, num));
                    }
                    bt8.setVisibility(View.VISIBLE);
                }
                else if(status.getNum() == 2){
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    bt8.setText("틀렸다. 다시 돌아가자.");
                    bt8.setVisibility(View.VISIBLE);
                }
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status.getNum() == 0){
                    Random random = new Random();
                    int num = random.nextInt(5);
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    if(num <= 2) {
                        status.setBag(100);
                        status.setCoin(status.getCoin() + ++num);
                        bt8.setText(getString(R.string.coin, num));
                    }
                    else{
                        status.setBag(104);
                        status.setBis(status.getBis() + ++num);
                        bt8.setText(getString(R.string.bis, num));
                    }
                    bt8.setVisibility(View.VISIBLE);
                }
                else if(status.getNum() == 1){
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    bt8.setText("틀렸다. 다시 돌아가자.");
                    bt8.setVisibility(View.VISIBLE);
                }
                else if(status.getNum() == 2){
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    bt8.setText("틀렸다. 다시 돌아가자.");
                    bt8.setVisibility(View.VISIBLE);
                }
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(status.getNum() == 0){
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    bt8.setText("틀렸다. 다시 돌아가자.");
                    bt8.setVisibility(View.VISIBLE);
                }
                else if(status.getNum() == 1){
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    bt8.setText("틀렸다. 다시 돌아가자.");
                    bt8.setVisibility(View.VISIBLE);
                }
                else if(status.getNum() == 2){
                    Random random = new Random();
                    int num = random.nextInt(5);
                    bt5.setVisibility(View.INVISIBLE);
                    bt6.setVisibility(View.INVISIBLE);
                    bt7.setVisibility(View.INVISIBLE);
                    if(num <= 2) {
                        status.setBag(100);
                        status.setCoin(status.getCoin() + ++num);
                        bt8.setText(getString(R.string.coin, num));
                    }
                    else{
                        status.setBag(104);
                        status.setBis(status.getBis() + ++num);
                        bt8.setText(getString(R.string.bis, num));
                    }
                    bt8.setVisibility(View.VISIBLE);
                }
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
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
        final Dialog dialog = new Dialog(NextActivityHill.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_activity);
        dialog.show();
        Button button5 = dialog.findViewById(R.id.backbtn);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button button6 = dialog.findViewById(R.id.exitbtn);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.finishAffinity(NextActivityHill.this);
                System.exit(0);
            }
        });
    }
}
