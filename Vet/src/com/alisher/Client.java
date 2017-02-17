package com.alisher;

import java.util.ArrayList;

/**
 * Created by hackeru on 15/02/2017.
 */
public class Client {

    private static int counter;

    private  int id;
    private String name;
    private String phone;
    private boolean ads;
    private ArrayList<Animal> pets;

    public Client(String name, String phone){
        this.name = name;
        this.phone = phone;
        ads = true;
        pets = new ArrayList<>();
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ", " + id;
    }

    public boolean isAds() {
        return ads;
    }

    public void setAds(boolean ads) {
        this.ads = ads;
    }

    public void addNewPet(Animal pet) {
        pets.add(pet);
    }

    public ArrayList<Animal> getPets() {
        return pets;
    }

    public String getPhone() {
        return phone;
    }

    public void sendSMS (String sms){
        System.out.println("Dear " + name + sms + "\n Best regards");
    }
}
