<%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 3/04/2019
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verwijder</title>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
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
<body>
<a href="verwijder?zeker=ja&woord=<%= request.getAttribute("woord") %>">JA</a>
<a href="verwijder?zeker=nee&woord=<%= request.getAttribute("woord") %>">NEE</a>
</body>
</html>
