package domain;

import db.domain.GalgReader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Tekening implements Drawable {
    private String naam;
    private List<Vorm> vormen;
    private final int MIN_X, MAX_X, MIN_Y, MAX_Y;

    public Tekening() {
        MIN_X = 0;
        MIN_Y = 0;
        MAX_X = 1000;
        MAX_Y = 1000;
    }

    public Tekening(String naam) {
        this();
        if (!isValidNaam(naam))
            throw new IllegalArgumentException();
        this.naam = naam;
        vormen = new ArrayList<>();
    }

    public Tekening(String naam, String filename) throws FileNotFoundException {
        this(naam);
        vormen = GalgReader.geefVormen(filename);
    }

    public static boolean isValidNaam(String naam) {
        return !(naam == null) && !(naam.trim().length() == 0);
    }

    public String getNaam() {
        return naam;
    }

    public void voegToe(Vorm vorm) {
        Omhullende omh = vorm.getOmhullende();
        if (omh.getMinimumX() < MIN_X || omh.getMinimumY() < MIN_Y || omh.getMaximumX() > MAX_X || omh.getMaximumY() > MAX_Y)
            throw new IllegalArgumentException();
        vormen.add(vorm);
    }

    public Vorm getVorm(int nummer) {
        return vormen.get(nummer);
    }

    public int getAantalVormen() {
        return vormen.size();
    }

    public void verwijder(Vorm vorm) {
        vormen.remove(vorm);
    }

    public boolean bevat(Vorm vorm) {
        return vormen.contains(vorm);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Tekening))
            return false;
        for (Vorm vorm : vormen) {
            if (!((Tekening) obj).vormen.contains(vorm))
                return false;
        }
        for (Vorm vorm : ((Tekening) obj).vormen) {
            if (!vormen.contains(vorm))
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public void teken(Pane root) {
        for (Vorm v : vormen) {
            if(v.isZichtbaar()){
                v.teken(root);
            }
        }
    }

    public List<Vorm> getVormen() {
        return vormen;
    }
}

