package domain.model;

public class HintLetter {
    private char letter;
    private boolean isGeraden;

    public HintLetter(char letter) {
        this.letter = Character.toLowerCase(letter);
        this.isGeraden = false;
    }

    public char getLetter() {
        return letter;
    }

    public boolean raad(char l){
        if (isGeraden && Character.toLowerCase(l) == letter) {
            return false;
        }
        if (Character.toLowerCase(l) == letter) {
            isGeraden = true;
            return true;
        }
        else {
            return false;
        }
    }

    public char toChar(){
        if (!isGeraden) {
            return '_';
        }
        return letter;
    }

    public boolean isGeraden(){
        return isGeraden;
    }
}
