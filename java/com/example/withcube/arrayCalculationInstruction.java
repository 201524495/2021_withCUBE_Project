package com.example.withcube;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class arrayCalculationInstruction extends AppCompatActivity {

//    public static Activity arraycalculationinstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_calculation_instruction);
        Log.e("CalculationIn","Calculation Instruction Activity");
//        arraycalculationinstruction = arrayCalculationInstruction.this;
    }

    // 화면을 눌렀을 때 문제를 푸는 화면으로 이동함

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN) {
            Log.e("CalculationIn","touch screen ");
            Intent intent = new Intent(getApplicationContext(), arrayCalculationExam.class);
            startActivity(intent);
            finish();
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}