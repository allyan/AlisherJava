package com.alisher;

public class Main {

    public static void main(String[] args) {

        Vet hospital = new Vet();

        hospital.addNewClient(new Client("Alisher", "035598974"));
        hospital.addNewClient(new Client("Yossi", "0542234345"));
        hospital.addNewClient(new Client("Jhon", "0578263857"));
        hospital.addNewClient(new Client("Bob", "0542159781"));

        hospital.addPetTo(new Dog("BigBos"), 1);
        hospital.addPetTo(new Cat("Murka"), 1);
        hospital.addPetTo(new Dog("Buldog"),2);
        hospital.addPetTo(new Snake("Snoose"), 3);
        hospital.addPetTo(new Cat("Bolt"), 3);
        hospital.addPetTo(new Snake("Wolly"), 4);

//        hospital.printClients();

        hospital.setAds(2,false);

        hospital.sendAd("Save 50% for Next pets");  // message: "5% off" send to Maayan

        hospital.hospitalizedAnimal(4);// hopitalize the animal find owner.
        hospital.hospitalizedAnimal(3);// hopitalize the animal find owner.
        hospital.hospitalizedAnimal(2);// hopitalize the animal find owner.
        hospital.hospitalizedAnimal(1);// hopitalize the animal find owner.
        hospital.hospitalizedAnimal(5);// hopitalize the animal find owner.
        hospital.hospitalizedAnimal(6);// hopitalize the animal find owner.

//        hospital.hospitalizedAnimal(7);// hopitalize the animal find owner.
//        hospital.hospitalizedAnimal(1);// hopitalize the animal find owner.
//
//        System.out.println("");
//
        hospital.helthyAnimal(2);
        hospital.helthyAnimal(3);

        hospital.helthyAnimal(2);
//
//
//        hospital.hospitalizedAnimal(4);// hopitalize the animal find owner.
////
//
        hospital.vaccinDogs("Come to vaciin your dog!");

//        hospital.printBeds();
        System.out.println("Now in Hospital : " + hospital.getHospitalizeAnimals());


    }
}