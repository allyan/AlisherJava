package com.alisher;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println(quatient(10,3));     // same as 10/3
        System.out.println(product(10,3));      // same as 10*3
        System.out.println(distance(10,3));     // same as 10-3
        System.out.println(remainder(15, 3));   // same as 10 % 4 ==> 2, modulo
    }

    public static int quatient(int x, int y){       //delenie
        if (y == 0){
            return -1;
        }
        if (y == 1){
            return x;
        }
        int result = 0;
        for (int i = y; i <= x; i += y){
            result++;
        }
        return result;
    }

    public static int product(int x, int y){        //umnojenie
        if (x == 0 || y == 0){
            return 0;
        }
        int result = 0;
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        for (int i = 0; i < small; i++){
            result += large;
        }
        return result;
    }

    public static int distance(int x, int y){       //minus
        if (x == y){
            return 0;
        }
        int myDistance = 0;
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        while (small + myDistance < large){
            myDistance++;
        }
        return myDistance;
    }

    public  static int remainder(int x, int y){
        int remainder = 0;
        remainder = distance(x,quatient(x,y)*y);
        return remainder;
    }

}

