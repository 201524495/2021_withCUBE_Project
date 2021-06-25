package kr.co.vrec.withcube;
// 배열놀이 - 대소비교 연산자에 대해 설명해주는 화면
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        // 닫기 버튼 == 예제 풀기
        btn_next = findViewById(R.id.btn_back);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}