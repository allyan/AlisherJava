package com.alisher;


public class MyString {


    private char[] chars;

    public MyString(char[] letters) {
        chars = letters;
    }

    public int length() {
        return chars.length;
    }


    public MyString replace (char a, char b){
        char[] myChars = new char[chars.length];
        for(int i =0; i< chars.length; i++){
            if (chars[i] == a) {
                myChars[i] = b;
            }
            else {
                myChars[i] = chars[i];
            }
        }
        return  new MyString(myChars);
    }

    public void print() {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }

    public int indexOf(char c) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public int sameCharsCount(char c) {
        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                counter++;
            }
        }
        return counter;
    }

    public int[] indexesOf(char c) {
        int[] arr = new int[sameCharsCount(c)];
        int x = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                arr[x++] = i;
            }
        }
        return arr;
    }

    public char charAt(int index) {
        if (index < 0 || index >= chars.length) {
            return '@';
        } else {
            return chars[index];
        }
    }

    public boolean isEmpty() {
        return chars.length == 0;
        /*
        if (chars.length == 0){
            return true;
        }
        return false;
        */
    }


    public boolean contains(char c) {
        return indexOf(c) != -1;
        /*
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == c){
                return true;
            }
        }
        return false;
        */
    }

    public MyString subString(int number) {
        if (number < 0 || number >= chars.length) {
            return null;
        }
        char[] myChars = new char[chars.length - number];
        for (int i = number; i < chars.length; i++) {
            myChars[i - number] = chars[i];
        }
        return new MyString(myChars);
    }

    public MyString subString(int start, int end) {
        if (start < 0 || start >= end || end > chars.length || end <= start) {
            return null;
        }
        char[] myChars = new char[end - start];
        for (int i = start; i < end; i++) {
            myChars[i - start] = chars[i];
        }
        return new MyString(myChars);
    }


    public MyString[] split(char c){
        int[] indexesOfChar = indexesOf(c);  // [4,7]
        int begin = 0;                       // first Index off char in arr[]
        MyString myString = new MyString(chars); // Hello World
        MyString[] arr = new MyString[indexesOfChar.length +1]; // [ , , ]  //3
        for(int i =0; i < indexesOfChar.length; i++){
            arr[i] = myString.subString(begin, indexesOfChar[i]); // (0,4), (5,7)
            begin = indexesOfChar[i] + 1;
        }
        arr[arr.length -1] = myString.subString(begin);  // arr[2] = , (8,11) // rld
        return arr;
    }
}
