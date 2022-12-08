package com.course.project;


import android.view.View;

public class Foods {
    public static class Food {
        byte[] food_image;
        String food_name;
        int food_num;
        String food_feel;
        String eat_time;
        double latitude;
        double longitude;
        int Caloly;
        int year;
        int month;
        int day;
        public Food(byte[] food_image, String food_name, int food_num, int caloly, String food_feel, String eat_time, double latitude, double longitude) {
            this.food_image = food_image;
            this.food_name = food_name;
            this.food_num = food_num;
            this.Caloly = caloly;
            this.food_feel = food_feel;
            this.eat_time = eat_time;
            this.latitude = latitude;
            this.longitude = longitude;
            String[] datearray = eat_time.split("\\.");
            this.year = Integer.parseInt(datearray[0]);
            this.month = Integer.parseInt(datearray[1]);
            this.day = Integer.parseInt(datearray[2]);
        }

        public byte[] getFoodImage() {
            return food_image;
        }
        public String getFoodName() {
            return food_name;
        }
        public int getCaloly() {
            return Caloly;
        }
        public int getFoodNum() {
            return food_num;
        }
        public int getEatYear() {
            return year;
        }
        public int getEatMonth() {
            return month;
        }
        public int getEatDay() {
            return day;
        }

        public String getFoodFeel() {
            return food_feel;
        }

        public String getEatTime() {
            return eat_time;
        }

        public double getLatitude() {
            return latitude;
        }

        public double getLongitude() {
            return longitude;
        }
    }
}