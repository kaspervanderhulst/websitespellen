package domain;

import java.awt.*;

public abstract class Vorm implements Drawable{
    private Color kleur;
    private boolean isZichtbaar;

    public void setKleur(Color kleur) {
        this.kleur = kleur;
        this.isZichtbaar = true;
    }

    public Color getKleur() {
        return kleur;
    }

    public boolean isZichtbaar(){
        return isZichtbaar;
    }

    public void setZichtbaar(boolean zichtbaar) {
        isZichtbaar = zichtbaar;
    }

    public String toString(){
        return "kleur" + getKleur();
    }

    abstract Omhullende getOmhullende();
}
