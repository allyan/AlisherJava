package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by hackeru on 03/05/2017.
 */
public class ClientThread extends Thread{

    private Socket client;

    public ClientThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {
            InputStream in = client.getInputStream();
            byte[] buffer = new byte[1024];
            int length;
            StringBuilder sb = new StringBuilder();
            while ((length = in.read(buffer)) != -1){
                sb.append(new String(buffer, 0, length));
            }
            System.out.println("welcome : " + sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
