package com.sparta.hc;


public class RabbitManager extends RabbitsAndFoxes {



    void simulation(final int MAXIMUM_TIME, final int MAX_POPULATION) {

        populateLists();

        while (months < MAXIMUM_TIME && rabbits.size() < MAX_POPULATION) {
            months++;

            int food = 0;

            if (foxMale()) {
                foxBreeding();
            }

            if (maleCount >= 1) {
                giveBirth();
            }

            if (months >= 13) {
                incrementFoxAge();
            }

            if (months >= 13) {
                food = feed();
            }

            int deadRabbits = incrementRabbitAge();


            foxes.addAll(newFoxes);
            rabbits.addAll(newRabbits);

            System.out.println("########################################################");
            System.out.println(newRabbits.size() + " rabbits born in month " + months);
            System.out.println(food + " rabbits eaten by foxes in month " + months);
            System.out.println(deadRabbits + " rabbit deaths in month " + months);
            System.out.println(newFoxes.size() + " foxes born in month " + months);
            System.out.println("There are " + rabbits.size() + " rabbits after " + months + " months");
            System.out.println("There are " + foxes.size() + " foxes after " + months + " months");
            System.out.println(" ");

            if (months == MAXIMUM_TIME) {
                System.out.println("The end has been reached");
                System.out.println("Ended with a population of " + rabbits.size() + " in " + months + " months");
            }
            else if (rabbits.size() > MAX_POPULATION) {
                System.out.println("The maximum population of rabbits has been reached");
                System.out.println("Ended with a population of " + rabbits.size() + " in "+ months + " months");
            }
        }
    }
}
