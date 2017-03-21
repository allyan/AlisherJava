package com.alisher;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SuccessTransfer{
    static boolean answer;

    public static boolean display() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("העברה בוצאה בהצלחה");
        window.setMinWidth(400);
        window.setMinHeight(150);
        Label label = new Label("העברה בוצעה בהצלחה !");
        label.setTextFill(Color.DARKRED);

        Button yes = new Button("אוקי");


        yes.setOnAction(event -> {
            answer = true;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,yes);
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



