package com.alisher;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static File file = new File("users.txt");


    public static void main(String[] args) {




        try {
            file.createNewFile();
            while (command()){
                System.out.println("Enter your name : ");
                FileInputStream in = new FileInputStream(file);
                FileOutputStream out = new FileOutputStream(file, true);
                String Uname = scanner.nextLine();
                System.out.println("Enter your password : ");
                String password = scanner.nextLine();

                if(userExist(Uname,password)){
                    continue;
                }
                else
                    System.out.println(Uname + " Welcome to Hell");
                out.write("User : ".getBytes());
                out.write(Uname.getBytes());
                out.write("\t".getBytes());

                out.write("Password : ".getBytes());
                out.write(password.getBytes());
                out.write("\n".getBytes());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static boolean command(){
        System.out.println("Please enter : Add or Close");
        String command = scanner.nextLine();
        if(command.equalsIgnoreCase("add")){
            return true;
        }
        else
            System.out.println("Are you like to see List of Users ? : Yes or No");
            String action = scanner.nextLine();
            if(action.equalsIgnoreCase("yes")){
                userList();
                return false;
            }
            else
            System.out.println("Good bay !!!");
            return false;
    }

    private static void userList(){
        try {
            FileInputStream in = new FileInputStream(file);
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

    private static boolean userExist(String name, String password){
        try {
            FileInputStream in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null){
                if(line.contains(name) && line.contains(password)){
                    System.out.println("This user exist !!!");
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
