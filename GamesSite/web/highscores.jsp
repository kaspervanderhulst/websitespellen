<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.model.ScoreRecord" %><%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 5/04/2019
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<ScoreRecord> highscores = (ArrayList<ScoreRecord>) request.getAttribute("highscores");
%>
<html>
<head>
    <title>Highscores</title>
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
<table>
    <th><td>username</td><td>moves</td></th>
<%
    for (ScoreRecord score : highscores) {
%>
    <tr><td><%= score.getUsername() %></td><td><%= score.getScore() %></td></tr>
<%
    }
%>
</table>

</body>
</html>
