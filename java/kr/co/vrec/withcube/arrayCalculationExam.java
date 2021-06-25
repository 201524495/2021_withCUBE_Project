package kr.co.vrec.withcube;
// 배열놀이 - 사칙연산
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class arrayCalculationExam extends AppCompatActivity {

    Button btn_hint;
    ImageButton  btn_back, btn_next;
    TextView tv_instruction;
    ImageButton btn_answer1, btn_answer2, btn_answer3;
    ImageView im_block;
    boolean an1=false, an2=false, an3=false;
    
    public static final int calculationBlock[] = {R.drawable.cal_bea1, R.drawable.cal_nakta1, R.drawable.cal_sung1, R.drawable.cal_diamond1, R.drawable.cal_dog1, R.drawable.cal_ori1,
            R.drawable.cal_moolgogi1, R.drawable.cal_flower1, R.drawable.cal_jib1, R.drawable.cal_g1, R.drawable.cal_leebon1, R.drawable.cal_dart, R.drawable.cal_direction1}; // 연산할 사진

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_calculation_exam);
        Log.e("Calculationex","Calculation Exam Activity");


        // 랜덤 값 0 ~ 12
        Random random = new Random();
        int index = random.nextInt(13); // 0 이상 , 13 미만
        int res = calculationBlock[index];

        im_block = findViewById(R.id.im_cal_block);

        im_block.setImageResource(res);
        tv_instruction = findViewById(R.id.tv_instruction);

        btn_answer1 = findViewById(R.id.imbtn_answer1);
        btn_answer2 = findViewById(R.id.imbtn_answer2);
        btn_answer3 = findViewById(R.id.imbtn_answer3);

        boxColor(index);

        btn_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Calculationex","Touch ans1");
                an1 = true;
//                btn_answer1.setImageResource(R.drawable.word_airplane);
                btn_answer1.setVisibility(View.INVISIBLE);
                isAllClicked(an1, an2, an3);
            }
        });
        btn_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Calculationex","Touch ans2");
                an2 = true;
//                btn_answer2.setImageResource(R.drawable.word_dog);
                btn_answer2.setVisibility(View.INVISIBLE);
                isAllClicked(an1, an2, an3);
            }
        });
        btn_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Calculationex","Touch ans3");
                an3 = true;
//                btn_answer3.setImageResource(R.drawable.word_snake);
                btn_answer3.setVisibility(View.INVISIBLE);
                isAllClicked(an1, an2, an3);
            }
        });
        
        // 뒤로가기
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
                Log.e("Calculationex","Calculation Pop up");
                Intent intent = new Intent(getApplicationContext(), arrayCalculationPopUp.class);
                startActivity(intent);
            }
        });

        // 뒷면 보러가기
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Calculationex","Calculation Exam next step");

                if(isAllClicked(an1, an2, an3)) {
                    Intent intent = new Intent(getApplicationContext(), arrayCalculationResult.class);
                    intent.putExtra("randomNum",index); // random Number인 index 값을 넘김 // res는 배열 값임
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(),"답을 확인해 주세요.",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void boxColor(int index) {
        switch(index) {
            case 0: // bea
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_00);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_00);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_05);
                break;
            case 1: // nakta
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_01);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_01);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_00);
                break;
            case 2: // sung
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_04);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_01);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_01);
                break;
            case 3: // dia
            case 4: //dog
            case 9: // mouse
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_02);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_05);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_00);
                break;
            case 5: // ori
            case 11: // dart
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_00);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_00);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_00);
                break;
            case 6: // fish
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_02);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_01);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_05);
                break;
            case 7: // flower
            case 12: // direction
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_00);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_01);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_00);
                break;
            case 8: // home
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_00);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_02);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_00);
                break;
            case 10: // leebon
                btn_answer1.setBackgroundResource(R.drawable.bg_question_box_01);
                btn_answer2.setBackgroundResource(R.drawable.bg_question_box_01);
                btn_answer3.setBackgroundResource(R.drawable.bg_question_box_01);
                break;
        }
    }

    boolean isAllClicked(boolean an1, boolean an2, boolean an3) { // 모두가 클릭되면 true // 아니면 false
        if(an1 && an2 && an3) {
            tv_instruction.setText("정답을 확인해 보세요!");
            return true;
        }
        else {
            return false;
        }
    }
}