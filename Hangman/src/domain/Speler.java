package domain;

public class Speler {
    private String naam;
    private int score;

    public Speler(String naam) {
        if (naam == null || naam.trim().length() == 0)
            throw new DomainException();
        this.naam = naam;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getNaam() {
        return naam;
    }

    public void addToScore(int punten) {
        if (score + punten < 0)
            throw new DomainException();
        score += punten;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Speler))
            return false;
        return naam.equals(((Speler) obj).naam) && score == ((Speler) obj).score;
    }

    @Override
    public String toString() {
        return "Naam: " + naam + " Score: " + score;
    }
}
