package kr.co.vrec.withcube;
// 배열놀이 - 사칙연산 규칙설명 팝업
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        
        // 뒤로가기 == 메뉴로 이동 == 팝업 종료
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}