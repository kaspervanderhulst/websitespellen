package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cirkel extends Vorm implements Drawable {
    private Punt middelPunt;
    private int radius;

    public Cirkel(Punt middelPunt, int radius) {
        setMiddelPunt(middelPunt);
        setRadius(radius);
    }

    private void setMiddelPunt(Punt middelPunt) {
        if (middelPunt == null)
            throw new DomainException("het middelpunt mag niet null zijn");
        this.middelPunt = middelPunt;
    }

    private void setRadius(int radius) {
        if (radius <= 0) {
            throw new DomainException("straal kan niet null of negatief zijn");
        }
        this.radius = radius;
    }

    public Punt getMiddelPunt() {
        return middelPunt;
    }

    public int getRadius() {
        return radius;
    }

    public boolean equals(Object o) {

        if (o instanceof Cirkel) {
            Cirkel c = (Cirkel) o;
            return (c.getMiddelPunt() == this.getMiddelPunt() && c.getRadius() == this.getRadius());
        }
        return false;
    }

    public String toString() {
        return "Cirkel: Middelpunt:" + getMiddelPunt().toString() +
                " - straal: " + getRadius();
    }

    public Omhullende getOmhullende() {
        return new Omhullende(new Punt(middelPunt.getX() - radius, middelPunt.getY() - radius), 2 * radius, 2 * radius);
    }

    @Override
    public void teken(Pane root) {
        Circle circle = new Circle(this.getMiddelPunt().getX(), this.getMiddelPunt().getY(), this.getRadius());
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5);
        root.getChildren().addAll(circle);
    }
}
