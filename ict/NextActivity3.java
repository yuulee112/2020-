package com.example.ict;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class NextActivity3 extends AppCompatActivity {

    TextView text;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next3);

        Button button = findViewById(R.id.button60);
        text = findViewById(R.id.textView32);
        intent = new Intent(this, NextActivity4.class);

        button.setOnClickListener(new View.OnClickListener() {
            int sum = 0;
            @Override
            public void onClick(View view) {
                sum++;
                if (sum == 1) text.setText("학교를 탐험하며 \n 나를 수룡이로 키워줘!");
                else if (sum == 2) text.setText("학교에서 얻은 점수에 따라 \n 내 미래모습이 바뀌어!");
                else if (sum == 3) text.setText("행운을 빌어!");
                else startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(NextActivity3.this);
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
                ActivityCompat.finishAffinity(NextActivity3.this);
                System.exit(0);
            }
        });
    }
}

