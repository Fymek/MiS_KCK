package com.example.mis_kck;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CreatorController  implements Initializable {

    @FXML
    private Button strplus;
    @FXML
    private Button strminus;
    @FXML
    private Button vitplus;
    @FXML
    private Button vitminus;
    @FXML
    private Button staplus;
    @FXML
    private Button staminus;
    @FXML
    private Button agiplus;
    @FXML
    private Button agiminus;
    @FXML
    private Button defplus;
    @FXML
    private Button defminus;
    @FXML
    private Text vitPoints;
    @FXML
    private Text defPoints;
    @FXML
    private Text agiPoints;
    @FXML
    private Text strPoints;
    @FXML
    private Text staPoints;
    @FXML

    private Text totalPoints;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private byte total = 10;
    private Postac player1, player2;

    public Postac getPostac() {
        return postac;
    }
    public void updatePlayers(Postac p1, Postac p2){
        this.player1 =p1;
        this.player2 =p2;
    }
    public void switchToStart(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("start.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToKreator(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Kreator.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToKreator_1(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("kreator_1.fxml"));
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        player1.setStat_HP((byte)Integer.parseInt(vitPoints.getText()));
//        player1.setStat_ENERGIA((byte)Integer.parseInt(staPoints.getText()));
//        player1.setStat_OBRONA((byte)Integer.parseInt(defPoints.getText()));
//        player1.setStat_SILA((byte)Integer.parseInt(strPoints.getText()));
//        player1.setStat_ZWINNOSC((byte)Integer.parseInt(agiPoints.getText()));
//        stage.show();
        player1 = getPostac();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("kreator_1.fxml"));
        root = loader.load();


        CreatorController creatorController = loader.getController();
        creatorController.updatePlayers(player1,player2);
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    public void switchToWalka(ActionEvent event) throws IOException {

        player2 = getPostac();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("walka.fxml"));
        root = loader.load();


        WalkaController walkaController = loader.getController();
        walkaController.updatePlayers(player1,player2);
        walkaController.updateStatus();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    Postac postac = new Postac();
    ArrayList<Button> buttonPlus;
    ArrayList<Button> buttonMinus;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonPlus = new ArrayList<>(Arrays.asList(strplus,vitplus,staplus,agiplus,defplus));
        buttonMinus = new ArrayList<>(Arrays.asList(strminus,vitminus,staminus,agiminus,defminus));
        buttonPlus.forEach(button ->{
            plusButton(button);
            button.setFocusTraversable(false);
        });
        buttonMinus.forEach(button ->{
            minusButton(button);
            button.setFocusTraversable(false);
        });
    }
    private void plusButton(Button button ) {

        button.setOnMouseClicked(mouseEvent -> {
            if(total>0){
                if (vitplus.equals(button)) {
                    byte a = postac.getStat_HP();
                    a++;
                    postac.setStat_HP(a);
                    vitPoints.setText("" + postac.getStat_HP());
                } else if (strplus.equals(button)) {
                    byte b = postac.getStat_SILA();
                    b++;
                    postac.setStat_SILA(b);
                    strPoints.setText("" + postac.getStat_SILA());
                } else if (staplus.equals(button)) {
                    byte c = postac.getStat_ENERGIA();
                    c++;
                    postac.setStat_ENERGIA(c);
                    staPoints.setText("" + postac.getStat_ENERGIA());
                } else if (agiplus.equals(button)) {
                    byte d = postac.getStat_ZWINNOSC();
                    d++;
                    postac.setStat_ZWINNOSC(d);
                    agiPoints.setText("" + postac.getStat_ZWINNOSC());
                } else if (defplus.equals(button)) {
                    byte e = postac.getStat_OBRONA();
                    e++;
                    postac.setStat_OBRONA(e);
                    defPoints.setText("" + postac.getStat_OBRONA());
                }
                total--;
                totalPoints.setText(""+total);
            }

        });
    }
    private void minusButton(Button button ) {

        button.setOnMouseClicked(mouseEvent -> {
            if(total<10){
                if (vitminus.equals(button)) {
                    byte a = postac.getStat_HP();
                    if(a>1) {
                        a--;
                        postac.setStat_HP(a);
                        vitPoints.setText("" + postac.getStat_HP());
                        total++;

                    }
                } else if (strminus.equals(button)) {
                    byte b = postac.getStat_SILA();
                    if(b>1) {
                        b--;
                        postac.setStat_SILA(b);
                        strPoints.setText("" + postac.getStat_SILA());
                        total++;

                    }
                } else if (staminus.equals(button)) {
                    byte c = postac.getStat_ENERGIA();
                    if(c>1) {
                        c--;
                        postac.setStat_ENERGIA(c);
                        staPoints.setText("" + postac.getStat_ENERGIA());
                        total++;

                    }
                } else if (agiminus.equals(button)) {
                    byte d = postac.getStat_ZWINNOSC();
                    if(d>1) {
                        d--;
                        postac.setStat_ZWINNOSC(d);
                        agiPoints.setText("" + postac.getStat_ZWINNOSC());
                        total++;

                    }
                } else if (defminus.equals(button)) {
                    byte e = postac.getStat_OBRONA();
                    if(e>1) {
                        e--;
                        postac.setStat_OBRONA(e);
                        defPoints.setText("" + postac.getStat_OBRONA());
                        total++;

                    }
                }
                totalPoints.setText(""+total);

            }

        });
    }
}