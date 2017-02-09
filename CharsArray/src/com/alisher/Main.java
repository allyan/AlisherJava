package com.alisher;

public class Main {

    public static void main(String[] args) {

        char[] chars = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'};
        MyString myString = new MyString(chars);
        //System.out.println(myString.length());    // 11;

        myString.print();   // Hello World

//        String cd = new String(chars);
//        System.out.println(cd);

  //      System.out.println(myString.indexOf('l'));  // 8;
//
//        System.out.println(myString.sameCharsCount('l'));   // 3
//
//        printArr(myString.indexesOf('o'));
//
//        System.out.println(myString.charAt(4)); // 'o'
//
//        System.out.println(myString.isEmpty()); // false
//
//        System.out.println(myString.contains('y'));     // false

//        MyString x = myString.subString(8,11);
//        x.print();   // World

        // HOME WORK:

//        MyString x2 = myString.replace('l', 'H');
//        x2.print();
//
//        MyString x3 = myString.subString(0,4);
//        x3.print();
//
//        MyString x4 = myString.subString(5,7);
//        x4.print();
//
//        MyString x5 = myString.subString(8,11);
//        x5.print();

        ///////////////////// hard!!    /////////////////////////

        MyString[] arrX = myString.split('o');
           for (int i = 0; i < arrX.length; i++){
            arrX[i].print();                                  // arrX = {Hell,  W,  rld};

        }



        String s1 = new String(chars);
      //  System.out.println(s1);

        String s2 = s1.replace('o',' ');
        System.out.println(s2);

}





    private static void printArr(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}