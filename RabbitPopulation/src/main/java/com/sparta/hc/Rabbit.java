package com.sparta.hc;

import java.util.ArrayList;
import java.util.List;

public class Rabbit implements Animal {

    private int months = 0;
    private String gender;

    public Rabbit(){

    }

    public Rabbit(String gender, int months){
        this.gender = gender;
        this.months = months;
    }


    @Override
    public int setMonths(int months) {
        this.months = months;
        return months;
    }

    @Override
    public int getMonths() {
        return months;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String setGender(String gender) {
        this.gender = gender;
        return gender;
    }

    @Override
    public boolean isAlive() {
        return getMonths() < 60;
    }

    @Override
    public boolean available() {

        if (getGender().equals("Male") && isAlive()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean pregnant() {

        if(getGender().equals("Female") && available() && isAlive() && isMature()) {
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public boolean breed() {
        return isMature() && available();
    }

    @Override
    public boolean isMature() {
        return getMonths() >= 3;
    }

    @Override
    public boolean gaveBirth() {
        return true;
    }

    public boolean incrementAge() {
        return ++months > 60;
    }
}
