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

    dfd

# 4. EditText KeyBoard (Input Type)

    dfd
    
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

    dfd

# 7. Splash Activity

    dfd

# 8. 

    dfd

