package com.alisher;

/**
 * Created by Allyan on 12/02/2017.
 */
public class Cage {
    private Animal[] animals;
    private boolean aquatic;
    private boolean predator;
    private int index;
    private static final int MAX_CAPACITY = 5;


    public Cage(boolean aquatic) {
        this.aquatic = aquatic;
        animals = new Animal[MAX_CAPACITY];  //animals = {"Lion", false, true}
    }

    public void printCage(){
        System.out.print("Cage aquatic : " + aquatic + " , predator : " + predator + " [");
        for(int i = 0; i<index; i++){
            System.out.print(animals[i].getName());
            if(i<index - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public String firstAnimal(){
       return animals[0].getName();
    }

    public boolean isFull(){
        return index == MAX_CAPACITY;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public void addAnimalToCage(Animal animal){
        if(index == 0){
            predator = animal.isPredator();
        }
        animals[index++] = animal;
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public boolean isPredator() {
        return predator;
    }

    public void setPredator(boolean predator) {
        this.predator = predator;
    }
}
