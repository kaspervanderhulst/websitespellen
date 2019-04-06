package domain.model;

import java.util.ArrayList;

public class Woordenlijst {
    private ArrayList<Woord> woordenlijst;

    public Woordenlijst() {
        woordenlijst = new ArrayList<>();
        woordenlijst.add(new Woord("bla"));
        woordenlijst.add(new Woord("hey", "expert"));
        woordenlijst.add(new Woord("hoi", "beginner"));
    }

    public void addWoord(Woord woord) {
        if (woordenlijst.contains(woord)) {
            throw new DomainException();
        }
        woordenlijst.add(woord);
    }

    public Woord getLangsteWoord() {
        if (woordenlijst.size() > 0) {
            int langste = 0;
            Woord langsteWoord = woordenlijst.get(0);
            for (Woord woord : woordenlijst) {
                if (woord.getWoord().length() > langste) {
                    langste = woord.getWoord().length();
                    langsteWoord = woord;
                }
            }
            return langsteWoord;
        }
        return new Woord("");
    }

    public Woord getWoord(String woord) {
        for (Woord w : woordenlijst) {
            if (w.getWoord().equals(woord))
                return w;
        }
        return null;
    }

    public void verwijder(String woord) {
        Woord w = null;
        for(Woord wo : woordenlijst) {
            if (wo.getWoord().equals(woord))
                w = wo;
        }
        woordenlijst.remove(w);
    }

    public void veranderWoord(String woord, String niveau, String old) {
        Woord w = getWoord(old);
        w.setNiveau(niveau);
        w.setWoord(woord);
    }

    public ArrayList<Woord> getNiveau(String niveau) {
        ArrayList<Woord> woorden = new ArrayList<>();
        for (Woord woord : woordenlijst) {
            if(woord.getNiveau().equals(niveau))
                woorden.add(woord);
        }
        return woorden;
    }

    public Woord getKortsteWoord() {
        if (woordenlijst.size() > 0) {
            int kortste = 10000;
            Woord kortsteWoord = woordenlijst.get(0);
            for (Woord woord : woordenlijst) {
                if (woord.getWoord().length() < kortste) {
                    kortste = woord.getWoord().length();
                    kortsteWoord = woord;
                }
            }
            return kortsteWoord;
        }
        return new Woord("");
    }

    public int getAantalwoorden() {
        return woordenlijst.size();
    }

    public int getGemiddeldeLetters() {
        if (woordenlijst.size() == 0) {
            return 0;
        }
        else {
            int som = 0;
            for (Woord woord : woordenlijst) {
                som += woord.verschillendeLetters();
            }
            return som / woordenlijst.size();
        }
    }

    public ArrayList<Woord> getWoordenlijst() {
        return woordenlijst;
    }


}
