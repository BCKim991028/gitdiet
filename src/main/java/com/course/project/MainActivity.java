package com.course.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.ByteArrayOutputStream;

import kotlin.text.UStringsKt;

public class MainActivity extends AppCompatActivity  {
    Button btnCamera;
    ImageView imageView;
    Double latitude;
    Double longitude;
    Bitmap imageBitmap;
    Drawable drawable;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button foodlist_btn = findViewById(R.id.foodlist_btn);
        foodlist_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), foodlist.class);
            startActivity(intent);
        });
        Button googlemap_btn = findViewById(R.id.googlemap_btn);
        googlemap_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), googlesmap.class);
            startActivity(intent);
        });
        Button mapread_btn = findViewById(R.id.mapread_btn);
        mapread_btn.setOnClickListener(view -> {
            Intent intent = getIntent();
            latitude = intent.getDoubleExtra("위도",1);
            longitude = intent.getDoubleExtra("경도", 2);
            TextView textView2, textView3;
            textView2 = findViewById(R.id.textView2);
            textView3 = findViewById(R.id.textView3);
            textView2.setText("위도 "+latitude);
            textView3.setText("경도 "+longitude);
        });
        btnCamera = findViewById(R.id.foodpicture_btn);
        imageView = findViewById(R.id.imageView);
        btnCamera.setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.foodpicture_btn:
                    Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(i, 0);
                    break;
        }});
        Button foodinfo_btn = findViewById(R.id.foodinfo_btn);
        foodinfo_btn.setOnClickListener(this::onClick);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)    {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            drawable = new BitmapDrawable(imageBitmap);
            imageView.setImageBitmap(imageBitmap);
        }
    }

    private void onClick(View view) {
        String Foodname = ((EditText) findViewById(R.id.editText1)).getText().toString();
        String Foodnum = ((EditText) findViewById(R.id.editText2)).getText().toString();
        String Foodfeel = ((EditText) findViewById(R.id.editText3)).getText().toString();
        String Eattime = ((EditText) findViewById(R.id.editText4)).getText().toString();
        Double latitude1 = latitude; // 위도
        Double longitude1 = longitude; // 경도
/*        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);

        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        float scale = (float) (1024 / (float) bitmap.getWidth());
        int image_w = (int) (bitmap.getWidth() * scale);
        int image_h = (int) (bitmap.getHeight() * scale);
        Bitmap resize = Bitmap.createScaledBitmap(bitmap, image_w, image_h, true);
        resize.compress(Bitmap.CompressFormat.JPEG, 100, stream)8;
        byte[] byteArray = stream.toByteArray();*/
        Intent intent = new Intent(MainActivity.this, foodlist.class);
        intent.putExtra("위도1", latitude1);
        intent.putExtra("경도1", longitude1);
        intent.putExtra("음식이름", Foodname);
        intent.putExtra("음식개수", Foodnum);
        intent.putExtra("음식평", Foodfeel);
        intent.putExtra("먹었었던 시간", Eattime);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        intent.putExtra("음식사진",byteArray);

        startActivity(intent);

    }
    /*
    public void addmeal(View view) {
        ContentValues addValues;
        addValues = new ContentValues();
        addValues.put(ContentsProvider.FOOD_NAME,

                ((EditText)findViewById(R.id.editText1)).getText().toString());
        addValues.put(ContentsProvider.FOOD_NUM,

                ((EditText)findViewById(R.id.editText2)).getText().toString());
        addValues.put(ContentsProvider.FOOD_FEEL,

                ((EditText)findViewById(R.id.editText3)).getText().toString());
        addValues.put(ContentsProvider.EAT_TIME,

                ((EditText)findViewById(R.id.editText4)).getText().toString());
        addValues.put(ContentsProvider.LATITUDE,

                ((TextView)findViewById(R.id.textView2)).getText().toString());
        addValues.put(ContentsProvider.LONGITUDE,

                ((TextView)findViewById(R.id.textView3)).getText().toString());
        getContentResolver().insert(ContentsProvider.CONTENT_URI, addValues);
        Toast.makeText(getBaseContext(),
                "Record Added", Toast.LENGTH_LONG).show();
    }
    public void getfoods(View view) {
        String[] columns = new String[]{"food_name", "food_num",
                "food_feel","eat_time","latitude","longitude"};
        Cursor c =
                getContentResolver().query(ContentsProvider.CONTENT_URI, columns, null,
                        null, null, null);
        if (c != null) {
            EditText editMultipleText = findViewById(R.id.editText5);
            editMultipleText.setText("");
            while (c.moveToNext()) {
                int id = c.getInt(0);
                String name = c.getString(1);
                int num = c.getInt(2);
                String feel = c.getString(3);
                String time = c.getString(4);
                String latitude = c.getString(5);
                String longitude = c.getString(6);
                editMultipleText.append("id: " + id +"\nfood_name: " + name + "\n food_num: " +
                        num + "\n food_feel: " + feel + "\n eat_time: " + time + "\n" +"위도 : " +
                        latitude + "경도 : " +longitude);
            }
            editMultipleText.append("\n Total : " + c.getCount());
            c.close();
        }
    }*/ 
}