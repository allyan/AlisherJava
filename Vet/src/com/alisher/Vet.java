package com.alisher;

import java.util.ArrayList;
import java.util.Date;


public class Vet {

    private ArrayList<Client> clients;
    private ArrayList<Client> clientsWithoutAds;
    private static int beds = 8;
    private int counter = beds;
    private ArrayList<Animal> hospitalizeAnimals;


    public ArrayList<Animal> getHospitalizeAnimals() {
        return hospitalizeAnimals;
    }

    public Vet(){
        clients = new ArrayList<>();
        hospitalizeAnimals = new ArrayList<>();
    }

    public void addNewClient(Client newClient){
        clients.add(newClient);
    }

    public void printClients(){
        System.out.println(clients);
    }

    public void sendAd(String smsAds){
        clientsWithoutAds = new ArrayList<>();
        for(int i =0; i<clients.size(); i++){
            if(clients.get(i).isAds()){
                System.out.println("Message : '" + smsAds + "' send to " + clients.get(i).getName());
            }
            else {
                clientsWithoutAds.add(clients.get(i));
            }
        }
        System.out.println("message did not send to this clients : " + clientsWithoutAds);
    }

    public void setAds(int clientId, boolean ads){
        clients.get(clientId -1).setAds(ads);
    }

    public void hospitalizedAnimal(int petId){

        for(int i = 0; i<clients.size(); i++){
            for(int j = 0; j<clients.get(i).getPets().size(); j++)
            if(clients.get(i).getPets().get(j).getId() == petId && counter > 0){
                lessFreeBeds();
                hospitalizeAnimals.add(clients.get(i).getPets().get(j));
                System.out.println("Hospitalize pet - " + "id:" + petId + ", name: " + clients.get(i).getPets().get(j).getName() + " and found Owner " + clients.get(i).getName() + ", #TEL : " + clients.get(i).getPhone());
            }
        }
        System.out.println("Remain " + counter + " beds");
            if(counter == 0){
                System.out.println("No more free beds !");
            }
    }

    public void helthyAnimal(int byNumOfBed){
        if(byNumOfBed < hospitalizeAnimals.size() && byNumOfBed > 0){
            moreFreeBeds();
            System.out.println(hospitalizeAnimals.get(byNumOfBed-1).getName() + " Was healthy ! "+"Remain " + counter + " beds");
            hospitalizeAnimals.remove(byNumOfBed-1);
        }
        else {
            System.out.println("Your number of Bed is wrong !");
        }
    }

    public int lessFreeBeds(){
        counter--;
        return counter;
    }

    public int moreFreeBeds(){
        counter++;
        return counter;
    }


    public void addPetTo(Animal animal, int clientId){
       for(int i = 0; i<clients.size(); i++){
           if(clients.get(i).getId() == clientId){
               clients.get(i).getPets().add(animal);
             //  System.out.println(animal.getName() + " was successful added to " + clients.get(i).getName());
           }
       }
    }

    public void vaccinDogs(String messageToAll){
        for(Client c : clients){
            for(Animal a : c.getPets()){
                if(a instanceof Dog)
                    System.out.println(" Dear " + c.getName() + ", please " + messageToAll);
            }
        }

    }




}
