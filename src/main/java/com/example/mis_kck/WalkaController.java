package com.example.mis_kck;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;



public class WalkaController implements Initializable{

    @FXML
    private Button sleepButton;
    @FXML
    private Button attackQuick;
    @FXML
    private Button attackMedium;
    @FXML
    private Button attackPower;
    @FXML
    private Button blockButton;
    @FXML
    private Text hpbar1;
    @FXML
    private Text hpbar2;
    @FXML
    private Text manabar1;
    @FXML
    private Text manabar2;
    @FXML
    private Text winnerText;
    @FXML
    private Text player1Text;
    @FXML
    private Text player2Text;

    @FXML
    private Text damage1;
    @FXML
    private Text damage2;
    @FXML
    private Pane damagePane2;
    @FXML
    private Pane damagePane1;
    @FXML
    private ImageView tarcza1;
    @FXML
    private ImageView tarcza2;
    @FXML
    private ImageView sleepIcon1;
    @FXML
    private ImageView sleepIcon2;

    Postac player1,player2;
    int tura = 1;     //tura 1 dla player1; tura -1 dla player2
    ArrayList<Button> buttons;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(sleepButton,attackQuick,attackMedium,attackPower,blockButton));
    }
    public void updatePlayers(Postac p1, Postac p2){
        this.player1 = p1;
        this.player2 = p2;
    }
    public void updateStatus(){
        this.hpbar1.setText(""+player1.getStat_HP_fight());
        this.manabar1.setText(""+player1.getStat_ENERGIA());
        this.hpbar2.setText(""+player2.getStat_HP_fight());
        this.manabar2.setText(""+player2.getStat_ENERGIA());
        if(tura == 1) {
            player1Text.setFill(Color.GREEN);
            player2Text.setFill(Color.RED);
        }
        if(tura == -1) {
            player2Text.setFill(Color.GREEN);
            player1Text.setFill(Color.RED);
        }

    }
    PauseTransition visiblePause = new PauseTransition(
            Duration.seconds(1.5)
    );
    public void offButtons()
    {
        buttons.get(1).setFocusTraversable(false);
        buttons.get(1).setDisable(true);
        buttons.get(2).setFocusTraversable(false);
        buttons.get(2).setDisable(true);
        buttons.get(3).setFocusTraversable(false);
        buttons.get(3).setDisable(true);
        buttons.get(4).setFocusTraversable(false);
        buttons.get(4).setDisable(true);
    }
    public void onButtons()
    {
        buttons.get(1).setFocusTraversable(true);
        buttons.get(1).setDisable(false);
        buttons.get(2).setFocusTraversable(true);
        buttons.get(2).setDisable(false);
        buttons.get(3).setFocusTraversable(true);
        buttons.get(3).setDisable(false);
        buttons.get(4).setFocusTraversable(true);
        buttons.get(4).setDisable(false);
    }
    public void showDamage(int damage){
        if(tura == 1){
            damage2.setText(""+damage);
            damagePane2.setVisible(true);
            visiblePause.setOnFinished(
                    event -> damagePane2.setVisible(false)
            );
            visiblePause.play();
            checkIfGameIsOver();

        }
        else if(tura == -1){
            damage1.setText(""+damage);
            damagePane1.setVisible(true);
            visiblePause.setOnFinished(
                    event -> damagePane1.setVisible(false)
            );
            visiblePause.play();
            checkIfGameIsOver();
        }

    }
    public void showTarcza(){
        if(tura == 1){
            tarcza1.setVisible(true);
            visiblePause.setOnFinished(
                    event -> tarcza1.setVisible(false)
            );
            visiblePause.play();

        }
        else if(tura == -1){
            tarcza2.setVisible(true);
            visiblePause.setOnFinished(
                    event -> tarcza2.setVisible(false)
            );
            visiblePause.play();
        }

    }
    public void showSleep(){
        if(tura == 1){
            sleepIcon1.setVisible(true);
            visiblePause.setOnFinished(
                    event -> sleepIcon1.setVisible(false)
            );
            visiblePause.play();

        }
        else if(tura == -1){
            sleepIcon2.setVisible(true);
            visiblePause.setOnFinished(
                    event -> sleepIcon2.setVisible(false)
            );
            visiblePause.play();
        }
    }
    public void doAction(Postac postac, Postac przeciwnik){
        buttons.forEach(button -> button.setOnMouseClicked(mouseEvent -> {
            if (sleepButton.equals(button)) {
                postac.sleep();
                showSleep();
                tura *= -1;
                if(przeciwnik.flag==2) przeciwnik.blok();
                updateStatus();
            } else if (attackQuick.equals(button)) {
                int damage = postac.atak(przeciwnik, Postac.Rodzaj_ataku.QUICK);
                showDamage(damage);
                tura *= -1;
                postac.setStat_ENERGIA((byte)(postac.getStat_ENERGIA()-1));
                if(przeciwnik.flag==2) przeciwnik.blok();
                updateStatus();

            } else if (attackMedium.equals(button)) {
                int damage =postac.atak(przeciwnik, Postac.Rodzaj_ataku.MEDIUM);
                showDamage(damage);
                tura *= -1;
                postac.setStat_ENERGIA((byte)(postac.getStat_ENERGIA()-1));
                if(przeciwnik.flag==2) przeciwnik.blok();
                updateStatus();
            } else if (attackPower.equals(button)) {
                int damage =postac.atak(przeciwnik, Postac.Rodzaj_ataku.POWER);
                showDamage(damage);
                tura *= -1;
                postac.setStat_ENERGIA((byte)(postac.getStat_ENERGIA()-1));
                if(przeciwnik.flag==2) przeciwnik.blok();
                updateStatus();
            } else if (blockButton.equals(button)) {
                if(postac.flag==2) doAction(postac, przeciwnik);
                else {
                    postac.blok();
                    showTarcza();
                    tura *= -1;
                    postac.setStat_ENERGIA((byte) (postac.getStat_ENERGIA() - 1));
                    updateStatus();
                }
            }
        }));
        checkIfGameIsOver();
        if(przeciwnik.getStat_ENERGIA()<=0) offButtons();
        else onButtons();
        updateStatus();
    }
    @FXML
    public void takeTurn(ActionEvent actionEvent){
        if(tura == 1){
            doAction(player1,player2);
        }
        else if(tura == -1){
            doAction(player2,player1);
        }
        updateStatus();
    }
    public void checkIfGameIsOver(){
        if(player1.getStat_HP_fight() <= 0){
            winnerText.setText("PLAYER 2 WON!");
            buttons.forEach(button ->{
                button.setFocusTraversable(false);
                button.setDisable(true);
            });
        }
        if(player2.getStat_HP_fight() <= 0){
            winnerText.setText("PLAYER 1 WON!");
            buttons.forEach(button ->{
                button.setFocusTraversable(false);
                button.setDisable(true);
            });
        }
    }

}
