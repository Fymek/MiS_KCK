package com.example.mis_kck;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class WalkaController {
    @FXML
    private Button sleepButton;
    @FXML
    private Button atackQuick;
    @FXML
    private Button atackMedium;
    @FXML
    private Button atackPower;
    @FXML
    private Button blockButton;
    @FXML
    private Text hpbar;
    @FXML
    private Text hpbar1;
    @FXML
    private Text manabar;
    @FXML
    private Text manabar1;
    Postac postac1,postac2;
    int tura;

    public void updatePlayers(Postac p1, Postac p2){
        this.postac1 =p1;
        this.postac2 =p2;
    }

//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
}
