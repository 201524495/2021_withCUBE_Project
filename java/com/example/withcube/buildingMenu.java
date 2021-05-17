package com.example.withcube;
// 쌓기 놀이 메뉴
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class buildingMenu extends AppCompatActivity {

    ImageButton btn_airplane, btn_dog, btn_snake;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_menu);


        // 비행기 쌓기 놀이 화면
        btn_airplane = findViewById(R.id.btn_building_airplane);
        btn_airplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenu.mediaPlayer.pause(); // 일단은 종료
                Intent intent = new Intent(getApplicationContext(), buildingAirplane.class);
                startActivity(intent);
            }
        });

        // 강아지 쌓기 놀이 화면
        btn_dog = findViewById(R.id.btn_building_dog);
        btn_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenu.mediaPlayer.pause(); // 일단은 종료
                Intent intent = new Intent(getApplicationContext(), buildingDog.class);
                startActivity(intent);
            }
        });

        // 뱀 쌓기 놀이 화면
        btn_snake = findViewById(R.id.btn_building_snake);
        btn_snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainMenu.mediaPlayer.pause(); // 일단은 종료
                Intent intent = new Intent(getApplicationContext(), buildingSnake.class);
                startActivity(intent);
            }
        });

        // 뒤로가기 == 메인매뉴 == 액티비티 종료
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}