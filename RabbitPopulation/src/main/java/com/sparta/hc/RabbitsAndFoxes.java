package com.sparta.hc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RabbitsAndFoxes implements Animal {

    int months = 0;
    protected int femaleCount = 1;
    protected int maleCount = 1;
    private Random random = new Random();
    private String[] gender = {"Male", "Female"};
    protected List<RabbitsAndFoxes> rabbits;
    private List<RabbitsAndFoxes> deadRabbits;
    protected List<RabbitsAndFoxes> newRabbits = new ArrayList<>();
    protected List<RabbitsAndFoxes> foxes;
    protected List<RabbitsAndFoxes> newFoxes = new ArrayList<>();

    public RabbitsAndFoxes(){

    }

    public RabbitsAndFoxes(String[] gender, int months){
        this.gender = gender;
        this.months = months;
    }


    @Override
    public void populateLists() {

        rabbits = new ArrayList<>();
        rabbits.add(new RabbitsAndFoxes(new String[]{"Male"}, 0));
        rabbits.add(new RabbitsAndFoxes(new String[]{"Female"}, 0));

        foxes = new ArrayList<>();
        foxes.add(new RabbitsAndFoxes(new String[]{"Male"}, 0));
        foxes.add(new RabbitsAndFoxes(new String[]{"Female"}, 0));
    }

    @Override
    public int getMonths() {
        return months;
    }

    @Override
    public String getGender() {
        return Arrays.toString(gender);
    }

    @Override
    public boolean isMature() {
        return getMonths() >= 3;
    }

    @Override
    public boolean breed(int time) {
        return time >= 3;
    }

    @Override
    public boolean incrementMonths() {
        return months++ > 60;
    }

    @Override
    public void giveBirth() {
        for (RabbitsAndFoxes rabbit : rabbits){
            if (rabbit.isMature() && rabbit.getGender().equals("Female")) {
                int babyRabbit = random.nextInt(14);
                newBabies(babyRabbit);
            }
        }
    }

    @Override
    public int incrementRabbitAge() {
        List<RabbitsAndFoxes> deadRabbits = new ArrayList<>();
        for (RabbitsAndFoxes rabbit : rabbits) {
            if (rabbit.incrementMonths()){
                deadRabbits.add(rabbit);
                if (rabbit.getGender().equals("Male")){
                    maleCount--;
                }
                else {
                    femaleCount--;
                }
            }
        }
        rabbits.removeAll(deadRabbits);
        return deadRabbits.size();
    }

    @Override
    public int feed() {
        int foxMeal = 0;


        int noOfMeals = random.nextInt(20);
        noOfMeals = eatFood(noOfMeals);
        foxMeal += noOfMeals;

        return foxMeal;
    }

    @Override
    public void incrementFoxAge() {
        for (RabbitsAndFoxes fox : foxes){
            fox.incrementMonths();
        }
    }

    @Override
    public void newBabies(int babyRabbit) {
        for (int i = 0; i < babyRabbit; i++){
            int select = random.nextInt(gender.length);
            RabbitsAndFoxes newRabbit = new RabbitsAndFoxes();
            newRabbits.add(newRabbit);

            if (newRabbit.getGender().equals("Male")){
                maleCount++;
            }
            else {
                femaleCount++;
            }
        }

    }

    @Override
    public void foxBreeding() {
        for (RabbitsAndFoxes fox : foxes) {
            if (fox.breed(months)) {
                int countBabies = random.nextInt(10);

                for (int i = 0; i < countBabies; i++) {
                    RabbitsAndFoxes newFox = new RabbitsAndFoxes();
                    newFoxes.add(newFox);
                }
            }
        }
    }

    @Override
    public boolean foxMale() {
        for (RabbitsAndFoxes fox : foxes) {
            if (fox.getGender().equals("Male")){
                return true;
            }
        }
        return false;
    }

    @Override
    public int eatFood(int noOfMeals) {
        if(noOfMeals>rabbits.size()){
            noOfMeals=rabbits.size();
        }
        for (int i = 0; i < noOfMeals; i++) {
            int food = rabbits.size();
            if (rabbits.get(food-1).getGender().equals("Male")) {
                maleCount--;
            }
            else {
                femaleCount--;
            }
            rabbits.remove(food-1);
        }
        return noOfMeals;
    }

}
