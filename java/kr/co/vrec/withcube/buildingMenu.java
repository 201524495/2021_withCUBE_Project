package kr.co.vrec.withcube;
// 쌓기 놀이 메뉴
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class buildingMenu extends AppCompatActivity {

    ImageButton btn_airplane, btn_dog, btn_snake, btn_heart, btn_chair,
            btn_bed, btn_crystal, btn_turtle, btn_dino, btn_bird, btn_sofa, btn_scorpion;
    ImageButton btn_back;
    public static int videoNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_menu);

        btn_airplane = findViewById(R.id.btn_building_airplane);
        btn_back = findViewById(R.id.btn_back);
        btn_bed = findViewById(R.id.btn_building_bed);
        btn_bird = findViewById(R.id.btn_building_bird);
        btn_dino = findViewById(R.id.btn_building_dino);
        btn_dog = findViewById(R.id.btn_building_dog);
        btn_chair = findViewById(R.id.btn_building_chair);
        btn_crystal = findViewById(R.id.btn_building_crystal);
        btn_heart = findViewById(R.id.btn_building_heart);
        btn_scorpion = findViewById(R.id.btn_building_scorpion);
        btn_snake = findViewById(R.id.btn_building_snake);
        btn_sofa = findViewById(R.id.btn_building_sofa);
        btn_turtle = findViewById(R.id.btn_building_turtle);

        View.OnClickListener listenser = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkButton(v);
                if(videoNum == 99){
                    finish();
                }else {
                    Intent intent = new Intent(getApplicationContext(), videoActivity.class);
                    startActivity(intent);
                }
            }
        };

        btn_airplane.setOnClickListener(listenser);
        btn_back.setOnClickListener(listenser);
        btn_bed.setOnClickListener(listenser);
        btn_bird.setOnClickListener(listenser);
        btn_dino.setOnClickListener(listenser);
        btn_dog.setOnClickListener(listenser);
        btn_chair.setOnClickListener(listenser);
        btn_crystal.setOnClickListener(listenser);
        btn_heart.setOnClickListener(listenser);
        btn_scorpion.setOnClickListener(listenser);
        btn_snake.setOnClickListener(listenser);
        btn_sofa.setOnClickListener(listenser);
        btn_turtle.setOnClickListener(listenser);

    }

    private void checkButton(View v) {
        switch(v.getId()) {
            case R.id.btn_building_airplane:
                videoNum = 0;
                break;
            case R.id.btn_building_bed:
                videoNum = 1;
                break;
            case R.id.btn_building_bird:
                videoNum = 2;
                break;
            case R.id.btn_building_dino:
                videoNum = 3;
                break;
            case R.id.btn_building_dog:
                videoNum = 4;
                break;
            case R.id.btn_building_chair:
                videoNum = 5;
                break;
            case R.id.btn_building_crystal:
                videoNum = 6;
                break;
            case R.id.btn_building_heart:
                videoNum = 7;
                break;
            case R.id.btn_building_scorpion:
                videoNum = 8;
                break;
            case R.id.btn_building_snake:
                videoNum = 9;
                break;
            case R.id.btn_building_sofa:
                videoNum = 10;
                break;
            case R.id.btn_building_turtle:
                videoNum = 11;
                break;
            case R.id.btn_back: // 뒤로가기
                videoNum = 99;
                break;
        }
    }
}