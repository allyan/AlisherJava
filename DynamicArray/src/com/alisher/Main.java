package com.alisher;

import java.sql.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        DynamicArray da = new DynamicArray();
        da.add("Maayan");
        da.add("Ofir");
        da.add("Shmulik");
        da.add("Moshe");

        da.print();

//        System.out.println(da.get(1));

//        System.out.println(da.size());


        // HOME WORK:
        da.add(0, "wow");
        da.add(2, "Boogy");
        da.print();
         // TODO: 05/02/2017 add "wow" to index 1, move all right...

//        da.clear();
//        da.print();
//        // TODO: 05/02/2017 clear all data.
//
//        boolean b = da.contains("Ofir");
//        System.out.println(b);
//
//        int index = da.indexOf("Moshe");
//        System.out.println("Index of this String is : " +index);
//        System.out.println("Length of Array is : " + da.size());
////
//        da.set(4, "WIIIIII");
//        da.print();
//        System.out.println("Length of Array is : " + da.size());
//
        da.remove("Maayan");
        da.add("alisher");
        da.add("Moshe");
        da.add("alisher");
        System.out.println(Arrays.toString(da));
//        da.print();
//        da.remove("Moshe");
//        da.print();
//        System.out.println(da.indexOf("Boogy"));
    }
}

