package com.example.withcube;
// 메인 매뉴
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import static com.example.withcube.EndDialog.bgmONOFF;

public class mainMenu extends AppCompatActivity {

    Button btn_building, btn_array;
    ImageButton btn_sound;
    public static MediaPlayer mediaPlayer;

    private EndDialog mEndDialog;

    String[] items = {"배경 음악", "버튼 소리"};


    final int[] selectIndex = {0};
    public static AudioManager audio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(mainMenu.this, R.raw.b_06); // 음악 샘플 추가
        mediaPlayer.start(); // 일단 시작

        btn_sound = findViewById(R.id.btn_sound); // dialog box button
        btn_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // setup the alert builder
//                AlertDialog.Builder builder = new AlertDialog.Builder(mainMenu.this);
               mEndDialog = new EndDialog(mainMenu.this);
               mEndDialog.setCancelable(false); // 외부 화면 클릭해도 창이 닫히지 않는다.
               mEndDialog.show();
//                builder.setTitle("환경 설정");
////                 add a checkbox list
//                builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        // user checked or unchecked a box
//                       if(which == 0) {
//                           checkedItems[0] = isChecked;
//                       }
//                       if(which == 1) {
//                           checkedItems[1] = isChecked;
//                       }
//                    }
//                });
//
//                // add OK and Cancel buttons
//                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        bgmONOFF = checkedItems[0];
//                        clickONOFF = checkedItems[1];
//                        Log.e("OK","bgm : "+bgmONOFF+" click : "+clickONOFF);
//                        BackgroundSound(checkedItems[0]);
//                        ClickSound(checkedItems[1]);
//
//                    }
//                });
//                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        checkedItems[0] = bgmONOFF;
//                        checkedItems[1] = clickONOFF;
//                        Log.e("Cancel","bgm : "+bgmONOFF+" click : "+clickONOFF);
//
//                    }
//                });
//                builder.setCancelable(false); // 외부 화면 클릭해도 창이 닫히지 않는다.
//                // create and show the alert dialog
//                AlertDialog dialog = builder.create();
//                dialog.show();
            }
        });


        // 쌓기 놀이 클릭 했을 때
        btn_building = findViewById(R.id.btn_buildingGame);
        btn_building.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), buildingMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION); // onUserLeaveHint 액티비티 이동간에 호출하지 않기 == 여기선 .pause() 함수를 사용하지 않는다.
                startActivity(intent);
            }
        });

        // 배열 놀이 클릭 했을 때
        btn_array = findViewById(R.id.btn_arrangementPlay);
        btn_array.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), arrayMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_USER_ACTION); // onUserLeaveHint 액티비티 이동간에 호출하지 않기 == 여기선 .pause() 함수를 사용하지 않는다.
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onUserLeaveHint() { // 홈버튼 감지
        mediaPlayer.pause();
        super.onUserLeaveHint();
    }

    @Override
    protected void onResume() { // 화면 돌아왔을 때
        if(bgmONOFF) mainMenu.mediaPlayer.start();
        super.onResume();
    }

    @Override
    protected void onDestroy() { // 액티비티가
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() { // 뒤로가기 버튼 감지
        mediaPlayer.stop();
        super.onBackPressed();
    }

//    public void BackgroundSound(boolean bgmONOFF) {
//        if(!bgmONOFF) { // 켜져 있으면 끈다.
//            mediaPlayer.pause(); // 중지 == bgmONOFF == true
//            Log.e("bgm","bgm off " + bgmONOFF);
//        }
//        else { // 꺼져있으면 켠다.
//            mediaPlayer.setLooping(true);
//            mediaPlayer.start(); // 시작 == bgmONOFF == flase
//            Log.e("bgm","bgm on" + bgmONOFF);
//        }
//    }
//    public void ClickSound(boolean clickONOFF) {
//        if(!clickONOFF) {
////            btn_array.setSoundEffectsEnabled(false);
////            btn_building.setSoundEffectsEnabled(false);
////            btn_sound.setSoundEffectsEnabled(false);
//            AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
//            amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
//            Log.e("click","click off " + clickONOFF);
//        }
//        else {
////            btn_array.setSoundEffectsEnabled(true);
////            btn_building.setSoundEffectsEnabled(true);
////            btn_sound.setSoundEffectsEnabled(true);
//            AudioManager amanager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
//            amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
//            Log.e("click","click on " + clickONOFF);
//        }
//    }
}