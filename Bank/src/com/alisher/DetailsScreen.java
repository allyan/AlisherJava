package com.alisher;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class DetailsScreen{
    static boolean answer;
    private static ArrayList<User> arr = new ArrayList<>();
    private static User user;
    private static int accountNumber;
    private static String userName;
    private static TextField accountN;

    public static ArrayList<User> getArr() {
        return arr;
    }

    public static int getAccountNumber() {
        return accountNumber;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setArr(ArrayList<User> arr) {
        DetailsScreen.arr = arr;
    }

    public static boolean display() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("חשבון חדש");
        window.setMinWidth(400);
        window.setMinHeight(200);

        TextField text = new TextField("שם");
        text.setAlignment(Pos.BASELINE_RIGHT);
        text.setMaxWidth(300);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                text.setText("");
            }
        });
        Button yes = new Button("המשך");
        yes.setMinWidth(150);
        Button back = new Button("יציאה");
        back.setMinWidth(150);
        Label attention = new Label("");


        yes.setOnAction(event -> {
            answer = true;
            if(text.getText().isEmpty()){
                attention.setText("נא להכניס שם");
                attention.setTextFill(Color.DARKRED);
                return;
            }
            if(!text.getText().isEmpty()){
                arr.add(new User(text.getText()));
                accountNumber = getArr().get(arr.size()-1).getAccountNum();

                accountN = new TextField(""+ accountNumber+"");
                userName = text.getText();
                System.out.println(arr);
                System.out.println( "מספר משתמשים : " + arr.size());
            }

            DepositExist.display(accountN);
            DepositExist.writeToTxtFile();
            window.close();
        });

        back.setOnAction(event -> {
            answer = false;
            window.close();
            Main.display();
            Main.getAttention().setText(" ");
            Main.getAccountNumberTF().setText("הכנס מספר חשבון");

        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(attention,text,yes, back);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: skyblue;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-color: black;");
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();

        return answer;

    }

}



