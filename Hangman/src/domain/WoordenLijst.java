package domain;

import db.domain.WoordenLezer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {
    private ArrayList<String> woordenlijst;

    public WoordenLijst() {
        woordenlijst = new ArrayList<>();
    }

    public WoordenLijst(String filenaam) throws FileNotFoundException {
        woordenlijst = WoordenLezer.geefWoordenVanFile(filenaam);
    }

    public int getAantalWoorden() {
        return woordenlijst.size();
    }

    public void voegToe(String woord) {
        if (woord == null || woord.trim().length() == 0 || woordenlijst.contains(woord))
            throw new DomainException();
        woordenlijst.add(woord);
    }

    public String getRandomWoord() {
        Random r = new Random();
        int number = r.nextInt(woordenlijst.size());
        return woordenlijst.get(number);
    }
}
