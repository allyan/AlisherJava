package com.alisher;

import java.util.ArrayList;

public class Main {

    private static ArrayList<Fruit> fruits = new ArrayList<>();



    public static void main(String[] args) {

        fruits.add(new Fruit("Apple", 9.9));
        fruits.add(new Fruit("Pear", 12.9));
        fruits.add(new Fruit("Banana", 10.9));
        fruits.add(new Fruit("Mango", 17.9));
        fruits.add(new Fruit("Melon", 3.9));

        double sum = getTotalPrice(0.8, 2.0, 6.0, 0.2, 0.4);    // vat 17%.
        System.out.println("You need to pay: " + sum + " shekel");

        double taxes = 17;

        double sumWithTaxes = sum + (sum*taxes)/100;
        System.out.println("The Price with Taxes is : " + sumWithTaxes + " shekel");
    }



    public static double getTotalPrice(double applleWeigth, double pearWeight, double bananaWeight, double mangoWeight, double melonWeight){
       double appllePrice =  applleWeigth*fruits.get(0).getPrice();
       double pearPrice =  pearWeight*fruits.get(1).getPrice();
       double bananaPrice =  bananaWeight*fruits.get(2).getPrice();
       double mangoPrice =  mangoWeight*fruits.get(3).getPrice();
       double melonPrice =  melonWeight*fruits.get(4).getPrice();

       double sum = appllePrice + pearPrice + bananaPrice + mangoPrice + melonPrice;
       return sum;
    }


}
