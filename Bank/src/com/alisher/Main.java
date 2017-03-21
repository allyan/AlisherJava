package com.alisher;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application{

    private static Stage window;
    private static VBox layout;
    private static Scene scene;
    private static TextField accountNumberTF;
    private static Button loginBtn;
    private static Button createAccountBtn;
    private static Label attention;
    private static File file = new File("userList.txt");


    public static void main(String[] args) {
        setArrayFromTxt();
        launch();
    }

    @Override
    public void start(Stage window) throws Exception {
        this.window = window;

        accountNumberTF = new TextField("הכנס מספר חשבון");
        accountNumberTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                accountNumberTF.setText("");
            }
        });
        accountNumberTF.setMaxWidth(300);
        accountNumberTF.setAlignment(Pos.BASELINE_RIGHT);

        attention = new Label("");
        loginBtn = new Button("כניסה");
        loginBtn.setMinWidth(150);
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(DetailsScreen.getArr().size() == 0){
                    attention.setText("אין אף מספר חשבון במערכת");
                    attention.setTextFill(Color.DARKRED);
                    return;
                }
                try{
                    if (!accountNumberTF.getText().isEmpty()) {
                        int accountNumber = Integer.parseInt(accountNumberTF.getText());
                        for (int i = 0; i < DetailsScreen.getArr().size(); i++) {
                            if(DetailsScreen.getArr().get(i).getAccountNum() == accountNumber){
                                DepositExist.display(accountNumberTF);
                                attention.setText(" ");
                            }
                            else{
                                attention.setText("מספר חשבון אינו קיים");
                                attention.setTextFill(Color.DARKRED);
                            }
                        }
                    }
                    else {
                        attention.setText("מספר חשבון אינו תקין");
                        attention.setTextFill(Color.DARKRED);
                    }

                }catch (NumberFormatException e){
                    attention.setText("מספר חשבון אינו תקין");
                    attention.setTextFill(Color.DARKRED);
                }
            }
        });

        createAccountBtn = new Button("חשבון חדש");
        createAccountBtn.setMinWidth(150);
        createAccountBtn.setOnAction(event -> {
            DetailsScreen.display();
            window.close();
        });

        layout = new VBox(15);
        layout.getChildren().addAll(attention,accountNumberTF, loginBtn, createAccountBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: skyblue;"
                + "-fx-border-style: solid inside;"
                + "-fx-border-width: 2;"
                + "-fx-border-color: black;");
        scene = new Scene(layout);
        window.setTitle("כניסה לחשבון");
        window.setMinWidth(400);
        window.setMinHeight(200);

        window.setScene(scene);
        display();

    }

    public static void display() {
        window.show();

    }

    public static TextField getAccountNumberTF() {
        return accountNumberTF;
    }

    public static Label getAttention() {
        return attention;
    }

    public static void setArrayFromTxt(){
        try {
            int counter = 0;
            FileInputStream in = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null){
                DetailsScreen.getArr().add(new User(line.substring(0,line.indexOf(' '))));
                int balance = Integer.parseInt(line.substring(line.indexOf('$') + 1));
                DetailsScreen.getArr().get(counter++).setBalance(balance);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}