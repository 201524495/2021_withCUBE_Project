package com.example.withcube;
// 배열놀이 - 대소비교 연산자에 대해 설명해주는 화면
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class arrayComparisonPopUp extends AppCompatActivity {

    TextView tv_larger, tv_smaller, tv_equal;
    ImageButton btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_comparison_pop_up);

        Log.e("Comparepop","Compare Pop Up Activity");
        // 설명하는 Activity
        tv_equal = findViewById(R.id.tv_pop_equal);
        tv_smaller = findViewById(R.id.tv_pop_smaller);
        tv_larger = findViewById(R.id.tv_pop_larger);

//        tv_equal.setText("왼쪽 값과 오른쪽 값의 크기가 같음");
//        tv_larger.setText("왼쪽 값이 오른쪽 값보다 큼");
//        tv_smaller.setText("왼쪽 값이 오른쪽 값보다 작음");

        // 닫기 버튼 == 예제 풀기
        btn_next = findViewById(R.id.btn_back);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        // 바깥 레이어 클릭시 안닫히게
//        if(event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        // 안드로이드 백버튼 막기
//        return;
//    }
}