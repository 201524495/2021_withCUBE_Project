package com.example.withcube;
// 배열놀이 - 대소비교 예제 푸는 화면
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class arrayComparisonExample extends AppCompatActivity {
    Button btn_larger, btn_equal, btn_smaller;
    Button btn_hint;
    ImageButton btn_back;
    TextView tv_instruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_comparison_example);

        tv_instruction = findViewById(R.id.tv_example_instruction);

        btn_equal = findViewById(R.id.btn_example_equal);
        btn_larger = findViewById(R.id.btn_example_larger);
        btn_smaller = findViewById(R.id.btn_example_smaller);
        Log.e("CompareEx","Compare Example Activity");
        // 각각 버튼을 눌렀을 때 실행
        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CompareEx","Clicked Button");
                switch (v.getId()) {
                    case R.id.btn_example_equal:
                        Toast.makeText(getApplicationContext(), "다시 한번 생각해 보세요", Toast.LENGTH_SHORT).show();
                        delay();
                        Log.e("CompareEx","Clicked =");
                        break;
                    case R.id.btn_example_smaller:
                        Toast.makeText(getApplicationContext(), "정답입니다", Toast.LENGTH_SHORT).show();
                        Log.e("CompareEx","Clicked <");
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), arrayComparisonInstruction.class); //화면 전환
                                startActivity(intent);
                                finish();
                            }
                        }, 1000); //딜레이 타임 조절 1초 후 이동
                        break;
                    case R.id.btn_example_larger:
                        Toast.makeText(getApplicationContext(), "다시 한번 생각해 보세요", Toast.LENGTH_SHORT).show();
                        delay();
                        Log.e("CompareEx","Clicked >");
                        break;
                    default:
                        break;
                }
            }
        };
        btn_smaller.setOnClickListener(onClickListener);
        btn_larger.setOnClickListener(onClickListener);
        btn_equal.setOnClickListener(onClickListener);

        // 힌트 팝업 띄우기
        btn_hint = findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CompareEx","Clicked hint");
                Intent intent = new Intent(getApplicationContext(), arrayComparisonPopUp.class);
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
    public void delay() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, 100000); //딜레이 타임 조절 1초 후 이동
    }
}