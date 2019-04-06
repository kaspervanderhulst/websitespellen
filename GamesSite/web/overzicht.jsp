<%@ page import="domain.model.Woordenlijst" %>
<%@ page import="domain.model.Woord" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Andreas
  Date: 3/04/2019
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Woord> woordenlijst = (ArrayList<Woord>) request.getAttribute("woordenlijstLijst");
%>
<html>
<head>
    <link rel="stylesheet" href="css/stylesheet.css">
    <link rel="icon" type="image/png" href=" img/favicon.png" sizes="16x16"/>
    <title>Woordenlijst</title>
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
<main>
    <h1> Woordenlijst</h1>
    <div class="sectieXD">
        <a href="overzicht?command=download">Download woordenlijst</a>

        <a href="overzicht?filter=expert">Expert</a>
        <a href="overzicht?filter=beginner">Beginner</a>

        <ol>
            <%
                for (Woord woord : woordenlijst) {
            %>
            <li><span><%= woord.getWoord() %></span><span><%= woord.getNiveau() %></span></li>
            <form action="overzicht" method="post"><input type="hidden" name="woord"
                                                          value="<%= woord.getWoord() %>"><input name="command"
                                                                                                 type="hidden"
                                                                                                 value="verwijder">
                <button type="submit">Delete</button>
            </form>
            <form action="overzicht" method="post"><input type="hidden" name="woord"
                                                          value="<%= woord.getWoord() %>"><input name="command"
                                                                                                 type="hidden"
                                                                                                 value="change">
                <button type="submit">Wijzig</button>
            </form>
            <%
                }
            %>
        </ol>
    </div>


</main>
</body>
</html>
