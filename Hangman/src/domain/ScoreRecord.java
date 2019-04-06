package domain;

public class ScoreRecord {
    private String username;
    private long time;
    private int score;

    public ScoreRecord(String username, long time, int score) {
        this.username = username;
        this.time = time;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public long getTime() {
        return time;
    }

    public int getScore() {
        return score;
    }
}
