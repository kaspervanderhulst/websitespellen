package domain;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class TekeningHangMan extends Tekening {

    public TekeningHangMan(String naam, String filename) throws FileNotFoundException {
        super(naam, filename);
    }

    public TekeningHangMan() {
        super("Hangman");
        Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
        galgBodem.setZichtbaar(true);
        Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50));
        galgStaaf.setZichtbaar(true);
        Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));
        hangbar.setZichtbaar(true);
        Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));
        koord.setZichtbaar(true);
        Vorm hoofd = new Cirkel(new Punt(280, 125), 25);
        hoofd.setZichtbaar(false);
        Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);
        oogLinks.setZichtbaar(false);
        Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
        oogRechts.setZichtbaar(false);
        Vorm neus = new Cirkel(new Punt(280, 128), 2);
        neus.setZichtbaar(false);
        Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
        mond.setZichtbaar(false);
        Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
        lijf.setZichtbaar(false);
        Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
        beenLinks.setZichtbaar(false);
        Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
        beenRechts.setZichtbaar(false);
        Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
        voetLinks.setZichtbaar(false);
        Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
        voetRechts.setZichtbaar(false);
        Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
        armLinks.setZichtbaar(false);
        Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
        armRechts.setZichtbaar(false);
        Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
        handLinks.setZichtbaar(false);
        Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
        handRechts.setZichtbaar(false);
        super.voegToe(galgBodem);
        super.voegToe(galgStaaf);
        super.voegToe(hangbar);
        super.voegToe(koord);
        super.voegToe(hoofd);
        super.voegToe(oogLinks);
        super.voegToe(oogRechts);
        super.voegToe(neus);
        super.voegToe(mond);
        super.voegToe(lijf);
        super.voegToe(beenLinks);
        super.voegToe(beenRechts);
        super.voegToe(voetLinks);
        super.voegToe(voetRechts);
        super.voegToe(armLinks);
        super.voegToe(armRechts);
        super.voegToe(handLinks);
        super.voegToe(handRechts);
    }

    public int getAantalOnzichtbaar(){
        int onzichtbaar = 0;
        for (Vorm vorm : this.getVormen()) {
            if (!vorm.isZichtbaar())
                onzichtbaar++;
        }
        return onzichtbaar;
    }

    public boolean gameOver() {
        return getVormen().get(getAantalVormen()-1).isZichtbaar();
    }

    public void zetVolgendeZichtbaar(){
        for (Vorm vorm : getVormen()) {
            if (!vorm.isZichtbaar()) {
                vorm.setZichtbaar(true);
                return;
            }
        }
    }

    public void voegToe(Vorm v){
        super.voegToe(v);
    }

    public void verwijder(Vorm v){
        super.verwijder(v);
    }






}
