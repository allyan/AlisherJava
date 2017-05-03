package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        Socket socket = null;
        try {

            socket = new Socket("10.0.7.6", 10181);
            OutputStream out = socket.getOutputStream();
            out.write("Alisher".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
