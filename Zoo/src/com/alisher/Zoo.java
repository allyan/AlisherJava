package com.alisher;

/**
 * Created by Allyan on 12/02/2017.
 */
public class Zoo {
    private String manager;
    private String address;
    private int landCage;
    private int aguaCage;
    private Cage[] cages;

    public Zoo(String manager, String address, int landCage, int aquaCage) {
        this.manager = manager;
        this.address = address;
        cages = new Cage[landCage + aquaCage];

        for (int i = 0; i < cages.length ; i++) {
            if (i < landCage) {
                cages[i] = new Cage(false);
            }else{
                cages[i] = new Cage(true);
            }
        }

    }



    public  boolean insertAnimal(Animal animal){
        for(int i = 0; i<cages.length; i++){

            if(animal.isAquatic() == cages[i].isAquatic() && !cages[i].isFull() && (cages[i].isEmpty() || (!cages[i].isPredator() && !animal.isPredator()) || (cages[i].isPredator() && animal.isPredator() && cages[i].firstAnimal().equals(animal.getName())))){
                cages[i].addAnimalToCage(animal);
                return true;
            }
        }
        System.out.println("No place for : " + animal.getName());
        return false;
    }

    public void printCages(){
        for(int i = 0; i<cages.length; i++){
            cages[i].printCage();
    }



    }
}
