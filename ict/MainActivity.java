package com.example.ict;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    SoundPool soundPool;
    int soundID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ToggleButton PanBtn = findViewById(R.id.button);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);    //작성
        soundID = soundPool.load(this, R.raw.clicksound, 1);

        PanBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                Global_Class status = (Global_Class) getApplicationContext();
                if (PanBtn.isChecked()) {
                    soundPool.play(soundID, 1f, 1f, 0, 0, 1f);
                    PanBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.startbuttonoff));
                    Intent intent = new Intent(getApplicationContext(), NextActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                } else {
                    PanBtn.setBackgroundDrawable(getResources().getDrawable(R.drawable.startbutton));
                }
                status.reset_all();
            }
        });
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        final Dialog dialog = new Dialog(MainActivity.this);
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
                ActivityCompat.finishAffinity(MainActivity.this);
                System.exit(0);
            }
        });
    }
}
