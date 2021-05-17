package com.example.withcube;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class arrayCalculationResult extends AppCompatActivity {
//    public static Activity arraycalculatorresult;
    ImageButton btn_back, btn_next;
    ImageView im_result_real, im_result_block;
    public static final int calculationBlock[] = {R.drawable.block_boat, R.drawable.block_camel, R.drawable.block_castle, R.drawable.block_diamond, R.drawable.block_dog, R.drawable.block_duck,
            R.drawable.block_fish, R.drawable.block_flower, R.drawable.block_house, R.drawable.block_mouse, R.drawable.block_ribbon}; // 연산할 사진

    public static final int blockPicture[] = {R.drawable.block_boat, R.drawable.block_camel, R.drawable.block_castle, R.drawable.block_diamond, R.drawable.block_dog, R.drawable.block_duck,
            R.drawable.block_fish, R.drawable.block_flower, R.drawable.block_house, R.drawable.block_mouse, R.drawable.block_ribbon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_calculation_result);

        int Number = getIntent().getIntExtra("randomNum",1); // arrayCalculationExam에서 나온 randomNum 값을 Number로 받는다.
        im_result_block = findViewById(R.id.im_result_block);
        im_result_real = findViewById(R.id.im_result_real);

        im_result_real.setImageResource(blockPicture[Number]);
        im_result_block.setImageResource(calculationBlock[Number]);
//        arraycalculatorresult = arrayCalculationResult.this;
//
//        arrayCalculationExam arraycalculationexam = (arrayCalculationExam)arrayCalculationExam.arraycalculationexam;
//        arraycalculationexam.finish(); // exam activity 종료

        // 종료
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 다른 문제 풀기
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), arrayCalculationExam.class);
                startActivity(intent);
                finish();
            }
        });
    }

}