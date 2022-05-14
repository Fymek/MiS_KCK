package com.example.mis_kck;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CreatorController {
    @FXML
    private Label welcomeText;

    @FXML
    private ImageView confirmButton;

    @FXML
    private Pane panel;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

//    @FXML
//    protected void onConfirmButtonClick(Stage stage) throws IOException {
//        panel = new Pane(getClass().getResource("walka.fxml"));
//        Scene scene = new Scene(panel);
//        stage.setTitle("Widły i Kapcie!");
//        stage.setScene(scene);
//        stage.show();
//    }
}