package com.alisher;

public class Main {

    public static void main(String[] args) {



        int[] studentsGradesC = new int[2];          // length=2;

        int k;  // default value of int is 0;


        // java array length CANNOT BE CHANGED!!!

        //System.out.println(studentsGradesA[5]);       // get array cell value by index.
        //System.out.println(studentsGradesA.length);   // get the array length (how many cells).
        //studentsGradesA[3] = 67;                      // change cell value.


        //printArray(studentsGradesA);

        //printArrayWithFactor(studentsGradesA, 2);

        //int myAverage = average(studentsGradesA);
        //System.out.println(myAverage);

        //int[] tempArr = createArr(4,32);
        //printArray(tempArr);

        //int times = howManyTimesInArr(studentsGradesA, 90);
        //System.out.println(times);

        //int max = getMax(studentsGradesA);
        //System.out.println(max);

        int[] studentsGradesB = new int[]{40, 50, 49}; // length=3;
        /*
        boolean b = isNumberInArray(studentsGradesB, 60);
        System.out.println(b);
        */
        /*
        boolean order = isOrdered(studentsGradesB);
        System.out.println(order);
        */

        /*
        boolean c = isLastNumberPositive(studentsGradesB);
        System.out.println(c);
        */

        //HOMEWORK:
        // int sum = sumOfOddsIndex(studentsGradesA);
        // System.out.println(sum);

        // int[] reverse = flipArray(studentsGradesA);
        // printArray(reverse);

        //int[] largeArr = doubleMyArray(studentsGradesA);
        //printArray(largeArr);

        //int[] largerArr = nMyArray(studentsGradesB, 2);
        //printArray(largerArr);

        int[] studentsGradesA = {1, 2, 3, 4, 5};   // length=5;

        int[] sort = evenOdd(studentsGradesA);
        printArray(sort);

        //System.out.println(Math.max(14,15));

    }

    public static int[] evenOdd(int[] nums) {
        int i, j , temp;

        for (i = 0;  i < nums.length;  i++) {
            if (nums[i] % 2 == 1) {
                for (j = i;  j < nums.length;  j++) {
                    if (nums[j] % 2 == 0) {
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }return nums;
    }

    public static int[] nMyArray(int[] arr, int z){
        int x = 0;
        int n = z;
        int[] array = new int[arr.length*n];
        for(int i = 0; i < arr.length; i++){
            for(int j = x; j < array.length; j++){
                array[j] = arr[i];
                if(j == n-1){
                    j = array.length;
                }
            } x += z;
              n += z;
        }
        return array;
    }


    public static int[] doubleMyArray(int[] arr){
        int x = 0;
        int[] array = new int[arr.length*2];
        for(int i = 0; i<arr.length; i++) {
            array[x] = arr[i];
            array[x+1] = arr[i];
            x+=2;
        }
        return array;
    }

    public  static int[] flipArray(int[] arr){
        int z = 1;
        int[] array = new int[arr.length];
        for (int x = 0; x < arr.length; x++){
            array[x] = arr[arr.length - z]; // 0-5.1-4.2-3.3-2.4-1.5-0
            z++;
        }
        return array;
    }

    public static int sumOfOddsIndex(int[] arr){
        int summa = 0;
        for(int i = 1; i<arr.length; i+=2){
           summa += arr[i];
        }
        return summa;
    }

    public static boolean isLastNumberPositive(int[] arr){
        return arr[arr.length - 1] > 0;
        /*
        if (arr[arr.length - 1] > 0){
            return true;
        }
        return false;
        */
    }

    public static boolean isOrdered(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumberInArray(int[] arr, int number){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                return true;
            }
        }
        return false;

        //return howManyTimesInArr(arr, number) > 0;    // NOT ALWAYS BETTER!!!!!
    }

    public static int getMax(int[] maayan){
        if (maayan.length > 0) {
            int max = maayan[0];
            for (int i = 1; i < maayan.length; i++) {
                if (maayan[i] > max) {
                    max = maayan[i];
                }
            }
            return max;
        }else{
            return -1;
        }
    }

    public static int howManyTimesInArr(int[] arr, int number){
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == number){
                counter++;
            }
        }
        return counter;
    }

    public static int[] createArr(int length, int value){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++){
            arr[i] = value;
        }
        return arr;
    }

    public static int average(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void printArrayWithFactor(int[] arr, int factor){
        for (int i = 0; i < arr.length; i++){
            int newGrade = arr[i] + factor;
            if (newGrade > 100){
                System.out.println(100);
            }else {
                System.out.println(newGrade);
            }
        }
    }



}