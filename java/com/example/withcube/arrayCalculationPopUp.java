package com.example.withcube;
// 배열놀이 - 사칙연산 규칙설명 팝업
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class arrayCalculationPopUp extends AppCompatActivity {

    TextView tv_pluse, tv_minus, tv_equal;
    ImageButton btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_calculation_pop_up);

        Log.e("Calculationpop","Calculator Pop up Activity");
        tv_equal = findViewById(R.id.tv_cal_equal);
        tv_minus = findViewById(R.id.tv_cal_minus);
        tv_pluse = findViewById(R.id.tv_cal_pluse);

        // 설명 추가
//        tv_pluse.setText("왼쪽 값과 오른쪽 값을 더한다는 의미");
//        tv_minus.setText("왼쪽 값에서 오른쪽 값을 뺀다는 의미");
//        tv_equal.setText("왼쪽 값과 오른쪽 값이 같다는 의미");
        
        // 뒤로가기 == 메뉴로 이동 == 팝업 종료
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
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