package domain;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;

public class Driehoek extends Vorm implements Drawable{
    private Punt hoekPunt1;
    private Punt hoekPunt2;
    private Punt hoekPunt3;

    public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
        if (hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null)
            throw new DomainException();
        this.hoekPunt1 = hoekPunt1;
        this.hoekPunt2 = hoekPunt2;
        this.hoekPunt3 = hoekPunt3;
    }

    public Punt getHoekPunt1() {
        return hoekPunt1;
    }

    public Punt getHoekPunt2() {
        return hoekPunt2;
    }

    public Punt getHoekPunt3() {
        return hoekPunt3;
    }

    private boolean liggenOp1Lijn(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3){
        if  ((hoekPunt2.getX()-hoekPunt1.getX())*(hoekPunt3.getY()-hoekPunt1.getY()) == (hoekPunt3.getX()-hoekPunt1.getX())*(hoekPunt2.getY()-hoekPunt1.getY()))
            return true;
        return false;
    }
    public boolean equals(Object o) {

        if (o instanceof Driehoek) {
            Driehoek d = (Driehoek) o;
            return (d.getHoekPunt1() == this.hoekPunt1 && d.getHoekPunt2() == this.hoekPunt2 && d.getHoekPunt3() == this.hoekPunt3);
        }
        return false;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Driehoek{" +
                "hoekPunt1=" + hoekPunt1 +
                ", hoekPunt2=" + hoekPunt2 +
                ", hoekPunt3=" + hoekPunt3 +
                '}';
    }

    public Omhullende getOmhullende() {
        int[] xen = {hoekPunt2.getX(), hoekPunt3.getX()};
        int[] yen = {hoekPunt2.getY(), hoekPunt3.getY()};
        int minX = hoekPunt1.getX();
        int maxX = hoekPunt1.getX();
        int minY = hoekPunt1.getY();
        int maxY = hoekPunt1.getY();
        for (int x : xen) {
            if (x < minX)
                minX = x;
            if (x > maxX)
                maxX = x;
        }
        for (int y : yen) {
            if (y < minY)
                minY = y;
            if (y > maxY)
                maxY = y;
        }
        return new Omhullende(new Punt(minX, minY), maxX - minX, maxY - minX);
    }

    @Override
    public void teken(Pane root) {

        Polyline driehoekteken = new Polyline();
        driehoekteken.setFill(Color.WHITE);
        driehoekteken.setStroke(Color.BLACK);
        driehoekteken.getPoints().addAll(new Double[]{(double) this.getHoekPunt1().getX(), (double) this.getHoekPunt1().getY(), (double) this.getHoekPunt2().getX(),
                (double) this.getHoekPunt2().getY(), (double) this.getHoekPunt3().getX(), (double) this.getHoekPunt3().getY()});

        root.getChildren().addAll(driehoekteken);
    }
}
