package com.example.ict;

import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class NextActivity extends AppCompatActivity {
    Button bt;
    SoundPool soundPool;	//작성
    int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next0);

        bt = findViewById(R.id.button9);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);	//작성
        soundID = soundPool.load(this,R.raw.clicksound,1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(soundID,1f,1f,0,0,1f);
                Intent intent = new Intent(getApplicationContext(), NextActivity0.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(NextActivity.this);
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
                ActivityCompat.finishAffinity(NextActivity.this);
                System.exit(0);
            }
        });
    }
}


