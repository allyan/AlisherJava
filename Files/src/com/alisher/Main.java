package com.alisher;

import java.awt.*;
import java.io.*;


public class Main {

    public static void main(String[] args) {

//        createFile();
//        writeToFile(" opaca tratata ! ");
        //readFromFile();
//        copyFile();
        //deleteFile();
//        appendToFile();

//        copyAllFiles("C:\\Users\\Allyan\\Desktop\\myFiles");
//        deleteAllFiles("C:\\Users\\Allyan\\Desktop\\myFiles");
        cutAllFilesFromTo("C:\\Users\\Allyan\\Desktop\\myFiles", "C:\\Users\\Allyan\\Desktop\\myFiles\\CopyMyFiles");
//          devideFile("C:\\Users\\Allyan\\Desktop\\myFiles\\nice.jpg");
//          sumDevidedFile("C:\\Users\\Allyan\\Desktop\\myFiles\\nice1.jpg","C:\\Users\\Allyan\\Desktop\\myFiles\\nice2.jpg");


        /*
        File folder = new File("C:\\Users\\hackeru\\Desktop\\privateFile.txt");
        File newFile = new File("C:\\Users\\hackeru\\Desktop\\privateFile.jpg");
        folder.renameTo(newFile);
        //String[] arr = folder.list();
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        */
    }

    private static void sumDevidedFile(String firstPart, String secondPart){
        File new1 = new File("C:\\Users\\Allyan\\Desktop\\myFiles\\nice1.jpg");
        File new2 = new File("C:\\Users\\Allyan\\Desktop\\myFiles\\nice2.jpg");
        File newOldFile = new File("C:\\Users\\Allyan\\Desktop\\myFiles\\niceNew.jpg");

        try {
            InputStream in1 = new FileInputStream(firstPart);
            InputStream in2 = new FileInputStream(secondPart);
            OutputStream out = new FileOutputStream(newOldFile);
            byte[] buffer1 = new byte[1024];
            byte[] buffer2 = new byte[1024];
            int actuallyRead;
            int counter = 0;
            while ((actuallyRead = in1.read(buffer1)) > 0 || (actuallyRead = in2.read(buffer2)) > 0){
                    if(counter%2 == 0){
                        out.write(buffer1, 0, actuallyRead);
                    }
                    else
                        out.write(buffer2, 0, actuallyRead);
                    counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void devideFile(String fileForDevide) {
        File file = new File(fileForDevide);
        File new1 = new File("C:\\Users\\Allyan\\Desktop\\myFiles\\nice1.jpg");
        File new2 = new File("C:\\Users\\Allyan\\Desktop\\myFiles\\nice2.jpg");
        try {
            InputStream in = new FileInputStream(fileForDevide);
            OutputStream out1 = new FileOutputStream(new1);
            OutputStream out2 = new FileOutputStream(new2);
            byte[] buffer1 = new byte[1024];
            byte[] buffer2 = new byte[1024];
            int actuallyRead;
            int counter = 0;
            while ((actuallyRead = in.read(buffer1)) > 0 || (actuallyRead = in.read(buffer2)) > 0){
                if(counter%2 == 0){
                    out1.write(buffer1, 0, actuallyRead);
                }
                else {
                    out2.write(buffer2, 0, actuallyRead);
                }
                counter++;
            }
            System.out.println(counter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void cutAllFilesFromTo(String fromAddress, String toAddress){
        File copyFrom = new File(fromAddress);
        String[] allFiles = copyFrom.list();
        File copyTo = new File(toAddress);
        int j = 1;
        try {
            if(copyTo.mkdir()){
                for (int i = 0; i < allFiles.length ; i++) {
                    FileInputStream in = new FileInputStream(copyFrom + "\\" + allFiles[i]);
                    FileOutputStream out = new FileOutputStream(copyTo + "\\" + allFiles[i].substring(0,allFiles[i].indexOf('.')) + " - copied (" + (i+1) + ")" + allFiles[i].substring(allFiles[i].indexOf('.')));
                    File forDelete = new File(fromAddress + "\\" + allFiles[i]);
                    byte[] buffer = new byte[1024];
                    int actuallyRead;
                    while ((actuallyRead = in.read(buffer)) > 0){

                        out.write(buffer,0,actuallyRead);
                    }
                    in.close();
                    out.close();
                    forDelete.delete();
                }
            }
            else {
                System.out.println("This folder are exist !");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void deleteAllFiles(String address, String absoluteAddress){
        File file = new File(absoluteAddress);
        String[] myFiles = file.list();
        for (int i = 0; i < myFiles.length ; i++) {
//            System.out.println(myFiles[i]);
            (new File(absoluteAddress + "\\" + myFiles[i])).delete();
        }
    }

    private static void copyAllFiles(String absouteAddress){
        File copyFrom = new File(absouteAddress);
        String[] allFiles = copyFrom.list();
        File copyTo = new File(absouteAddress + "\\myFilesCopy");
        try {
            copyTo.mkdir();
            for (int i = 0; i < allFiles.length ; i++) {
                FileInputStream in = new FileInputStream(copyFrom + "\\" + allFiles[i]);
                FileOutputStream out = new FileOutputStream(copyTo + "\\" + allFiles[i]);
                byte[] buffer = new byte[1024];
                int actuallyRead;
                while ((actuallyRead = in.read(buffer)) > 0){
                    out.write(buffer,0,actuallyRead);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendToFile(){
        File file = new File("C:\\Users\\Allyan\\Desktop\\password.txt");
        try {
            FileOutputStream out = new FileOutputStream(file, true);
            out.write("maayan politzer".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void deleteFile(){
        File f = new File("C:\\Users\\Allyan\\Desktop\\bahamas.jpg");
        f.delete();
    }

    private static void copyFile(){
        File original = new File("C:\\Users\\Allyan\\Desktop\\myFiles\\237A0124.jpg");
        File newFile = new File("C:\\Users\\Allyan\\Desktop\\myFiles\\newImage_nice.jpg");
        try {
            FileOutputStream out = new FileOutputStream(newFile);
            FileInputStream in = new FileInputStream(original);
            byte[] buffer = new byte[1024];
            int actuallyRead;
            while((actuallyRead = in.read(buffer)) > 0){
                out.write(buffer, 0, actuallyRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void readFromFile(){
        try {
            InputStream in = new FileInputStream("myGreatFile.txt");
            byte[] buffer = new byte[1024];
            int actuallyRead = in.read(buffer);
            String str = new String(buffer, 0, actuallyRead);
            System.out.println(str);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String content){
        byte[] contentInBytes = content.getBytes();
        try {
            OutputStream out = new FileOutputStream("C:\\Users\\Allyan\\Desktop\\myGreatFile.txt",true);
            out.write(contentInBytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile() {
        File myFile = new File("C:\\Users\\Allyan\\Desktop\\myGreatFile.txt");
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}