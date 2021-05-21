# 2021_withCUBE_Project



# 1. Switch Dialog

Alert Dialog

    // setup the alert builder
    AlertDialog.Builder builder = new AlertDialog.Builder(mainMenu.this);
    builder.setTitle("환경 설정");
    // add a checkbox list
    builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            // user checked or unchecked a box
           if(which == 0) {
               checkedItems[0] = isChecked;
           }
           if(which == 1) {
               checkedItems[1] = isChecked;
           }
        }
    });

    // add OK buttons
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            bgmONOFF = checkedItems[0];
            clickONOFF = checkedItems[1];
            Log.e("OK","bgm : "+bgmONOFF+" click : "+clickONOFF);
            BackgroundSound(checkedItems[0]);
            ClickSound(checkedItems[1]);

        }
    });
    // add Cancel buttons
    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            checkedItems[0] = bgmONOFF;
            checkedItems[1] = clickONOFF;
            Log.e("Cancel","bgm : "+bgmONOFF+" click : "+clickONOFF);

        }
    });
    
    builder.setCancelable(false); // 외부 화면 클릭해도 창이 닫히지 않는다.
    // create and show the alert dialog
    AlertDialog dialog = builder.create();
    dialog.show();

Custom Dialog

    mEndDialog = new EndDialog(mainMenu.this);
    mEndDialog.setCancelable(false); // 외부 화면 클릭해도 창이 닫히지 않는다.
    mEndDialog.show();    
    

# 2. Video Full Screen

    dfd

# 3. EditText Focus Down
# 4. EditText KeyBoard (Input Type)

     <EditText
        android:id="@+id/et_answer1"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_marginStart="84dp"
        android:layout_marginTop="250dp"
        android:background="@drawable/edittext_rounded_corner_rectangle"
        android:gravity="center"
        android:hint="\?"
        android:fontFamily="@font/font"
        android:inputType="number" // KeyBoard Type
        android:maxLength="1"
        android:nextFocusDown="@id/et_answer2" // next Focus
        app:layout_constraintStart_toEndOf="@+id/tv_question1"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/et_answer2"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_marginStart="84dp"
        android:layout_marginTop="36dp"
        android:background="@drawable/edittext_rounded_corner_rectangle"
        android:gravity="center"
        android:hint="\?"
        android:fontFamily="@font/font"
        android:inputType="number" // KeyBoard Type
        android:maxLength="1"
        android:nextFocusDown="@id/et_answer3" // next Focus
        app:layout_constraintStart_toEndOf="@+id/tv_question2"
        app:layout_constraintTop_toBottomOf="@+id/et_answer1" />

    <EditText
        android:id="@+id/et_answer3"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_marginStart="84dp"
        android:layout_marginTop="36dp"
        android:background="@drawable/edittext_rounded_corner_rectangle"
        android:gravity="center"
        android:hint="\?"
        android:fontFamily="@font/font"
        android:imeOptions="actionDone"
        android:inputType="number" // KeyBoard Type
        android:maxLength="1"
        app:layout_constraintStart_toEndOf="@+id/tv_question3"
        app:layout_constraintTop_toBottomOf="@+id/et_answer2" />
    
# 5. Text Blink

    private void blinkText() {
        TextView myText = (TextView) findViewById(R.id.tv_animation );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(500); //You can manage the time of the blink with this parameter
        anim.setStartOffset(200);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);
    }

# 6. Sound option

    public static MediaPlayer mediaPlayer;
    mediaPlayer = MediaPlayer.create(mainMenu.this, R.raw.b_06); // 음악 샘플 추가
    mediaPlayer.start(); // 일단 시작
    public void BackgroundSound(boolean bgmONOFF) {
        if(!bgmONOFF) { // 켜져 있으면 끈다.
            mediaPlayer.pause(); // 중지 == bgmONOFF == true
            Log.e("bgm","bgm off " + bgmONOFF);
        }
        else { // 꺼져있으면 켠다.
            mediaPlayer.setLooping(true);
            mediaPlayer.start(); // 시작 == bgmONOFF == flase
            Log.e("bgm","bgm on" + bgmONOFF);
        }
    }
    //
    public void ClickSound(boolean clickONOFF) {
        AudioManager amanager=(AudioManager)this.getContext().getSystemService(Context.AUDIO_SERVICE);
        if(!clickONOFF) {
            amanager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
            Log.e("click","click off " + clickONOFF);
        }
        else {
            amanager.setStreamMute(AudioManager.STREAM_SYSTEM, false);
            Log.e("click","click on " + clickONOFF);
        }
    }
# 7. Splash Activity

    dfd

# 8. 

    dfd

