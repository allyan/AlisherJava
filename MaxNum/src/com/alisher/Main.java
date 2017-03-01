package com.alisher;

public class Main {


    public static void main(String[] args) {

        int[] arr = {90,-30,2,8,-9,27};         // 7 min.

        System.out.println(bestSum(arr));
    }

    public static int bestSum(int[] arr){
        int sum = arr[0];
        int actuallySum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length ; j++) {
                actuallySum += arr[j];
                if(actuallySum > sum){
                    sum = actuallySum;
                }
            }
            actuallySum = 0;
        }
        return sum;
    }
}
