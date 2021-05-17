package com.example.withcube;
// 배열놀이 메뉴
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class arrayMenu extends AppCompatActivity {

    Button btn_Numbering, btn_Comparison, btn_Calculation;
    ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_menu);

        // 숫자학습 액티비티로 이동
        btn_Numbering = findViewById(R.id.btn_numbering);
        btn_Numbering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), arrayNumbering.class);
                Log.e("error","Numbering ");
                startActivity(intent);
            }
        });

        // 대소비교 액티비티로 이동
        btn_Comparison = findViewById(R.id.btn_comparison);
        btn_Comparison.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), arrayComparisonExample.class);
                Log.e("error","Comparing ");
                startActivity(intent);
            }
        });

        // 사칙연산 액티비티로 이동
        btn_Calculation = findViewById(R.id.btn_calculations);
        btn_Calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), arrayCalculationExample.class);
                Log.e("error","Calculating ");
                startActivity(intent);
            }
        });

        // 뒤로가기 == 메인메뉴로 이동 == 액티비티 종료
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}