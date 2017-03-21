package com.alisher;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class DepositExist{
    static boolean answer;
    private static TextField balance;
    private static TextField acountN;
    private static Stage window;
    private static File file = new File("userList.txt");


    public static boolean display(TextField userAccount) {
        acountN = userAccount;
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("פרטי חשבון");
        window.setMinWidth(400);
        window.setMinHeight(300);

        int accountNum = Integer.parseInt(acountN.getText());
        acountN = new TextField(acountN.getText());
        acountN.setEditable(false);

        acountN.setAlignment(Pos.BASELINE_RIGHT);
        acountN.setMaxWidth(300);
        TextField ownerName = new TextField(DetailsScreen.getArr().get(accountNum - 1).getName());
        ownerName.setAlignment(Pos.BASELINE_RIGHT);
        ownerName.setMaxWidth(300);
        ownerName.setEditable(false);
        balance = new TextField("" + DetailsScreen.getArr().get(accountNum - 1).getBalance() + "");
        balance.setAlignment(Pos.BASELINE_RIGHT);
        balance.setMaxWidth(300);
        balance.setEditable(false);
        Button cashIn = new Button("הפקדה");
        cashIn.setMinWidth(150);
        Button cashOut = new Button("משיכה");
        cashOut.setMinWidth(150);
        Button cashTransfer = new Button("עברה");
        cashTransfer.setMinWidth(150);
        Button exit = new Button("יציאה");
        exit.setMinWidth(150);

        cashIn.setOnAction(event -> {
            answer = true;
            CashIn.display(acountN);
            window.close();
        });

        cashOut.setOnAction(event -> {
            answer = true;
            CashOut.display(acountN);
            window.close();
        });

        cashTransfer.setOnAction(event -> {
            answer = true;
            Transfer.display(acountN);
            window.close();
        });

        exit.setOnAction(event -> {
            answer = false;
            window.close();
            Main.display();
            Main.getAttention().setText(" ");
            Main.getAccountNumberTF().setText("הכנס מספר חשבון");

        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(acountN,ownerName, balance, cashIn, cashOut, cashTransfer, exit);
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

    public static void  writeToTxtFile() {

        try {
            FileOutputStream out = new FileOutputStream(file);
            for (int i = 0; i < DetailsScreen.getArr().size() ; i++) {
                out.write(DetailsScreen.getArr().get(i).toString().getBytes());
                out.write("\n".getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}



