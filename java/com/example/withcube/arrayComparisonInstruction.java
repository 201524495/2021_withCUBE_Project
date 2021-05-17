package com.example.withcube;
// 배열놀이 - 대소비교 노랑 화면으로 규칙 설명해주는 화면
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class arrayComparisonInstruction extends AppCompatActivity {

//    public static Activity arraycomparisoninstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_comparison_instruction);
        Log.e("CompareIn","Compare Instruction Activity");
//        arraycomparisoninstruction = arrayComparisonInstruction.this;
    }

    // 화면을 눌렀을 때 문제를 푸는 화면으로 이동함
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN) {
            Log.e("CompareIn","Touch Screen");
            Intent intent = new Intent(getApplicationContext(), arrayComparisonExam.class);
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