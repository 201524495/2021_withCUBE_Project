package com.example.withcube;
// 배열놀이 - 대소비교 노랑 화면으로 규칙 설명해주는 화면
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class arrayComparisonInstruction extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_comparison_instruction);
        Log.e("CompareIn","Compare Instruction Activity");

        // 몇 초 있다 화면을 클릭하세요 뜨게끔
        blinkText();
    }
    private void blinkText() {
        TextView myText = (TextView) findViewById(R.id.tv_animation );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the time of the blink with this parameter
        anim.setStartOffset(200);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);
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