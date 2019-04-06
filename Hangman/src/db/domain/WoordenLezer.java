package db.domain;

import domain.WoordenLijst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WoordenLezer {
    private String filename;
    public WoordenLezer(String filename) {
        this.filename = filename;
    }

    public WoordenLijst lees() throws FileNotFoundException {
        return new WoordenLijst(filename);
    }

    public static ArrayList<String> geefWoordenVanFile(String filename) throws java.io.FileNotFoundException {
        Scanner reader = new Scanner(new File(filename));
        ArrayList<String> woorden = new ArrayList<>();
        while (reader.hasNext()) {
            woorden.add(reader.nextLine());
        }
        return woorden;
    }
}
