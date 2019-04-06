package db.domain;

import domain.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class GalgReader {
    public static ArrayList<Vorm> geefVormen(String filename) throws FileNotFoundException {
        ArrayList<Vorm> vormen = new ArrayList<>();
        ArrayList<String> lijnen = GalgReader.geefLijnen(filename);
        int amountVisible = 0;
        try {
            amountVisible = Integer.parseInt(lijnen.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 1; i < lijnen.size(); i++) {
            String[] split = lijnen.get(i).split("\\s+");

            Vorm vorm = null;

            try {
                switch (split[0]) {
                    case "Cirkel":
                        vorm = new Cirkel(new Punt(Integer.parseInt(split[1]), Integer.parseInt(split[2])), Integer.parseInt(split[3]));
                        break;
                    case "Rechthoek":
                        vorm = new Rechthoek(new Punt(Integer.parseInt(split[1]), Integer.parseInt(split[2])), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
                        break;
                    case "Driehoek":
                        vorm = new Driehoek(new Punt(Integer.parseInt(split[1]), Integer.parseInt(split[2])), new Punt(Integer.parseInt(split[3]), Integer.parseInt(split[4])), new Punt(Integer.parseInt(split[5]), Integer.parseInt(split[6])));
                        break;
                    case "Lijnstuk":
                        vorm = new LijnStuk(new Punt(Integer.parseInt(split[1]), Integer.parseInt(split[2])), new Punt(Integer.parseInt(split[3]), Integer.parseInt(split[4])));
                        break;
                    default:
                        throw new IllegalArgumentException("Je kan enkel een Cirkel, Rechthoek, Driehoek of Lijnstuk toevoegen");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (vorm != null) {
                if (amountVisible-- > 0)
                    vorm.setZichtbaar(true);
                else
                    vorm.setZichtbaar(false);
                vormen.add(vorm);
            }
        }

        return vormen;
    }

    public static ArrayList<String> geefLijnen(String filename) throws java.io.FileNotFoundException {
        Scanner reader = new Scanner(new File(filename));
        ArrayList<String> lijnen = new ArrayList<>();
        while (reader.hasNext()) {
            lijnen.add(reader.nextLine());
        }
        return lijnen;
    }
}
