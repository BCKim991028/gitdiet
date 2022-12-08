package com.course.project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView myPicture;
        TextView myText1;
        TextView myText;
        MyViewHolder(View view){
            super(view);
            myText1 = view.findViewById(R.id.textView5);
            myText = view.findViewById(R.id.textView4);
        }
    }
    private ArrayList<Foods.Food> myFoodList;
    Myadapter(ArrayList<Foods.Food> foods){
        this.myFoodList = foods;
    }
    @Override
    public Myadapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent,
                        false);
        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(Myadapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int
            position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.myText.setText(myFoodList.get(position).getFoodName());
        myViewHolder.myText1.setText(myFoodList.get(position).getEatTime());
        myViewHolder.myText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), fooditem.class);
                intent.putExtra("위도2", myFoodList.get(position).getLatitude());
                intent.putExtra("경도2", myFoodList.get(position).getLongitude());
                intent.putExtra("음식이름1", myFoodList.get(position).getFoodName());
                intent.putExtra("음식개수1", myFoodList.get(position).getFoodNum());
                intent.putExtra("음식평1", myFoodList.get(position).getFoodFeel());
                intent.putExtra("먹었었던 시간1", myFoodList.get(position).getEatTime());
                intent.putExtra("음식사진1", myFoodList.get(position).getFoodImage());
                intent.putExtra("칼로리1", myFoodList.get(position).getCaloly());
                v.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return myFoodList.size();
    }
    /*public void  filterList(ArrayList<Foods.Food> filteredList) {
        myFoodList = filteredList;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView Month;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.Month=itemView.findViewById(R.id.textView5);

        }
    }*/
}



