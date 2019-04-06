package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class RechthoekApp {

    private Label invoerXLabel, invoerYLabel, invoerBreedteLabel, invoerHoogteLabel;
    private TextField invoerX, invoerY, invoerBreedte, invoerHoogte;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Vorm vorm;

    public RechthoekApp(GridPane root) {
        init(root, 0);
        invoerHoogte.setOnAction(eventIngaveStraal -> {
            try {
                Punt linksboven = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                vorm = new Rechthoek(linksboven, Integer.parseInt(invoerBreedte.getText()), Integer.parseInt(invoerHoogte.getText()));
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer, 0, 0);
            } catch (NumberFormatException ne) {
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException e) {
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });

    }

    public RechthoekApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerHoogte.setOnAction(eventIngaveH -> {
            try {
                Punt linksboven = new Punt(Integer.parseInt(invoerX.getText()), Integer.parseInt(invoerY.getText()));
                vorm = new Rechthoek(linksboven, Integer.parseInt(invoerBreedte.getText()), Integer.parseInt(invoerHoogte.getText()));
                tekening.voegToe(vorm);
                cleanUp(root);
            } catch (NumberFormatException ne) {
                invoerHoogte.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("Hoogte moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException e) {
                cleanUp(root);
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }

        });
    }

    private void init(GridPane root, int teller) {
        invoerXLabel = new Label("Geef de x-coÃ¶rdinaat van linksboven van de cirkel ");
        invoerX = new TextField();

        invoerYLabel = new Label("Geef de y-coÃ¶rdinaat van linksboven van de cirkel ");
        invoerY = new TextField();

        invoerBreedteLabel = new Label("Geef de breedte van de rechthoek");
        invoerBreedte = new TextField();

        invoerHoogteLabel = new Label("Geef de hoogte van de rechthoek");
        invoerHoogte = new TextField();

        root.add(invoerXLabel, 0, teller);
        root.add(invoerX, 1, teller);

        invoerX.setOnAction(eventIngaveX -> {
            try {
                Integer.parseInt(invoerX.getText());
                root.add(invoerYLabel, 0, teller + 1);
                root.add(invoerY, 1, teller + 1);
            } catch (NumberFormatException e) {
                invoerX.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coÃ¶rdinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }

        });

        invoerY.setOnAction(eventIngaveY -> {
            try {
                Integer.parseInt(invoerY.getText());
                root.add(invoerBreedteLabel, 0, teller + 2);
                root.add(invoerBreedte, 1, teller + 2);
            } catch (NumberFormatException e) {
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y-coordinaat moet een geheel getal zijn");
                foutenboodschap.showAndWait();

            }
        });

        invoerBreedte.setOnAction(eventIngaveB -> {
            try {
                Integer.parseInt(invoerBreedte.getText());
                root.add(invoerHoogteLabel, 0, teller + 3);
                root.add(invoerHoogte, 1, teller + 3);
            } catch (NumberFormatException e) {
                invoerY.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("breedte moet een geheel getal zijn");
                foutenboodschap.showAndWait();

            }
        });
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerXLabel);
        root.getChildren().remove(invoerX);
        root.getChildren().remove(invoerYLabel);
        root.getChildren().remove(invoerY);
        root.getChildren().remove(invoerBreedteLabel);
        root.getChildren().remove(invoerBreedte);
        root.getChildren().remove(invoerHoogteLabel);
        root.getChildren().remove(invoerHoogte);
    }
}
