package com.alisher;



public class DynamicArray {

    private String[] arr;
    private int counter;
    private static int grow = 2;

    public DynamicArray(){  // default constructor
        arr = new String[10];
        counter = 0;
    }

    public void remove (String str){
        for(int i =0; i < arr.length; i++){
            if(arr[i] == str){
                arr[i] = null;
                for(int j = i; j < arr.length -1; j++){
                    arr[j] = arr[j+1];
                }
                counter--;
            }
        }
    }

    public void set (int index, String str){
        if(index >= 0 && index < counter){
            arr[index] = str;
        }
    }

    public int indexOf (String str){
        for(int i =0; i < arr.length; i++){
            if(arr[i] == str){
                return i;
            }
        }
        return  -1;
    }

    public boolean contains (String str){
        for(int i =0; i < arr.length; i++){
            if(arr[i] == str){
                return true;
            }
        }
       return false;
    }

    public void clear(){
        for(int i = 0; i < arr.length; i++){
            arr[i] = null;
            counter--;
        }
    }

    public void add(int index, String str){
        counter++;
        if(index < counter && index >= 0){
            for(int i = counter; i > index; i--){
                arr[i] = arr[i - 1];
                if(index == i - 1){
                    arr[index] = str;
                }
            }
        }
        if (index >= counter){
            System.out.println("Index out of Array");
        }
    }



    public void add(String str){
        if (counter == arr.length){
            makeRoom();
        }
        arr[counter++] = str;
    }



    private void makeRoom(){
        String[] newArr = new String[grow * arr.length];
        for (int i = 0; i < arr.length; i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int size(){
        return counter;
    }

    public String get(int index){
        if (index >= 0 && index < counter){
            return arr[index];
        }
        return null;
    }


    public void print(){
        System.out.print("[");
        for (int i = 0; i < counter; i++){
            System.out.print(arr[i]);
            if (i < counter - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}