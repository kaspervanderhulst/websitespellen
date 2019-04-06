package domain;

public class Punt {
    private int x,y;

    public Punt(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object o) {

        if(o instanceof Punt) {
            Punt p = (Punt) o;
            return (p.getX() == this.getX() && p.getY() == this.getY());
        }
        return false;
    }

    public String toString() {
        return "(" + getX() + ", " + getY() + ")";
    }
}
