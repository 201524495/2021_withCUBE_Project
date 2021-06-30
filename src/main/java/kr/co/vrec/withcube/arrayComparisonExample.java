package kr.co.vrec.withcube;
// 배열놀이 - 대소비교 예제 푸는 화면
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
                Handler handler = new Handler();
                Log.e("CompareEx","Clicked Button");
                switch (v.getId()) {
                    case R.id.btn_example_equal:
                        toastNomal("다시 한번 생각해 보세요!");
                        btn_equal.setVisibility(View.INVISIBLE);
                        break;

                    case R.id.btn_example_larger:
                        toastNomal("다시 한번 생각해 보세요!");
                        btn_larger.setVisibility(View.INVISIBLE);
                        break;

                    case R.id.btn_example_smaller:
                        Toast.makeText(getApplicationContext(), "정답입니다", Toast.LENGTH_SHORT).show();
                        Log.e("CompareEx","Clicked <");
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(getApplicationContext(), arrayComparisonInstruction.class); //화면 전환
                                startActivity(intent);
                                finish();
                            }
                        }, 1000); //딜레이 타임 조절 1초 후 이동
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
    public void toastNomal(String message){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup)findViewById(R.id.toast_layout));
        TextView toast_textview  = layout.findViewById(R.id.toast_textview);
        toast_textview.setText(String.valueOf(message));
        Toast toast = new Toast(getApplicationContext());
        //toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0); //TODO 메시지가 표시되는 위치지정 (가운데 표시)
        //toast.setGravity(Gravity.TOP, 0, 0); //TODO 메시지가 표시되는 위치지정 (상단 표시)
        //toast.setGravity(Gravity.BOTTOM, 0, 0); //TODO 메시지가 표시되는 위치지정 (하단 표시)
        toast.setDuration(Toast.LENGTH_SHORT); //메시지 표시 시간
        toast.setView(layout);
        toast.show();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}