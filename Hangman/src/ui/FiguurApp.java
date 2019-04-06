package ui;

import domain.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class FiguurApp {
    private ComboBox<String> keuzeMenu;
    private ObservableList<String> mogelijkeFiguren;

    public FiguurApp(GridPane root) {
        mogelijkeFiguren = FXCollections.observableArrayList("Cirkel","Rechthoek", "LijnStuk", "Driehoek");
        keuzeMenu = new ComboBox(mogelijkeFiguren);
        root.add(keuzeMenu,0,0);
        keuzeMenu.setOnAction(eventKeuze -> {
            keuzeMenu.setVisible(false);
            if (keuzeMenu.getValue()!=null){
                switch (keuzeMenu.getValue()) {
                    case "Cirkel":
                        new CirkelApp(root);
                        break;
                    case "Rechthoek":
                        new RechthoekApp(root);
                        break;
                    case "LijnStuk":
                        new LijnStukApp(root);
                        break;
                    case "Driehoek":
                        new DriehoekApp(root);
                        break;
                }
            }
        });
    }
}