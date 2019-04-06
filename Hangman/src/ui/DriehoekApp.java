package ui;

import domain.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DriehoekApp {
    private Label invoerXLabel1, invoerYLabel1, invoerXLabel2, invoerYLabel2, invoerXLabel3, invoerYLabel3;
    private TextField invoerX1, invoerY1, invoerX2, invoerY2, invoerX3, invoerY3;

    private Alert foutenboodschap = new Alert(Alert.AlertType.WARNING);

    private Vorm vorm;
    public DriehoekApp(GridPane root) {


        init(root, 0);
        invoerY3.setOnAction(eventIngaveY3 -> {
            try {
                Punt punt1 = new Punt(Integer.parseInt(invoerX1.getText()), Integer.parseInt(invoerY1.getText()));
                Punt punt2 = new Punt(Integer.parseInt(invoerX2.getText()), Integer.parseInt(invoerY2.getText()));
                Punt punt3 = new Punt(Integer.parseInt(invoerX3.getText()), Integer.parseInt(invoerY3.getText()));
                vorm = new Driehoek(punt1, punt2, punt3);
                root.getChildren().clear();
                Text uitvoer = new Text();
                uitvoer.setText(vorm.toString());
                root.add(uitvoer, 0, 0);

            } catch (NumberFormatException ne) {
                invoerY3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            } catch (DomainException e) {
                invoerY3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setHeaderText(null);
                foutenboodschap.setContentText(e.getMessage());
                foutenboodschap.showAndWait();
            }
        });
    }

    public DriehoekApp(GridPane root, Tekening tekening) {
        init(root, 1);
        invoerY3.setOnAction(eventIngaveY3 -> {
            try {
                Punt punt1 = new Punt(Integer.parseInt(invoerX1.getText()), Integer.parseInt(invoerY1.getText()));
                Punt punt2 = new Punt(Integer.parseInt(invoerX2.getText()), Integer.parseInt(invoerY2.getText()));
                Punt punt3 = new Punt(Integer.parseInt(invoerX3.getText()), Integer.parseInt(invoerY3.getText()));
                vorm = new Driehoek(punt1, punt2, punt3);
                tekening.voegToe(vorm);
                cleanUp(root);

            } catch (NumberFormatException ne) {
                invoerY3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("straal van de cirkel moet een geheel getal zijn");
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
        invoerXLabel1 = new Label("Geef de x-coÃ¶rdinaat van het punt 1");
        invoerX1 = new TextField();

        invoerYLabel1 = new Label("Geef de y-coÃ¶rdinaat van punt 1");
        invoerY1 = new TextField();

        invoerXLabel2 = new Label("Geef de x-coÃ¶rdinaat van het punt 2");
        invoerX2 = new TextField();

        invoerYLabel2 = new Label("Geef de y-coÃ¶rdinaat van punt 2");
        invoerY2 = new TextField();

        invoerXLabel3 = new Label("Geef de x-coÃ¶rdinaat van het punt 3");
        invoerX3 = new TextField();

        invoerYLabel3 = new Label("Geef de y-coÃ¶rdinaat van punt 3");
        invoerY3 = new TextField();


        root.add(invoerXLabel1, 0, teller);
        root.add(invoerX1, 1, teller);

        invoerX1.setOnAction(eventIngaveX1 -> {
            try {
                Integer.parseInt(invoerX1.getText());
                root.add(invoerYLabel1, 0, teller + 1);
                root.add(invoerY1, 1, teller + 1);
            } catch (NumberFormatException e) {
                invoerX1.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coÃ¶rdinaat punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY1.setOnAction(eventIngaveY1 -> {
            try {
                Integer.parseInt(invoerY1.getText());
                root.add(invoerXLabel2, 0, teller + 2);
                root.add(invoerX2, 1, teller + 2);
            } catch (NumberFormatException e) {
                invoerY1.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coÃ¶rdinaat van punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerX2.setOnAction(eventIngaveX2 -> {
            try {
                Integer.parseInt(invoerX2.getText());
                root.add(invoerYLabel2, 0, teller + 3);
                root.add(invoerY2, 1, teller + 3);
            } catch (NumberFormatException e) {
                invoerX2.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coÃ¶rdinaat van punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerY2.setOnAction(eventIngaveY2 -> {
            try {
                Integer.parseInt(invoerY2.getText());
                root.add(invoerXLabel3, 0, teller + 4);
                root.add(invoerX3, 1, teller + 4);
            } catch (NumberFormatException e) {
                invoerY2.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("y coÃ¶rdinaat van een punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });

        invoerX3.setOnAction(eventIngaveX3 -> {
            try {
                Integer.parseInt(invoerX3.getText());
                root.add(invoerYLabel3, 0, teller + 5);
                root.add(invoerY3, 1, teller + 5);
            } catch (NumberFormatException e) {
                invoerX3.clear();
                foutenboodschap.setTitle("Warning");
                foutenboodschap.setContentText("x coÃ¶rdinaat van een punt moet een geheel getal zijn");
                foutenboodschap.showAndWait();
            }
        });
    }

    private void cleanUp(GridPane root) {
        root.getChildren().remove(invoerXLabel1);
        root.getChildren().remove(invoerX1);
        root.getChildren().remove(invoerYLabel1);
        root.getChildren().remove(invoerY1);
        root.getChildren().remove(invoerXLabel2);
        root.getChildren().remove(invoerX2);
        root.getChildren().remove(invoerYLabel2);
        root.getChildren().remove(invoerY2);
        root.getChildren().remove(invoerXLabel3);
        root.getChildren().remove(invoerX3);
        root.getChildren().remove(invoerYLabel3);
        root.getChildren().remove(invoerY3);
    }
}
