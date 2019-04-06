package domain;

import java.io.FileNotFoundException;

public class HangMan {
    private Speler speler;
    private TekeningHangMan tekeningHangMan;
    private WoordenLijst woordenLijst;
    private HintWoord hintWoord;
    private boolean gewonnen;
    private int punten;

    public HangMan(Speler s, WoordenLijst wl) throws FileNotFoundException {
        if (s == null || wl == null || wl.getAantalWoorden() == 0)
            throw new DomainException();

        punten = 100;

        speler = s;
        woordenLijst = wl;

        tekeningHangMan = new TekeningHangMan("Hangman", "src/db/galg.txt");
        hintWoord = new HintWoord(woordenLijst.getRandomWoord());
    }

    public Speler getSpeler() {
        return speler;
    }

    public TekeningHangMan getTekening() {
        return tekeningHangMan;
    }

    public String getHint() {
        return hintWoord.toString();
    }

    public String getWoord(){return hintWoord.getWoord();}

    public boolean isGameOver() {
        return tekeningHangMan.gameOver();
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public boolean raad(char l) {
        punten--;
        boolean returnVal;
        if (hintWoord.raad(l)) {
            gewonnen =  hintWoord.isGeraden();
            returnVal = true;
        }
        else {
            tekeningHangMan.zetVolgendeZichtbaar();

            returnVal = false;
        }
        return returnVal;
    }

    public boolean raadWoord(String w){
        boolean returnVal;
        if(hintWoord.raadWoord(w)){
            gewonnen = true;
            returnVal = true;
        }else {
            tekeningHangMan.zetVolgendeZichtbaar();
            returnVal = false;
        }
        return returnVal;
    }

    public int getPunten() {
        return punten;
    }
}
