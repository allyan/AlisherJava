package com.alisher;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Random roulleta = new Random();
//
//        int num[] = new int[33];
//
//        for(int i =0; i<100000000; i++){
//            ++num[roulleta.nextInt(33)]; // ++num[5] = 0;
//
//        }
//
//        for(int i=0; i < num.length; i++){
//            System.out.println(i + "\t" + num[i]);
//        }
//
//        int max = num[0];
//        for(int i = 0; i<num.length; i++){
//            if(num[i] > max){
//                max = num[i];
//            }
//        }
//        System.out.println("max times is : "  + max);

//        String names[] = {"alisher", "aliev", "normirzaevich"};
//
//        for(int i = 0; i< names.length; i++){
//            names[i] += " ti ochen krut";
//            System.out.println(names[i]);
//        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please write your name ");
        String string = input.nextLine();
        System.out.println("Your name is " + string);
     }
}
