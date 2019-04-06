package ui.Controller;

import db.domain.ScoreRecordTabel;
import domain.model.HangMan;
import domain.model.ScoreRecord;
import domain.model.Woord;
import domain.model.Woordenlijst;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@WebServlet(urlPatterns = {"", "/home", "/woordtoevoegen", "/overzicht", "/verwijder", "/game", "/highscores"})
public class Servlet extends HttpServlet {
    private Woordenlijst woordenlijst = new Woordenlijst();
    private HashMap<String, HangMan> games = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        request.setAttribute("woordenlijstKlasse", woordenlijst);

        switch (path) {
            case "/highscores":
                toHighscores(request, response);
            case "/game":
                handleGame(request, response);
                break;
            case "/verwijder":
                handleVerwijder(request, response);
                break;
            case "/home":
                sendTo(request, response, "index.jsp");
                break;
            case "/overzicht":
                handleOverzicht(request, response);
                break;
            case "/woordtoevoegen":
                handleWoordToevoegen(request, response);
                break;
            default:
                sendTo(request, response, "index.jsp");
                break;
        }
    }

    private void handleVerwijder(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String zeker = request.getParameter("zeker");
        if (zeker == null)
            zeker = "nee";

        if (zeker.equals("ja")) {
            String woord = request.getParameter("woord");
            woordenlijst.verwijder(woord);
        }
        response.sendRedirect("overzicht");
    }

    private void handleOverzicht(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String filter = request.getParameter("filter");
        if (filter == null)
            filter = "";
        switch (filter) {
            case "beginner":
                request.setAttribute("woordenlijstLijst", woordenlijst.getNiveau("beginner"));
                break;
            case "expert":
                request.setAttribute("woordenlijstLijst", woordenlijst.getNiveau("expert"));
                break;
            default:
                request.setAttribute("woordenlijstLijst", woordenlijst.getWoordenlijst());
        }
        String command = request.getParameter("command");
        if (command == null)
            command = "";


        switch (command) {
            case "verwijder":
                String w = request.getParameter("woord");
                request.setAttribute("woord", w);
                sendTo(request, response, "verwijder.jsp");
                break;
            case "change":
                String wo = request.getParameter("woord");
                request.setAttribute("woord", woordenlijst.getWoord(wo));
                sendTo(request, response, "change.jsp");
            case "verander":
                String woo = request.getParameter("woord");
                woordenlijst.veranderWoord(request.getParameter("woord"), request.getParameter("niveau"), request.getParameter("old"));
                sendTo(request, response, "overzicht.jsp");
            case "download":
                String filename = "woorden.txt";
                response.setContentType("APPLICATION/OCTET-STREAM");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                PrintWriter out = response.getWriter();
                for (Woord woord : woordenlijst.getWoordenlijst())
                    out.println(woord.getWoord());
                out.close();
                break;
            default:
                sendTo(request, response, "overzicht.jsp");
        }
    }

    private void toHighscores(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        ArrayList<ScoreRecord> highscores = ScoreRecordTabel.getHighscores();
        request.setAttribute("highscores", highscores);
        sendTo(request, response, "highscores.jsp");
    }

    private void handleGame(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null)
            command = "";

        switch (command) {
            case "move":
                handleMove(request, response);
                break;
            default:
                String key = generateKey();
                request.setAttribute("key", key);
                HangMan game = new HangMan(woordenlijst);
                games.put(key, game);
                request.setAttribute("key", key);
                request.setAttribute("hangman", game);
                sendTo(request, response, "game.jsp");
        }
    }

    private void handleMove(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        response.setContentType("text/plain");
        String key = request.getParameter("key");
        String letter = request.getParameter("letter");
        String woord = request.getParameter("woord");

        System.out.println(key+ woord+ letter);

        String result;
        HangMan game = games.get(key);
        if (woord.trim().length() > 0) {
            game.raadWoord(woord);
        }
        else {
            game.raad(letter.charAt(0));
        }
        if (game.isGewonnen() || game.isGameOver()) {
            String username = request.getParameter("username");
            ScoreRecordTabel.nieuwScoreRecord(username, (new Date().getTime())/1000, game.getMoves());
            result = "{\"done\": true, \"zichtbaar\": "+game.getMoves()+", \"hint\": \""+game.getHint()+"\"}";
        }
        else {
            result = "{\"done\": false, \"zichtbaar\": "+game.getMoves()+", \"hint\": \""+game.getHint()+"\"}";
        }
        PrintWriter out = response.getWriter();
        out.print(result);
    }

    private void handleWoordToevoegen(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String command = request.getParameter("command");
        if (command == null)
            command = "";

        switch (command) {
            case "add":
                try {
                    add(request, response);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                request.setAttribute("woordenlijstLijst", woordenlijst.getWoordenlijst());
                sendTo(request, response, "overzicht.jsp");
                break;
            default:
                sendTo(request, response, "formulier.jsp");
        }
    }

    private void sendTo(HttpServletRequest request, HttpServletResponse response, String destination) throws
            ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String woord = request.getParameter("woord");
        String niveau = request.getParameter("niveau");
        if (woord != null && !woord.isEmpty()) {
            Woord w = new Woord(woord, niveau);
            woordenlijst.addWoord(w);
            sendTo(request, response, "overzicht.jsp");

        } else
            sendTo(request, response, "formulier.jsp");

    }

    private static String generateKey() {
        String key = "";
        for (int i = 0; i < 20; i++) {
            key += ThreadLocalRandom.current().nextInt(0, 10);
        }
        return key;
    }
}

