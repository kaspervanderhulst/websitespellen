package ui;

import db.domain.WoordenLezer;
import domain.Speler;
import domain.WoordenLijst;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class FxHangManApp extends Application {


    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        WoordenLezer woordenlezer = new WoordenLezer("src/db/hangman.txt");
        WoordenLijst woordenlijst = woordenlezer.lees();

        VBox root = new VBox();
        Scene scene = new Scene(root,400,450);
        TextField invoerNaam = new TextField("Geef de naam van de speler");
        root.getChildren().add(invoerNaam);

        primaryStage.setScene(scene);

        invoerNaam.setOnAction( eventIngaveNaam -> {
            primaryStage.setTitle(invoerNaam.getText());
            root.getChildren().clear();
            try {
                new HangManApp(root,new Speler(invoerNaam.getText()), woordenlijst);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}