package com.alisher;


public class Animal {
    private static int counter;
    private  int id;
    private String name;

    public Animal(String name) {
        id = ++counter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " id: " + id;
    }
}
