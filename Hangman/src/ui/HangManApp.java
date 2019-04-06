package ui;

import db.domain.ScoreRecordTabel;
import domain.HangMan;
import domain.ScoreRecord;
import domain.Speler;
import domain.WoordenLijst;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

public class HangManApp {
    private HBox hbox= new HBox();
    private HBox invoerBox = new HBox();
    private VBox scoreOuput = new VBox();

    private Text hintwoordUitvoer = new Text();
    private Button raadButton = new Button("raad");
    private TextField invoerLetter = new TextField("Welke letter?");
    private HangMan hangman ;

    private TekenVenster tekening;
    private Pane pane = new Pane();


    public HangManApp(VBox root, Speler speler, WoordenLijst woordenlijst) throws FileNotFoundException {
        this.hangman = new HangMan(speler, woordenlijst);
        this.tekening = new TekenVenster(pane,this.hangman.getTekening());

        hintwoordUitvoer.setText(this.hangman.getHint());
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().add(hintwoordUitvoer);
        hbox.getChildren().add(raadButton);
        invoerBox.getChildren().add(invoerLetter);
        invoerBox.setDisable(true);

        root.getChildren().addAll(pane, hbox, invoerBox,scoreOuput);

        raadButton.setOnAction(eventRaad ->{
            if (hangman.isGewonnen()) {
                raadButton.setDisable(true);
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                hintwoordUitvoer.setText("Goed gedaan " + speler.getNaam() + " je hebt " + hangman.getPunten() + " punten verdiend!!");
                hbox.getChildren().add(hintwoordUitvoer);
                afterGame();
            }
            else if (hangman.isGameOver()){
                raadButton.setDisable(true);
                hbox.getChildren().clear();
                invoerBox.getChildren().clear();
                hintwoordUitvoer.setText("Jammer " + speler.getNaam() + " je hebt het woord niet geraden!!");
                hbox.getChildren().add(hintwoordUitvoer);
            }
            else{
                invoerBox.setDisable(false);
                invoerLetter.clear();
            }
        });

        invoerLetter.setOnAction(eventIngaveLetter -> {
            if(invoerLetter.getLength() > 1){
                if(hangman.raadWoord(invoerLetter.getText())){
                    hintwoordUitvoer.setText(this.hangman.getWoord());
                }else this.tekening = new TekenVenster(pane,this.hangman.getTekening());
            }else
            if (hangman.raad(invoerLetter.getText().charAt(0))) {
                hintwoordUitvoer.setText(this.hangman.getHint());
            }
            else {
                this.tekening = new TekenVenster(pane,this.hangman.getTekening());
            }
            invoerBox.setDisable(true);
        });
    }

    private void afterGame() {
        ScoreRecordTabel.nieuwScoreRecord(hangman.getSpeler().getNaam(),(new Date().getTime())/1000,  hangman.getPunten());
        Button next = new Button("Highscores");

        hbox.getChildren().add(next);

        next.setOnAction(eventHighscores ->{
            this.cleanUp();
            ArrayList<ScoreRecord> highscores = ScoreRecordTabel.getHighscores();
            cleanUp();
            int i = 0;
            for (ScoreRecord scoreRecord : highscores) {
                Label label = new Label(scoreRecord.getUsername()+ " " + scoreRecord.getScore() +"\n");
                scoreOuput.getChildren().add(i++, label);
            }
        });
    }

    private void cleanUp() {
        pane.getChildren().clear();
        hbox.getChildren().clear();
    }
}