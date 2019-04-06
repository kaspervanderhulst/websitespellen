package domain.model;

import java.util.ArrayList;
import java.util.Random;

public class WoordenLijstHg {
        private ArrayList<Woord> woordenlijst;

        public WoordenLijstHg(Woordenlijst wl) {
            woordenlijst = wl.getWoordenlijst();
        }

        public String getRandomWoord() {
            Random r = new Random();
            int number = r.nextInt(woordenlijst.size());
            return woordenlijst.get(number).getWoord();
        }
}
