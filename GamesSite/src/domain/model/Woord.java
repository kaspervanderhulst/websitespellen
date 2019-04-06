package domain.model;

import java.util.ArrayList;

public class Woord {
    private String woord;
    private String niveau;

    public Woord(String woord) {
        this(woord, null);
    }

    public Woord(String woord, String niveau) {
        this.woord = woord;
        this.niveau = niveau;
    }

    public String getNiveau() {
        if (niveau == null) {
            return "";
        }
        return niveau;
    }

    public String getWoord() {
        return woord;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Woord))
            return false;
        if (woord.equals(((Woord) obj).woord)) {
            if (niveau == null) {
                return ((Woord) obj).niveau == null;
            }
            else {
                return niveau.equals(((Woord) obj).niveau);
            }
        }
        return false;
    }

    public int verschillendeLetters() {
        ArrayList<Character> seen = new ArrayList<>();
        for (int i = 0; i < woord.length(); i++) {
            if (!seen.contains(woord.charAt(i))) {
                seen.add(woord.charAt(i));
            }
        }
        return seen.size();
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setWoord(String woord) {
        this.woord = woord;
    }

    @Override
    public String toString() {
        return woord;
    }
}
