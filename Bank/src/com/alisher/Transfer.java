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

public class Transfer{
    static boolean answer;
    private static int currentBalance;
    private static int accounTo;
    private static int moneyOut;
    private static  Label attention;
    private static int accounFrom;

    public static boolean display(TextField acountN) {
        accounFrom = Integer.parseInt(acountN.getText());

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("עברת מזומן");
        window.setMinWidth(400);
        window.setMinHeight(200);


        attention = new Label("");
        TextField text = new TextField("סכום לעברה");
        text.setMaxWidth(300);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                text.setText("");
            }
        });
        text.setAlignment(Pos.BASELINE_RIGHT);
        TextField acountNumber = new TextField("מספר חשבון לעברה");

        acountNumber.setMaxWidth(300);
        acountNumber.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                acountNumber.setText("");
            }
        });
        acountNumber.setAlignment(Pos.BASELINE_RIGHT);
        Button transfer = new Button("עברה");
        Button back = new Button("חזור");

        transfer.setOnAction(event -> {
            answer = true;
/* -------------------------------transfer money---------------------------------*/

            try{

                if (!text.getText().isEmpty()) {
                    moneyOut = Integer.parseInt(text.getText());
                    currentBalance = (DetailsScreen.getArr().get(accounFrom - 1).getBalance());
                    accounTo = Integer.parseInt(acountNumber.getText());
                    if(accountExist() && moneyOut > 0 && currentBalance > 0 && moneyOut <= currentBalance){
                        currentBalance -= moneyOut;

                        DetailsScreen.getArr().get(accounFrom - 1).setBalance(currentBalance);
                        transferMoney();
                        DepositExist.display(acountN);
                        SuccessTransfer.display();
                        DepositExist.writeToTxtFile();
                        System.out.println(DetailsScreen.getArr());
                        window.close();
                    }
                    else if(moneyOut > currentBalance){
                        attention.setText("הסכום המבוקש גדול מהיתרה");
                        attention.setTextFill(Color.DARKRED);
                        return;
                    }
                    else if(moneyOut < 0){
                        attention.setText("נא להכניס סכום גדול מ - 0");
                        attention.setTextFill(Color.DARKRED);
                        return;
                    }
                }
                else {
                    attention.setText("סכום או מספר חשבון אינו תקין");
                    attention.setTextFill(Color.DARKRED);
                    return;
                }
            }catch (NumberFormatException e){
                attention.setText("סכום או מספר חשבון אינו תקין");
                attention.setTextFill(Color.DARKRED);
                return;
            }
        });
/* -------------------------------transfer money---------------------------------*/

        back.setOnAction(event -> {
            answer = false;
            DepositExist.display(acountN);
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(attention,text,acountNumber,transfer, back);
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

    private static void transferMoney(){
        for (int i = 0; i < DetailsScreen.getArr().size() ; i++) {
                if(DetailsScreen.getArr().get(i).getAccountNum() == accounTo ){
                    DetailsScreen.getArr().get(i).setBalance(DetailsScreen.getArr().get(i).getBalance() + moneyOut);
                }
            else {
                attention.setText("מספר חשבון אינו תקין");
                attention.setTextFill(Color.DARKRED);
            }
        }
    }

    public static boolean accountExist(){
        for (int i = 0; i < DetailsScreen.getArr().size() ; i++) {
            if(DetailsScreen.getArr().get(i).getAccountNum() == accounTo ){
                return true;
            }
            else{
                attention.setText("מספר חשבון אינו תקין");
                attention.setTextFill(Color.DARKRED);
            }
        }
        return false;
    }
}



