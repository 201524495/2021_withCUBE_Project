package com.example.withcube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class arrayCalculationExample extends AppCompatActivity {

    TextView tv_instruction;
    EditText et_ans1, et_ans2, et_ans3;
    ImageButton btn_back;
    Button btn_next;
    Button btn_hint;
    private int i = 0; // 정답확인 및 화면 이동 flag

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_calculation_example);
        Log.e("CalculationEx","Calculation Example Activity");

        tv_instruction = findViewById(R.id.tv_instruction);
        tv_instruction.setText("\"?\"에 알맞은 숫자를 입력해 보세요");

        et_ans1 = findViewById(R.id.et_answer1);
        et_ans2 = findViewById(R.id.et_answer2);
        et_ans3 = findViewById(R.id.et_answer3);
        // 클릭하면 끝 쪽으로 이동 == 클릭후 백스페이스 하면 바로 지워 지게끔
        et_ans1.setSelection(et_ans1.getText().length());
        et_ans2.setSelection(et_ans2.getText().length());
        et_ans3.setSelection(et_ans3.getText().length());
//        // 커서 제거
        et_ans1.setCursorVisible(false);
        et_ans2.setCursorVisible(false);
        et_ans3.setCursorVisible(false);
        // 다음 화면으로 이동 == 정답 확인
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { Log.e("CalculationEx","Push the next button");
                i++;
                if(i == 1) { // 처음 클릭 시 정답 확인

                    Log.e("CalculationEx","Check push first time : "+i);
//                    if(et_ans1.getText().toString().length() == 0 || et_ans2.getText().toString().getBytes().length<=0 || et_ans3.getText().toString().equals(""))
//                    if(et_ans1.getText().toString().getBytes().length<=0 || et_ans2.getText().toString().getBytes().length<=0 || et_ans3.getText().toString().getBytes().length<=0 )
                    if(et_ans1.getText().toString().equals("") || et_ans2.getText().toString().equals("") || et_ans3.getText().toString().equals(""))
                    { // Edit_Text에 입력이 되지 않았을 때 // || (or)을 사용해 하나라도 성립( null 값을 받으면 )하면 Toast를 띄운다
                        Log.e("CalculationEx"," 1111 ");
                        Toast.makeText(getApplicationContext(),"빈칸을 모두 채워주세요",Toast.LENGTH_SHORT).show(); // Toast 띄움
                        i--;
                    }
                    else { // null 값 아닐 때 한번만 확인
                        Log.e("CalculationEx","Check edit_text value ");
                        if( Integer.parseInt(et_ans1.getText().toString()) == 9 ) et_ans1.setBackgroundResource(R.drawable.box_green_edittext);
                        else et_ans1.setBackgroundResource(R.drawable.box_red_edittext); // 답이 틀리면
                        if( Integer.parseInt(et_ans2.getText().toString()) == 2 ) et_ans2.setBackgroundResource(R.drawable.box_green_edittext);
                        else et_ans2.setBackgroundResource(R.drawable.box_red_edittext); // 답이 틀리면
                        if( Integer.parseInt(et_ans3.getText().toString()) == 8 ) et_ans3.setBackgroundResource(R.drawable.box_green_edittext);
                        else et_ans3.setBackgroundResource(R.drawable.box_red_edittext); // 답이 틀리면

                        btn_next.setText("문제 풀러 가기");
                        tv_instruction.setText("정답은 X X X 입니다.");
                    }
                }

                else if(i > 1) { // 한번 더 클릭 시 "문제 풀러가기" 버튼 활성화
                    Log.e("CalculationEx","Move Cal Exam Activity ");
                   // btn_next.setText("문제 풀러 가기");
                    Intent intent = new Intent(getApplicationContext(), arrayCalculationInstruction.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 문제 설명 팝업 띄우기
        btn_hint = findViewById(R.id.btn_hint);
        btn_hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("CalculationEx","Push the Instruction button");
                Intent intent = new Intent(getApplicationContext(), arrayCalculationPopUp.class);
                startActivity(intent);
            }
        });
    }
}