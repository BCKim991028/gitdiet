package com.course.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class foodlist extends AppCompatActivity {
    ArrayList<Foods.Food> foodItemArrayList, filteredList;
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;
    StringBuilder datearr= new StringBuilder();
    /*Myadapter foodAdapter;
    EditText searchET = findViewById(searchMonth);
*/

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        filteredList=new ArrayList<>();
        foodItemArrayList = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodlist);

        Button main_btn = (Button) findViewById(R.id.main_btn);
        main_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        ArrayList<Foods.Food> foodsInfo = new ArrayList<>();

        Myadapter myAdapter = new Myadapter(foodsInfo);
        // 어댑터를 뷰에 연결해 준다.
        myRecyclerView.setAdapter(myAdapter);

        Button generate_btn = (Button)findViewById(R.id.generate_btn);
        generate_btn.setOnClickListener(view-> {
            Intent intent = getIntent();
            int caloly = intent.getIntExtra("칼로리",0);
            double latitude = intent.getDoubleExtra("위도1",0);
            double longitude = intent.getDoubleExtra("경도1", 0);
            String foodname = intent.getStringExtra("음식이름");
            String foodnums = intent.getStringExtra("음식개수");
            int foodnum = Integer.parseInt(foodnums);
            String foodfeel = intent.getStringExtra("음식평");
            String eattime = intent.getStringExtra("먹었었던 시간");
            byte[] arr = getIntent().getByteArrayExtra("음식사진");
            foodsInfo.add(new Foods.Food(arr, foodname, foodnum,caloly,foodfeel,eattime,latitude,longitude));
            myRecyclerView.setAdapter(myAdapter);
  //          myAdapter.notifyDataSetChanged();

            datearr.append(foodname +"."+eattime+"."+caloly);
        });
        /*searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                String searchText = searchET.getText().toString();
                searchFilter(searchText);

            }
        });

    }
    public void searchFilter(String searchText) {
        filteredList.clear();

        for (int i = 0; i < foodItemArrayList.size(); i++) {
            if (foodItemArrayList.get(i).getEatMonth().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(foodItemArrayList.get(i));
            }
        }

        foodAdapter.filterList(filteredList);*/
    }
}
