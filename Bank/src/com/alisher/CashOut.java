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

public class CashOut{
    static boolean answer;
    private static int currentBalance;

    public static boolean display(TextField acountN) {
        int acountNum = Integer.parseInt(acountN.getText());
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("משיכת מזומן");
        window.setMinWidth(400);
        window.setMinHeight(200);

        Label attention = new Label("");
        TextField text = new TextField("סכום למשיכה");
        text.setAlignment(Pos.BASELINE_RIGHT);
        text.setMaxWidth(300);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                text.setText("");
            }
        });
        Button cashOut = new Button("משיכה");
        cashOut.setMinWidth(150);
        Button back = new Button("חזור");
        back.setMinWidth(150);

        cashOut.setOnAction(event -> {
            answer = true;

            try{
                if (!text.getText().isEmpty()) {
                    int moneyOut = Integer.parseInt(text.getText());
                    currentBalance = (DetailsScreen.getArr().get(acountNum - 1).getBalance());
                    if(moneyOut > 0 && currentBalance > 0 && moneyOut <= currentBalance){
                        currentBalance -= moneyOut;
                        DetailsScreen.getArr().get(acountNum - 1).setBalance(currentBalance);
                        DepositExist.writeToTxtFile();
                        System.out.println(DetailsScreen.getArr());
                    }
                    else if(moneyOut > currentBalance){
                        attention.setText("הסכום המבוקש גדול מהיתרה");
                        attention.setTextFill(Color.DARKRED);
                        return;
                    }
                    else if(moneyOut < 0){
                        attention.setText("נא להכניס סכום מדוייק");
                        attention.setTextFill(Color.DARKRED);
                        return;
                    }
                }
                else {
                    attention.setText("נא להכניס סכום מדוייק");
                    attention.setTextFill(Color.DARKRED);
                    return;
                }
            }catch (NumberFormatException e){
                attention.setText("נא להכניס סכום מדוייק");
                attention.setTextFill(Color.DARKRED);
                return;
            }
            DepositExist.display(acountN);

            window.close();
        });

        back.setOnAction(event -> {
            answer = false;
            DepositExist.display(acountN);
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(attention,text,cashOut, back);
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



