package com.example.withcube;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);

         try{
             Thread.sleep(2000);
         }catch (InterruptedException e) {
             e.printStackTrace();
         }
         Intent intent = new Intent(this, mainMenu.class);
         startActivity(intent);
         finish();
     }
}