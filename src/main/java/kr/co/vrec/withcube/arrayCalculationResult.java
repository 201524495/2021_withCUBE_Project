package kr.co.vrec.withcube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class arrayCalculationResult extends AppCompatActivity {
    ImageButton btn_back;
    Button btn_next;
    ImageView  im_result_block, tv_result_real;

    public static final int calculationBlock[] = {R.drawable.block_boat, R.drawable.block_camel, R.drawable.block_castle, R.drawable.block_diamond, R.drawable.block_dog, R.drawable.block_duck,
            R.drawable.block_fish, R.drawable.block_flower, R.drawable.block_house, R.drawable.block_mouse, R.drawable.block_ribbon}; // 연산할 사진

    public static final int blockPicture[] = {R.drawable.res_boat, R.drawable.res_camel, R.drawable.res_castle, R.drawable.res_dia, R.drawable.res_dog, R.drawable.res_duck,
            R.drawable.res_fish, R.drawable.res_flower, R.drawable.res_home, R.drawable.res_mouse, R.drawable.res_ribbon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_calculation_result);

        int Number = getIntent().getIntExtra("randomNum",1); // arrayCalculationExam에서 나온 randomNum 값을 Number로 받는다.
        im_result_block = findViewById(R.id.im_result_block);
        tv_result_real = findViewById(R.id.tv_result);

        tv_result_real.setImageResource(blockPicture[Number]);
        im_result_block.setImageResource(calculationBlock[Number]);

//        setText(Number);
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

//    private void setText(int number) {
//        switch(number) {
//            case 0: tv_result.setText("보트가 완성되었어요"); break;
//            case 1: tv_result.setText("낙타가 완성되었어요"); break;
//            case 2: tv_result.setText("성이 완성되었어요"); break;
//            case 3: tv_result.setText("보석이 완성되었어요"); break;
//            case 4: tv_result.setText("강아지가 완성되었어요"); break;
//            case 5: tv_result.setText("오리가 완성되었어요"); break;
//            case 6: tv_result.setText("물고기가 완성되었어요"); break;
//            case 7: tv_result.setText("꽃이 완성되었어요"); break;
//            case 8: tv_result.setText("집이 완성되었어요"); break;
//            case 9: tv_result.setText("생쥐가 완성되었어요"); break;
//            case 10: tv_result.setText("리본이 완성되었어요"); break;
//            case 11: tv_result.setText("표창이 완성되었어요"); break;
//            case 12: tv_result.setText("화살표가 완성되었어요"); break;
//            default : break;
//        }
//    }

}