package domain.model;

public class HangMan {
    private Speler speler;
    private HintWoord hintWoord;
    private boolean gewonnen;
    private int moves;

    public HangMan(Woordenlijst wl) {
        speler = new Speler("random");
        moves = 0;

        hintWoord = new HintWoord((new WoordenLijstHg(wl)).getRandomWoord());
    }

    public Speler getSpeler() {
        return speler;
    }

    public String getHint() {
        return hintWoord.toString();
    }

    public String getWoord(){return hintWoord.getWoord();}

    public boolean isGameOver() {
        return moves >= 14;
    }

    public boolean isGewonnen() {
        return gewonnen;
    }

    public boolean raad(char l) {
        boolean returnVal;
        if (hintWoord.raad(l)) {
            gewonnen =  hintWoord.isGeraden();
            returnVal = true;
        }
        else {
            moves++;
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
            moves += 3;
            returnVal = false;
        }
        return returnVal;
    }

    public int getMoves() {
        return moves;
    }
}
