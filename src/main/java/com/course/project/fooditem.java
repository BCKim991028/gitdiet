package com.course.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class fooditem  extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fooditem);
        Intent intent = getIntent();
        double latitude = intent.getDoubleExtra("위도2",0);
        double longitude = intent.getDoubleExtra("경도2", 0);
        String foodname = intent.getStringExtra("음식이름1");
        int foodnum = intent.getIntExtra("음식개수1",0);
        int Caloly = intent.getIntExtra("칼로리1",0);
        String foodfeel = intent.getStringExtra("음식평1");
        String eattime = intent.getStringExtra("먹었었던 시간1");
        byte[] byteArray = intent.getByteArrayExtra("음식사진1");
        Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView BigImage = (ImageView)findViewById(R.id.imageView3);
        BigImage.setImageBitmap(image);
        TextView textView6,textView7,textView8,textView9,textView10,textView11;

        textView6 = findViewById(R.id.textView6);
        textView7 = findViewById(R.id.textView7);
        textView8 = findViewById(R.id.textView8);
        textView9 = findViewById(R.id.textView9);
        textView10 = findViewById(R.id.textView10);
        textView11 = findViewById(R.id.textView11);
        textView6.setText("음식이름  \n" + foodname);
        textView7.setText("음식개수 : "+foodnum);
        textView8.setText("음식평 : "+foodfeel);
        textView9.setText("먹었었던 시간 :  "+eattime);
        textView10.setText("음식점의 위도 :  "+latitude + "\n음식점의 경도 :  " +longitude);
        textView11.setText("칼로리 : "+ Caloly);

    }
}
