package ui;

import domain.Tekening;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class VormMakenApp {
    private GridPane root;
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public VormMakenApp(GridPane root, Tekening tekening) {

        this.root = root;
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel","Rechthoek","Lijnstuk","Driehoek");
        keuzeMenu = new ComboBox(mogelijkeFiguren);

        root.add(keuzeMenu,0,1);
        keuzeMenu.setOnAction(eventKeuze -> {
                    if (keuzeMenu.getValue() != null) {
                        switch (keuzeMenu.getValue()) {
                            case "Cirkel":
                                new CirkelApp(root, tekening);
                                break;
                            case "Rechthoek":
                                new RechthoekApp(root, tekening);
                                break;
                            case "Lijnstuk":
                                new LijnStukApp(root, tekening);
                                break;
                            case "Driehoek":
                                new DriehoekApp(root, tekening);
                                break;
                        }
                        root.getChildren().remove(keuzeMenu);
                    }
                }
        );}



}