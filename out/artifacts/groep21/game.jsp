<%@ page import="domain.model.HangMan" %><%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 5/04/2019
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HangMan hangman = (HangMan) request.getAttribute("hangman");
%>
<html>
<head>
    <title>Hangman</title>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/p5/p5.min.js"></script>
    <script src="js/p5/addons/p5.dom.min.js"></script>
    <script src="js/p5/addons/p5.sound.min.js"></script>
    <script src="js/hangman.js"></script>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<body>
<header>
    <nav>
        <ul>
            <li><a href="home">Home</a></li>
            <li><a href="overzicht">Overzicht</a></li>
            <li><a href="woordtoevoegen">Woord toevoegen</a></li>
            <li><a href="game">Play</a></li>
            <li><a href="highscores">Highscores</a></li>
        </ul>
    </nav>
</header>
<article id="gamePage">
    <section id="canvas"></section>
    <section>
        <p id="hint"><%= hangman.getHint() %>
        </p>

        <form>
            <input id="key" type="hidden" value="<%= request.getAttribute("key") %>">
            <label for="username">Username</label>
            <input name="username" id="username" type="text" value="">
            <label for="letter">Geef een letter</label>
            <input name="letter" id="letter" type="text" value="">
            <label for="woord">Of raad het volledige woord</label>
            <input name="woord" id="woord" type="text" value="">
        </form>
        <button onclick="sendMove()">Gok</button>
        <p id="link" style="display: none">This game is over, go to highscores to see your score</p>
    </section>
</article>
</body>
</html>
