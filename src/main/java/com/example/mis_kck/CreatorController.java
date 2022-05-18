package com.example.mis_kck;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class CreatorController  implements Initializable {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    private ImageView confirmButton;
//
//    @FXML
//    private Pane panel;
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

    private byte total = 10;
    Postac postac;
    ArrayList<Button> buttonPlus;
    ArrayList<Button> buttonMinus;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonPlus = new ArrayList<>(Arrays.asList(strplus,vitplus,staplus,agiplus,defplus));
        buttonPlus.forEach(button ->{
            plusButton(button);
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
                    total--;
                    vitPoints.setText("" + postac.getStat_HP());
                } else if (strplus.equals(button)) {
                    byte b = postac.getStat_SILA();
                    b++;
                    postac.setStat_SILA(b);
                    total--;
                    strPoints.setText("" + postac.getStat_SILA());
                } else if (staplus.equals(button)) {
                    byte c = postac.getStat_ENERGIA();
                    c++;
                    postac.setStat_ENERGIA(c);
                    total--;
                    staPoints.setText("" + postac.getStat_ENERGIA());
                } else if (agiplus.equals(button)) {
                    byte d = postac.getStat_ZWINNOSC();
                    d++;
                    postac.setStat_ZWINNOSC(d);
                    total--;
                    agiPoints.setText("" + postac.getStat_ZWINNOSC());
                } else if (defplus.equals(button)) {
                    byte e = postac.getStat_OBRONA();
                    e++;
                    postac.setStat_OBRONA(e);
                    defPoints.setText("" + postac.getStat_OBRONA());
                    total--;
                }
                totalPoints.setText(""+total);

            }

        });
    }
    private void minusButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {

        });
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