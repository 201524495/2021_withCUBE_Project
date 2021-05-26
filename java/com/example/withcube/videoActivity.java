
package com.example.withcube;
// 쌓기 놀이 비행기
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.pm.ActivityInfo;
        import android.net.Uri;
        import android.os.Bundle;
        import android.util.DisplayMetrics;
        import android.util.Log;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.FrameLayout;
        import android.widget.ImageButton;
        import android.widget.MediaController;
        import android.widget.VideoView;

        import static com.example.withcube.buildingMenu.videoNum;
        import static com.example.withcube.mainMenu.mediaPlayer;
        import static com.example.withcube.soundActivity.bgmONOFF;

public class videoActivity extends AppCompatActivity {

    VideoView videoView;
    Button btn_back;
    private ImageButton btn_full;
    private MediaController mediaController;
    private boolean isFull;
    FrameLayout layout;
    public static final String video[] = {"withcubeairplanes", "withcubedog", "withcubesnake"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        isFull = false;
        Log.e("building","video");

        videoView = findViewById(R.id.main_videoview);
        layout = findViewById(R.id.videoview_frame);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/raw/"+video[videoNum]);
        videoView.setVideoURI(uri);

        btn_full = findViewById(R.id.fullscreen_button);
        btn_full.setBackgroundResource(R.drawable.ic_baseline_zoom_out_map_24);
        btn_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFullScreen(!isFull);
                v.setBackgroundResource(isFull ?  R.drawable.uvv_star_zoom_in : R.drawable.ic_baseline_zoom_out_map_24);
            }
        });
//
        mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);
        mediaController.setPadding(5, 0,5,1);

        // 비디오 뷰의 재생, 일시정지 등을 할 수 있는 '컨트롤 바'를 붙여줌
        videoView.setMediaController(mediaController);
        // VideoView가 보여줄 동영상의 경로 주소 설정
        videoView.setVideoURI(uri);

        mediaPlayer.pause(); // 중지 == bgmONOFF == true
        Log.e("bgm","bgm off " + bgmONOFF);

        videoView.start();


        // 다른 동영상 보기 == activity 종료
        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // controller always visible
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        if(mediaController != null)
//            mediaController.show(0);
    }

    // 화면이 안보일 때
    @Override
    protected void onPause() {
        super.onPause();
        // 비디오 일시 정지
        if(videoView != null && videoView.isPlaying()) videoView.pause();
    }

    // 액티비티가 메모리에서 사라질 때
    @Override
    protected void onDestroy() {
        if(bgmONOFF) {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
        }
        super.onDestroy();
        //
        if(videoView != null) videoView.stopPlayback();

    }

    private void setFullScreen(boolean full) {
        isFull = full;
        ViewGroup.LayoutParams params = layout.getLayoutParams();

        if (isFull) {
            isFull = true;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_FULLSCREEN);
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_IMMERSIVE
                            // Set the content to appear under the system bars so that the
                            // content doesn't resize when the system bars hide and show.
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            // Hide the nav bar and status bar
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN);

            decorView.setOnSystemUiVisibilityChangeListener
                    (new View.OnSystemUiVisibilityChangeListener() {
                        @Override
                        public void onSystemUiVisibilityChange(int visibility) {
                            // Set the content to appear under the system bars so that the
                            // content doesn't resize when the system bars hide and show.
                            // Hide the nav bar and status bar
                            decorView.setSystemUiVisibility(
                                    View.SYSTEM_UI_FLAG_IMMERSIVE
                                            // Set the content to appear under the system bars so that the
                                            // content doesn't resize when the system bars hide and show.
                                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                                            // Hide the nav bar and status bar
                                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                            | View.SYSTEM_UI_FLAG_FULLSCREEN);
                        }
                    });

        } else {
            isFull = false;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            int height = (int) (metrics.density * 250);
            params.height = height;

            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        }
    }
}