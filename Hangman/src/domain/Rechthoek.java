package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Rechthoek extends Vorm implements Drawable {
    private int breedte, hoogte;
    private Punt linkerBovenhoek;

    public Rechthoek(Punt linkerBovenhoek, int breedte, int hoogte) {
        if (linkerBovenhoek == null || breedte <= 0 || hoogte <= 0)
            throw new DomainException();
        this.linkerBovenhoek = linkerBovenhoek;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public int getBreedte() {
        return breedte;
    }

    public int getHoogte() {
        return hoogte;
    }

    public Punt getLinkerBovenhoek() {
        return linkerBovenhoek;
    }

    public boolean equals(Object o) {

        if(o instanceof Rechthoek) {
            Rechthoek r = (Rechthoek) o;

            return ( r.getBreedte()== this.getBreedte() && r.getHoogte() == this.getHoogte()&& r.linkerBovenhoek == this.getLinkerBovenhoek()) ;
        }
        return false;
    }
    public String toString(){
        return "Rechthoek: linkerbovenhoek: " + linkerBovenhoek.toString() + " - breedte: " + getBreedte() + " - hoogte: " + getHoogte() + "\nOmhullende: "+getOmhullende().toString();
    }

    public Omhullende getOmhullende() {
        return new Omhullende(linkerBovenhoek, breedte, hoogte);
    }

    @Override
    public void teken(Pane root) {


        Rectangle rechthoekteken = new Rectangle(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(),this.getBreedte(), this.getHoogte());
        rechthoekteken.setFill(Color.WHITE);
        rechthoekteken.setStroke(Color.BLACK);

        root.getChildren().addAll(rechthoekteken);
    }
}
