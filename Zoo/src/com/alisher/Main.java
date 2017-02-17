package com.alisher;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();

        Zoo zoo = new Zoo("Alisher", "Holon", 5,4);

        Animal[] animals = {
                new Animal("Lion",false,true),
                new Animal("Wolf",false,true),
                new Animal("Sheep",false,false),
                new Animal("Fish",true,false),
                new Animal("Shark",true,true),
                new Animal("Giraffe",false,false),
                new Animal("Cow",false,false),
                new Animal("Piranne",true,true),
                new Animal("Tiger",false,true),
        };

        for(int i = 0; i<45; i++){
            zoo.insertAnimal(animals[random.nextInt(animals.length)]);
        }

//        for(Animal i: animals){
//            System.out.print(i.getName() + "\t");
//        }
//        System.out.println();

        zoo.printCages();
    }
}
