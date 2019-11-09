package com.sparta.hc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RabbitManager extends Rabbit {

    /*
    Create a female rabbit list
    Create a male rabbit list
    Add them together in the 'rabbits' list

    Create a child rabbit list and add it to the 'rabbits' list
    Tidy up the code after finish
    */


    private final int MAX_POPULATION;
    private int months = 0;
    private int seconds = 1000;
    private int counter = 0;
    private int age = getMonths();
    private int femaleCount = 1;
    private int maleCount = 1;
    private Random random;
    private String[] gender = {"Male", "Female"};
    private List<Rabbit> rabbits = new ArrayList<>();
    private List<Rabbit> deadRabbits = new ArrayList<>();
    private List<Rabbit> newRabbits = new ArrayList<>();
    private List<Rabbit> femaleRabbits = new ArrayList<>();
    private List<Rabbit> maleRabbits = new ArrayList<>();

    public RabbitManager() {
        MAX_POPULATION = 30000000;
        random = new Random();
    }

    public RabbitManager(int maxPopulation){
        MAX_POPULATION = maxPopulation;
        random = new Random();
    }

    public void simulation() {


        Rabbit maleRabbit = new Rabbit("Male", months);
        counter++;
        Rabbit femaleRabbit = new Rabbit("Female", months);
        counter++;
        maleRabbits.add(maleRabbit);
        femaleRabbits.add(femaleRabbit);

        while (rabbits.size() < 500000000) {

            try {

                for (Rabbit female : femaleRabbits){
                    for (Rabbit male : maleRabbits){

                        if (female.incrementAge()) {
                            deadRabbits.add(female);
                            System.out.println("Rabbit " + counter + " has died");
                            counter--;
                        }

                        if (male.incrementAge()) {
                            deadRabbits.add(male);
                            System.out.println("Rabbit " + counter + " has died");
                            counter--;
                        }

                        if (female.isAlive() && female.isMature() && female.getGender().equals("Female")) {
                            System.out.println("Female rabbit available: " + female.available());
                        }

                        if (male.isAlive() && male.isMature() && male.available() && male.getGender().equals("Male") && female.available()){
                            female.breed();
                            int select = random.nextInt(gender.length);
                            Rabbit babyRabbit = new Rabbit(gender[select], 0);

                            System.out.println("Rabbit gave birth: " + female.gaveBirth());
                            newRabbits.add(babyRabbit);
                            counter++;

                            if (babyRabbit.getGender().equals("Male")){
                                maleRabbits.add(babyRabbit);
                                maleCount++;
                            }
                            else {
                                femaleRabbits.add(babyRabbit);
                                femaleCount++;
                            }
                        }
                    }

                }


                rabbits.addAll(newRabbits);
                rabbits.addAll(maleRabbits);
                rabbits.addAll(femaleRabbits);
                rabbits.remove(deadRabbits);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
