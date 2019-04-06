package domain;

public class Omhullende {
    private Punt linkerBovenhoek;
    private int breedte, hoogte;

    public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
        if (linkerBovenhoek == null || hoogte < 0 || breedte < 0)
            throw new DomainException();
        this.linkerBovenhoek = linkerBovenhoek;
        this.breedte = breedte;
        this.hoogte = hoogte;
    }

    public int getMinimumX() {
        return linkerBovenhoek.getX();
    }

    public int getMinimumY() {
        return linkerBovenhoek.getX();
    }

    public int getMaximumX() {
        return linkerBovenhoek.getX() + getBreedte();
    }

    public int getMaximumY() {
        return linkerBovenhoek.getY() + getHoogte();
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
        if (! (o instanceof Omhullende))
            return false;
        return breedte == ((Omhullende) o).breedte && hoogte == ((Omhullende) o).hoogte && linkerBovenhoek == ((Omhullende) o).linkerBovenhoek;
    }

    public String toString(){
        return linkerBovenhoek.toString() + " - " + getBreedte() + " - " + getHoogte();
    }
}
