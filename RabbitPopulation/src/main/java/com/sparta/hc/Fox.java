//package com.sparta.hc;
//
//public class Fox {
//
//    private int months = 0;
//    private String gender;
//
//    public Fox() {
//
//    }
//
//    public Fox(String gender, int months){
//        this.gender = gender;
//        this.months = months;
//    }
//
//    @Override
//    public int getMonths() {
//        return months;
//    }
//
//    @Override
//    public void populateLists() {
//
//    }
//
//    @Override
//    public String getGender() {
//        return gender;
//    }
//
//
//
//    @Override
//    public boolean isMature() {
//        return getMonths() >= 3;
//    }
//
//    @Override
//    public boolean breed(int time){
//        if (months < 10 || getGender().equals("Female")){
//            return false;
//        }
//
//        return time >= 12;
//
//    }
//
//    @Override
//    public void giveBirth() {
//
//    }
//
//    @Override
//    public void newBabies(int babyRabbit) {
//
//    }
//
//    @Override
//    public int incrementRabbitAge() {
//        return 0;
//    }
//
//    @Override
//    public void incrementFoxAge() {
//
//    }
//
//    @Override
//    public boolean foxMale() {
//        return false;
//    }
//
//    @Override
//    public void foxBreeding() {
//
//    }
//
//    @Override
//    public int feed() {
//        return 0;
//    }
//
//    @Override
//    public void eatFood(int noOfMeals) {
//
//    }
//
//    public boolean incrementMonths() {
//        months++;
//        return false;
//    }
//}
