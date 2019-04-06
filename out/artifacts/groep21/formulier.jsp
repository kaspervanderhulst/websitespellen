<%--
  Created by IntelliJ IDEA.
  User: kasper
  Date: 03/04/2019
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Woord toevoegen</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/stylesheet.css">
    <link rel="icon" type="image/png" href=" img/favicon.png" sizes="16x16"/>
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
<main class="contact">
    <form action="woordtoevoegen?command=add" method="post">
        <p>Hier kan je een woord toevoegen. Het woord is verplicht, de moeilijkheid niet</p>
        <p>
            <label for="woord">Woord</label>
            <input required="required" type="text" id="woord" name="woord">
        </p>
        <p>
            <label for="niveau">Niveau</label>
            <select name="niveau" id="niveau">
                <option value="beginner">Beginner</option>
                <option value="expert">Expert</option>
            </select>
        </p>
        <p><input type="submit" value="Send"></p>
    </form>
</main>


</body>
</html>
