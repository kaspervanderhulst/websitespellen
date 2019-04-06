package db.domain;

import domain.ScoreRecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ScoreRecordTabel {
    public static boolean nieuwScoreRecord(String username, long time, int score) {
        try {
            Connection conn = PgConnectie.openConnectie();
            PreparedStatement st = conn.prepareStatement("INSERT INTO scorerecord VALUES(?,?,?)");

            st.setString(1, username);
            st.setLong(2, time);
            st.setInt(3, score);
            //er wordt maar 1 rij toegevoegd, je kan ook met andere vergelijkingsoperatoren werken
            boolean gelukt = false;
            if (st.executeUpdate()==1) {
                gelukt = true;
            }
            st.close();
            PgConnectie.sluitConnectie(conn);
            return gelukt;
        }
                catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return false;
    }

    public static ArrayList<ScoreRecord> getHighscores() {
        try {
            Connection conn = PgConnectie.openConnectie();

            ArrayList<ScoreRecord> highscores = new ArrayList<>();

            PreparedStatement stRes = conn.prepareStatement("SELECT * FROM scorerecord ORDER BY score DESC fetch first 10 rows only");
            ResultSet rsRes = stRes.executeQuery();
            while (rsRes.next()) {
                highscores.add(new ScoreRecord(rsRes.getString(1), rsRes.getLong(2), rsRes.getInt(3)));
            }
            rsRes.close();
            PgConnectie.sluitConnectie(conn);
            return highscores;
        }
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        return null;
    }
}
