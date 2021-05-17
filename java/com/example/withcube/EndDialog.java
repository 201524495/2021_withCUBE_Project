package com.example.withcube;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import static com.example.withcube.mainMenu.mediaPlayer;


public class EndDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private Button sound_cancel, sound_ok;
    Switch sw_bgm, sw_click;
    public static boolean bgmONOFF = true , clickONOFF = true ; // 이전 상태
    public static boolean[] checkedItems = {true, true}; // 현재 상태 // bgm, click
    public EndDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        sound_cancel =  findViewById(R.id.sound_cancel);
        sound_ok = findViewById(R.id.sound_ok);
        sw_bgm = findViewById(R.id.sw_bgm);
        sw_click = findViewById(R.id.sw_click);

        sw_bgm.setTextOff("OFF");
        sw_bgm.setTextOn("ON");
        sw_click.setTextOff("OFF");
        sw_click.setTextOn("ON");
        sw_bgm.setChecked(checkedItems[0]); //
        sw_click.setChecked(checkedItems[1]); //

        sound_cancel.setOnClickListener(this);
        sound_ok.setOnClickListener(this);
        sw_bgm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkedItems[0] = isChecked;
            }
        });
        sw_click.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkedItems[1] = isChecked;
            }
        });
        Log.d("OK","bgm : "+bgmONOFF + " click : "+clickONOFF);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sound_cancel: // 취소
                checkedItems[0] = bgmONOFF;
                checkedItems[1] = clickONOFF;
                Log.d("OK","bgm : "+bgmONOFF + " click : "+clickONOFF);
                cancel();
                break;

            case R.id.sound_ok: // 확인
                bgmONOFF = checkedItems[0];
                clickONOFF = checkedItems[1];
                sw_bgm.setChecked(bgmONOFF);
                sw_click.setChecked(clickONOFF);
                BackgroundSound(checkedItems[0]);
                ClickSound(checkedItems[1]);
                Log.d("OK","bgm : "+bgmONOFF + " click : "+clickONOFF);
                dismiss();
                break;
        }
    }
    public void BackgroundSound(boolean bgmONOFF) {
        if(!bgmONOFF) { // 켜져 있으면 끈다.
            mediaPlayer.pause(); // 중지 == bgmONOFF == true
            Log.e("bgm","bgm off " + bgmONOFF);
        }
        else { // 꺼져있으면 켠다.
            mediaPlayer.setLooping(true);
            mediaPlayer.start(); // 시작 == bgmONOFF == flase
            Log.e("bgm","bgm on" + bgmONOFF);
        }
    }
//
    public void ClickSound(boolean clickONOFF) {
        AudioManager amanager=(AudioManager)this.getContext().getSystemService(Context.AUDIO_SERVICE);
        if(!clickONOFF) {
//            btn_array.setSoundEffectsEnabled(false);
//            btn_building.setSoundEffectsEnabled(false);
//            btn_sound.setSoundEffectsEnabled(false);
            amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
            Log.e("click","click off " + clickONOFF);
        }
        else {
//            btn_array.setSoundEffectsEnabled(true);
//            btn_building.setSoundEffectsEnabled(true);
//            btn_sound.setSoundEffectsEnabled(true);
            amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
            Log.e("click","click on " + clickONOFF);
        }
    }
}

