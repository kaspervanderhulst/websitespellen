package ui;

import domain.HintWoord;
import domain.Speler;
import domain.WoordenLijst;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;

public class WoordRadenApp {
    private Label gokLabel, hintLabel;
    private TextField gok, hint;
    private HintWoord hintWoord;
    private Speler speler;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    public WoordRadenApp(GridPane root, Speler speler) {
        this.speler = speler;
        hintWoord = new HintWoord("hangmanspelletje");
        init(root);
    }

    public WoordRadenApp(GridPane root, Speler speler, String filename) throws FileNotFoundException {
        WoordenLijst woordenLijst = new WoordenLijst(filename);
        hintWoord = new HintWoord(woordenLijst.getRandomWoord());
        this.speler = speler;
        init(root);
    }

    private void init(GridPane root) {
        int teller = 0;

        gokLabel = new Label("Geef een letter");
        gok = new TextField();

        root.add(gokLabel, 0, teller);
        root.add(gok, 1, teller);

        hintLabel = new Label(hintWoord.toString());

        root.add(hintLabel, 0, ++teller);

        gok.setOnAction(eventGok -> {
            try {
                if (gok.getText().length() > 1) {
                    gok.clear();
                    foutenboodschap.setTitle("Warning");
                    foutenboodschap.setContentText("Slechts 1 letter meegeven");
                    foutenboodschap.showAndWait();
                }
                else {
                    char l = gok.getText().charAt(0);
                    hintWoord.raad(l);
                    root.getChildren().remove(hintLabel);
                    hintLabel = new Label(hintWoord.toString());
                    root.add(hintLabel, 0, 1);
                    if (!hintWoord.isGeraden()) {
                        gok.clear();
                    }
                    else {
                        cleanUp(root);
                    }
                }
            } catch (Exception e) {
                gok.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Geef een letter");
                foutenboodschap.showAndWait();
            }
        });

    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(gokLabel);
        root.getChildren().remove(gok);
        foutenboodschap.setTitle("Succes");
        foutenboodschap.setContentText("Dit was inderdaad het woord! "+hintWoord.getWoord());
        foutenboodschap.showAndWait();
        root.getChildren().remove(hintLabel);
        root.getChildren().remove(hint);
    }
}
