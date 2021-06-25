package kr.co.vrec.withcube;
// 배열 놀이 - 숫자 놀이
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class arrayNumbering extends AppCompatActivity {
    ImageButton btn_next, btn_back, btn_end;
    private int num = 0;
    ImageView im_Number;

    public static final int ran[] = {R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4,
            R.drawable.num5, R.drawable.num6, R.drawable.num7, R.drawable.num8, R.drawable.num9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_numbering);

        im_Number = findViewById(R.id.im_Number);
        // 0 ~ 9까지 사진 반복
        btn_next = findViewById(R.id.btn_next);
        Log.e("Numbering","Enter the Numbering Activity");
        im_Number.setImageResource(ran[0]);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Numbering","Clicked next"+num);
                num++;
                checkTimes();
            }
        });

        // 뒤로가기 == 배열놀이 매뉴로 이동 == 액티비티 종료
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_end = findViewById(R.id.btn_end);
        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }
        });
    }


    private void checkTimes() {
        if(num > 8) {
            Log.e("Numbering","num is larger than 9");
            btn_next.setVisibility(View.GONE);
            btn_back.setVisibility(View.GONE);
            btn_end.setVisibility(View.VISIBLE);
        }
        else {
            im_Number.setImageResource(ran[num]); // 이미지 변경 및 텍스트 변경 함수
        }
    }
}