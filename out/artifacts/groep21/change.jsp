<%@ page import="domain.model.Woord" %><%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 3/04/2019
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wijzig</title>
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
<form action="overzicht?command=verander" method="post">
    <input type="hidden" name="old" value="<%= ((Woord) request.getAttribute("woord")).getWoord() %>">
    <label for="woord">Woord</label>
    <input value="<%= ((Woord) request.getAttribute("woord")).getWoord() %>" required="required" type="text" id="woord" name="woord">
    <label for="niveau">Niveau</label>
    <select name="niveau" id="niveau">
        <%
            String niveau = ((Woord) request.getAttribute("woord")).getNiveau();
            if (niveau.equals("expert")) {
        %>
        <option value="expert">Expert</option>
        <option value="beginner">Beginner</option>
        <%
            }
            else {
        %>
        <option value="beginner">Beginner</option>
        <option value="expert">Expert</option>
        <%
            }
        %>
    </select>

    <input type="submit" value="Send">
</form>
</body>
</html>
