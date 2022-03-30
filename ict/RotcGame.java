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
import android.widget.TextView;
import java.util.Random;


public class RotcGame extends AppCompatActivity {
    Button start,memo;
    TextView result;
    int min = -3, max = 5;

    Random random3 = new Random();
    //int rotc_score = random3.nextInt(5);
    int rotc_score = random3.nextInt(max - min + 1) + min;

    @SuppressLint("StaticFieldLeak")
    public static Context rotc_Context;
    public void start_rotc(){
        Global_Class status = (Global_Class) getApplicationContext();
        startActivity(status.intent_g);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotc_game);

        final Global_Class status = (Global_Class) getApplicationContext();

        rotc_Context = this;
        status.kk = 3;
        status.intent_g = new Intent(RotcGame.this, Egg.class);

        result =  findViewById(R.id.textView30);
        result.setVisibility(View.INVISIBLE);

        start =  findViewById(R.id.button120);  //시작하기
        start.setVisibility(View.VISIBLE);

        memo =  findViewById(R.id.button109);  //쪽지
        memo.setVisibility(View.INVISIBLE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(View.INVISIBLE);
                memo.setVisibility(View.VISIBLE);

                if(rotc_score > 0){
                    Handler mHandler1 = new Handler();
                    mHandler1.postDelayed(new Runnable() {
                        public void run() {
                            memo.setText(getString(R.string.rotc_string, rotc_score));
                            status.setBag(100);
                            status.setCoin(status.getCoin()+rotc_score);
                        }
                    }, 1000);


                    Handler mHandler2 = new Handler();
                    mHandler2.postDelayed(new Runnable() {
                        public void run() {
                            result.setVisibility(View.VISIBLE);
                            result.setText("축하합니다! \n 코인 획득!");
                        }
                    }, 4000);

                    Handler mHandler3 = new Handler();
                    mHandler3.postDelayed(new Runnable() {
                        public void run() {
                            result.setText(getString(R.string.rotc_string, rotc_score));
                        }
                    }, 6000);
                }
                else if(rotc_score == 0){
                    Handler mHandler1 = new Handler();
                    mHandler1.postDelayed(new Runnable() {
                        public void run() {
                            memo.setText(getString(R.string.rotc_string, rotc_score));
                            status.setBag(100);
                            status.setCoin(status.getCoin()+rotc_score);
                        }
                    }, 1000);

                    Handler mHandler2 = new Handler();
                    mHandler2.postDelayed(new Runnable() {
                        public void run() {
                            result.setVisibility(View.VISIBLE);
                            result.setText("얻은 줄 알았지만... \n 빵개!");
                        }
                    }, 4000);
                    Handler mHandler3 = new Handler();
                    mHandler3.postDelayed(new Runnable() {
                        public void run() {
                            result.setText(getString(R.string.rotc_string, rotc_score));
                        }
                    }, 6000);

                }
                else {
                    Handler mHandler1 = new Handler();
                    mHandler1.postDelayed(new Runnable() {
                        public void run() {
                            memo.setText(getString(R.string.rotc_string2, rotc_score));
                            status.setBag(100);
                            status.setCoin(status.getCoin()+rotc_score);
                        }
                    }, 1000);

                    Handler mHandler2 = new Handler();
                    mHandler2.postDelayed(new Runnable() {
                        public void run() {
                            result.setVisibility(View.VISIBLE);
                            result.setText("안타까워요.. \n 코인 차감");
                        }
                    }, 4000);
                    Handler mHandler3 = new Handler();
                    mHandler3.postDelayed(new Runnable() {
                        public void run() {
                            result.setText(getString(R.string.rotc_string2, rotc_score));
                        }
                    }, 6000);
                }

                Handler mHandler6 = new Handler();
                mHandler6.postDelayed(new Runnable() {
                    public void run() {
                        result.setText("지도로 이동합니다!");
                        Intent intent = new Intent(getApplicationContext(), Map_SungShin.class);
                        startActivity(intent);
                    }
                }, 8000);
            }
        });
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(RotcGame.this);
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
                ActivityCompat.finishAffinity(RotcGame.this);
                System.exit(0);
            }
        });
    }
}
