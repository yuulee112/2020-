package com.example.ict;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class EndingSleep extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending_sleep);

        Button next = findViewById(R.id.button104);
        intent = new Intent(getApplicationContext(), GameOver.class);

        next.setOnClickListener(new View.OnClickListener() {  //다음
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(EndingSleep.this);
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
                ActivityCompat.finishAffinity(EndingSleep.this);
                System.exit(0);
            }
        });
    }
}