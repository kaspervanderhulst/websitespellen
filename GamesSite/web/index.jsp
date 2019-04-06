<%@ page import="domain.model.Woordenlijst" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Woordenlijst woordenlijst = (Woordenlijst) request.getAttribute("woordenlijstKlasse");
%>
<html>
<head>
    <link rel="stylesheet" href="css/stylesheet.css">
    <link rel="icon" type="image/png" href=" img/favicon.png" sizes="16x16"/>
    <title>Team 21 | Home</title>
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
    <div class="headertje">
        <div class="gridtest">

            <h1>Beheerapplicatie woordenlijst</h1>

            <h4>Met deze applicatie kun je de woordenlijst beheren om in het spelletje Hangman te gebruiken!</h4>
        </div>
        <div class="sectieXD">
            <section>
                <section>
                    <h3>Aantal woorden</h3>

                    <p><%= woordenlijst.getAantalwoorden() %>
                    </p>

                </section>

                <section>
                    <h3>Langste woord</h3>
                    <p><%= woordenlijst.getLangsteWoord() %>
                    </p>
                </section>
                <section>
                    <h3>Kortste woord</h3>
                    <p><%= woordenlijst.getKortsteWoord() %>
                    </p>
                </section>
                <section>
                    <h3>Gemiddeld aantal verschillende letters</h3>
                    <p><%= woordenlijst.getGemiddeldeLetters() %>
                    </p>
                </section>
            </section>
        </div>
    </div>


</main>
</body>
</html>