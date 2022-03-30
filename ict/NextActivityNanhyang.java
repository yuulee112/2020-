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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class NextActivityNanhyang extends AppCompatActivity {

    TextView text;
    Button back;  //분홍배경
    Button bte, btf, btg;
    Button f, f1, f2, f3;  //메뉴 4가지
    Button a,b,c,d,e;
    ImageView image;
    TableLayout table;
    Intent intent;

    @SuppressLint("StaticFieldLeak")
    public static Context nan_Context;

    public void start_nan(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nanhyang);

        final Global_Class status = (Global_Class) getApplicationContext();

        nan_Context = this;
        status.kk = 5;
        status.intent_g = new Intent(NextActivityNanhyang.this, Egg.class);

        text =  findViewById(R.id.textView16);

        back =  findViewById(R.id.button85);  //분홍배경
        back.setVisibility(View.INVISIBLE);

        btf =  findViewById(R.id.button53);  //다음->
        btf.setVisibility(View.VISIBLE);

        btg =  findViewById(R.id.button52);  //나가기
        btg.setVisibility(View.VISIBLE);

        bte =  findViewById(R.id.button70);  //학식 먹기
        bte.setVisibility(View.INVISIBLE);

        f =  findViewById(R.id.button81);  //오므라이스
        f.setVisibility(View.INVISIBLE);

        f1 =  findViewById(R.id.button82);  //날치알새우튀김
        f1.setVisibility(View.INVISIBLE);

        f2 =  findViewById(R.id.button83);  //강된장삼겹
        f2.setVisibility(View.INVISIBLE);

        f3 =  findViewById(R.id.button84);  //순두부찌개
        f3.setVisibility(View.INVISIBLE);

        image =  findViewById(R.id.imageView30);  //가방

        table =  findViewById(R.id.table10);  //가방창
        table.setVisibility(View.INVISIBLE);

        a =  findViewById(R.id.button185);  //칸 1
        b =  findViewById(R.id.button186);  //칸 2
        c =  findViewById(R.id.button187);  //칸 3
        d =  findViewById(R.id.button188);  //칸 4
        e =  findViewById(R.id.button189);  //칸 5

        intent = new Intent(getApplicationContext(), Map_SungShin.class); //지도화면으로 가게 수정하기!!!!

        btf.setOnClickListener(new View.OnClickListener() { //다음->
            int sum = 0;

            @Override
            public void onClick(View v) {
                sum++;
                if (sum == 1) text.setText(" 수정이들은 저렴한 가격으로 \n 든든한 식사를 할 수 있어.");
                else if (sum == 2) text.setText(" 학식 한번 먹어볼래?");
                else bte.setVisibility(View.VISIBLE);
            }
        });

        btg.setOnClickListener(new View.OnClickListener() {  //나가기
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        bte.setOnClickListener(new View.OnClickListener() {  //학식 먹기
            @Override
            public void onClick(View view) {
                bte.setVisibility(View.INVISIBLE);
                back.setVisibility(View.VISIBLE);
                btf.setVisibility(View.INVISIBLE);

                f.setVisibility(View.VISIBLE);
                f1.setVisibility(View.VISIBLE);
                f2.setVisibility(View.VISIBLE);
                f3.setVisibility(View.VISIBLE);
                text.setText("원하는 메뉴를 클릭해줘!");

                f.setOnClickListener(new View.OnClickListener() {  //오므라이스 클릭
                    int sum = 0;
                    @Override
                    public void onClick(View view) {
                        if(sum == 0){
                            text.setText("오므라이스는 1코인이야! \n 먹고 싶으면 한번 더 클릭해줘!");
                            sum++;
                        }
                        else if(sum == 1) {
                            if (status.getCoin() >= 1) {
                                text.setText("오므라이스를 골랐구나!");
                                status.setFull(status.getFull() + 1);
                                status.setCoin(status.getCoin() - 1);

                                Handler mHandler0 = new Handler();
                                mHandler0.postDelayed(new Runnable() {
                                    public void run() {
                                        text.setText("든든하고 맛있다! \n (배부름 지수 +1) \n (성신코인 -1");
                                    }
                                }, 2000);

                                Handler mHandler4 = new Handler();
                                mHandler4.postDelayed(new Runnable() {
                                    public void run() {
                                        f.setVisibility(View.INVISIBLE);
                                        f1.setVisibility(View.INVISIBLE);
                                        f2.setVisibility(View.INVISIBLE);
                                        f3.setVisibility(View.INVISIBLE);
                                        btf.setVisibility(View.VISIBLE);
                                        btg.setVisibility(View.VISIBLE);
                                        back.setVisibility(View.INVISIBLE);
                                        bte.setVisibility(View.VISIBLE);
                                        text.setText("이제 뭐 할까? ");
                                    }
                                }, 5000);
                            } else {
                                Toast.makeText(NextActivityNanhyang.this, "코인이 부족합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

                f1.setOnClickListener(new View.OnClickListener() {  //날치알새우 클릭
                    int sum = 0;
                    @Override
                    public void onClick(View view) {
                        if(sum == 0){
                            text.setText("알치알새우덮밥은 2코인이야! \n 먹고 싶으면 한번 더 클릭해줘!");
                            sum++;
                        }
                        else if(sum == 1) {
                            if (status.getCoin() >= 2) {
                                text.setText("날치알새우덮밥을 골랐구나!");
                                status.setFull(status.getFull() + 2);
                                status.setCoin(status.getCoin() - 2);

                                Handler mHandler1 = new Handler();
                                mHandler1.postDelayed(new Runnable() {
                                    public void run() {
                                        text.setText("새우튀김과 날치알이 조화롭다! \n (배부름 지수 +2) \n (성신코인 -2)");
                                    }
                                }, 2000);

                                Handler mHandler4 = new Handler();
                                mHandler4.postDelayed(new Runnable() {
                                    public void run() {
                                        f.setVisibility(View.INVISIBLE);
                                        f1.setVisibility(View.INVISIBLE);
                                        f2.setVisibility(View.INVISIBLE);
                                        f3.setVisibility(View.INVISIBLE);
                                        btf.setVisibility(View.VISIBLE);
                                        btg.setVisibility(View.VISIBLE);
                                        back.setVisibility(View.INVISIBLE);
                                        bte.setVisibility(View.VISIBLE);
                                        text.setText("이제 뭐 할까? ");
                                    }
                                }, 5000);
                            } else {
                                Toast.makeText(NextActivityNanhyang.this, "코인이 부족합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

                f2.setOnClickListener(new View.OnClickListener() {  //삼겹살된장 클릭
                    int sum = 0;
                    @Override
                    public void onClick(View view) {
                        if(sum == 0){
                            text.setText("강된장삼겹살비빔밥은 3코인이야! \n 먹고 싶으면 한번 더 클릭해줘!");
                            sum++;
                        }
                        else if(sum == 1) {

                            if (status.getCoin() >= 3) {
                                text.setText("강된장삼겹살비빔밥을 골랐구나!");
                                status.setFull(status.getFull() + 3);
                                status.setCoin(status.getCoin() - 3);

                                Handler mHandler2 = new Handler();
                                mHandler2.postDelayed(new Runnable() {
                                    public void run() {
                                        text.setText("완전 배부르고 든든하다!! \n (배부름 지수 +3) \n (성신코인 -3)");
                                    }
                                }, 2000);

                                Handler mHandler4 = new Handler();
                                mHandler4.postDelayed(new Runnable() {
                                    public void run() {
                                        f.setVisibility(View.INVISIBLE);
                                        f1.setVisibility(View.INVISIBLE);
                                        f2.setVisibility(View.INVISIBLE);
                                        f3.setVisibility(View.INVISIBLE);
                                        btf.setVisibility(View.VISIBLE);
                                        btg.setVisibility(View.VISIBLE);
                                        back.setVisibility(View.INVISIBLE);
                                        bte.setVisibility(View.VISIBLE);
                                        text.setText("이제 뭐 할까? ");
                                    }
                                }, 5000);
                            } else {
                                Toast.makeText(NextActivityNanhyang.this, "코인이 부족합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

                f3.setOnClickListener(new View.OnClickListener() {  //순두부찌개 클릭
                    int sum = 0;
                    @Override
                    public void onClick(View view) {
                        if(sum == 0){
                            text.setText("순두부찌개는 1코인이야! \n 먹고 싶으면 한번 더 클릭해줘!");
                            sum++;
                        }
                        else if(sum == 1) {

                            if (status.getCoin() >= 1) {
                                text.setText("순두부찌개를 골랐구나!");
                                status.setFull(status.getFull() + 1);
                                status.setCoin(status.getCoin() - 1);

                                Handler mHandler3 = new Handler();
                                mHandler3.postDelayed(new Runnable() {
                                    public void run() {
                                        text.setText("순두부가 말랑하고 맛있다! \n (배부름 지수 +1) \n (성신코인 -1)");
                                    }
                                }, 2000);

                                Handler mHandler4 = new Handler();
                                mHandler4.postDelayed(new Runnable() {
                                    public void run() {
                                        f.setVisibility(View.INVISIBLE);
                                        f1.setVisibility(View.INVISIBLE);
                                        f2.setVisibility(View.INVISIBLE);
                                        f3.setVisibility(View.INVISIBLE);
                                        btf.setVisibility(View.VISIBLE);
                                        btg.setVisibility(View.VISIBLE);
                                        back.setVisibility(View.INVISIBLE);
                                        bte.setVisibility(View.VISIBLE);
                                        text.setText("이제 뭐 할까? ");
                                    }
                                }, 5000);
                            } else {
                                Toast.makeText(NextActivityNanhyang.this, "코인이 부족합니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

        image.setOnClickListener(new View.OnClickListener() {
            Global_Class status = (Global_Class) getApplicationContext();

            @Override
            public void onClick(View view) {
                if (status.bag[0] == 100){
                    a.setBackgroundResource(R.drawable.coinbag);
                    a.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[1] == 100){
                    b.setBackgroundResource(R.drawable.coinbag);
                    b.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[2] == 100){
                    c.setBackgroundResource(R.drawable.coinbag);
                    c.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[3] == 100){
                    d.setBackgroundResource(R.drawable.coinbag);
                    d.setText(getString(R.string.blank, status.getCoin()));
                }
                else if (status.bag[4] == 100){
                    e.setBackgroundResource(R.drawable.coinbag);
                    e.setText(getString(R.string.blank, status.getCoin()));
                }
                if(status.bag[0] == 101){
                    a.setBackgroundResource(R.drawable.andaebag);
                    a.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[1] == 101){
                    b.setBackgroundResource(R.drawable.andaebag);
                    b.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[2] == 101){
                    c.setBackgroundResource(R.drawable.andaebag);
                    c.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[3] == 101){
                    d.setBackgroundResource(R.drawable.andaebag);
                    d.setText(getString(R.string.blank, status.getAn()));
                }
                else if(status.bag[4] == 101){
                    e.setBackgroundResource(R.drawable.andaebag);
                    e.setText(getString(R.string.blank, status.getAn()));
                }
                if(status.bag[0] == 102){
                    a.setBackgroundResource(R.drawable.dollbag);
                    a.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[1] == 102){
                    b.setBackgroundResource(R.drawable.dollbag);
                    b.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[2] == 102){
                    c.setBackgroundResource(R.drawable.dollbag);
                    c.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[3] == 102){
                    d.setBackgroundResource(R.drawable.dollbag);
                    d.setText(getString(R.string.blank, status.getDoll()));
                }
                else if(status.bag[4] == 102){
                    e.setBackgroundResource(R.drawable.dollbag);
                    e.setText(getString(R.string.blank, status.getDoll()));
                }
                if(status.bag[0] == 103){
                    a.setBackgroundResource(R.drawable.sujeongbag);
                    a.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[1] == 103){
                    b.setBackgroundResource(R.drawable.sujeongbag);
                    b.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[2] == 103){
                    c.setBackgroundResource(R.drawable.sujeongbag);
                    c.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[3] == 103){
                    d.setBackgroundResource(R.drawable.sujeongbag);
                    d.setText(getString(R.string.blank, status.getMi()));
                }
                else if(status.bag[4] == 103){
                    e.setBackgroundResource(R.drawable.sujeongbag);
                    e.setText(getString(R.string.blank, status.getMi()));
                }
                if(status.bag[0] == 104){
                    a.setBackgroundResource(R.drawable.biscuit);
                    a.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[1] == 104){
                    b.setBackgroundResource(R.drawable.biscuit);
                    b.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[2] == 104){
                    c.setBackgroundResource(R.drawable.biscuit);
                    c.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[3] == 104){
                    d.setBackgroundResource(R.drawable.biscuit);
                    d.setText(getString(R.string.blank, status.getBis()));
                }
                else if(status.bag[4] == 104){
                    e.setBackgroundResource(R.drawable.biscuit);
                    e.setText(getString(R.string.blank, status.getBis()));
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
        final Dialog dialog = new Dialog(NextActivityNanhyang.this);
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
                ActivityCompat.finishAffinity(NextActivityNanhyang.this);
                System.exit(0);
            }
        });
    }
}


