package com.alisher;

public class Main {

    private static Car[] cars = new Car[10];

    public static void main(String[] args) {

        Person p1 = new Person("Alex", "051111111", "Tel aviv");
        Person p2 = new Person("Rembo", "0522222222", "Tzur Yitzhak");
        Person p3 = new Person("Alisher", "0522333333", "Holon");
        Person p4 = new Person("Rembo", "0522277777", "Bat yam");
        Person p5 = new Person("Rembo", "0522211111", "Holon");
        Person p6 = new Person("Rembo", "0522244444", "Eilat");
        Person p7 = new Person("Rembo", "0520156222", "Tzur Yitzhak");
        Person p8 = new Person("Rembo", "0522586222", "Haifa");

        Car c1 = new Car("Pink", 3, "suzuky", 1999, p1);

        cars[0] = new Car("Pink", 2, "suzuky", 1999, p1);
        cars[1] = new Car("Green", 3, "Audi", 2007, p2);
        cars[2] = new Car("White", 1, "Ford", 2015, p4);
        cars[3] = new Car("Black", 2, "WolksWagen", 2014, p5);
        cars[4] = new Car("Green", 1, "Audi", 2017, p1);
        cars[5] = new Car("Yellow", 3, "Mercedec", 2017, p3);
        cars[6] = new Car("Red", 3, "BMW", 2005, p6);
        cars[7] = new Car("Blue", 1, "Audi", 2016, p8);
        cars[8] = new Car("Green", 2, "Skoda", 2016, p3);
        cars[9] = new Car("Orange", 4, "Audi", 2015, p7);

        System.out.println(c1.getDetails());

        //c1.getOwner().setName("Moshiko");   // won't work!!!(anti-aliasing);

        //System.out.println(c1.getDetails());

        c1.switchOwner(p3);
        System.out.println(c1.getDetails());
        System.out.println(cars[5].getDetails());

        System.out.println(getReport(1000002, false));

        //System.out.println(Math.max(Math.max(5,6),9));
    }

    private static String getReport(int licensePlate, boolean sendToAddress){
        if(sendToAddress){
            for(int i = 0; i < cars.length; i++){
                if(cars[i].getLicensePlate() == licensePlate){
                    return cars[i].getOwner().getAddress();
                }
            }
        }
        else {
            for(int i = 0; i < cars.length; i++){
                if(cars[i].getLicensePlate() == licensePlate){
                    return cars[i].getOwner().getPhone();
                }
            }
        }
        return "This Car-number not Real";
    }
}