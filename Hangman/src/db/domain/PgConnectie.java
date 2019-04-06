package db.domain;

import java.sql.*;
import java.util.*;

public class PgConnectie {

    public static Connection openConnectie() {

        String url = "jdbc:postgresql://193.191.176.74:5432/projectweek";
        Properties props = new Properties();

        try {
            props.setProperty("user", "projectweek");
            props.setProperty("password", "projectweek");
            //props.setProperty("currentSchema","");

            Connection conn = DriverManager.getConnection(url, props);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public static void sluitConnectie(Connection c) {
        try {
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Databank connectie gesloten");
    }
}