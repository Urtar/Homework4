<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index7.jsp</title>
</head>
<body>

<form action="/Homework4_war_exploded/newsletter" method="POST">
    <div></div>
    <text>
        Czym jest Lorem Ipsum?
        Lorem Ipsum jest tekstem stosowanym
        jako przykładowy wypełniacz w przemyśle
        poligraficznym. Został po raz pierwszy
        użyty w XV w. przez nieznanego drukarza
        do wypełnienia tekstem próbnej książki.
        Pięć wieków później zaczął być używany
        przemyśle elektronicznym, pozostając
        praktycznie niezmienionym. Spopularyzował
        się w latach 60. XX w. wraz z publikacją
        arkuszy Letrasetu, zawierających fragmenty
        Lorem Ipsum, a ostatnio z zawierającym różne
        wersje Lorem Ipsum oprogramowaniem
        przeznaczonym do realizacji druków na
        komputerach osobistych, jak Aldus PageMaker
    </text>
    </div>
    Zapisz się na newsletter?
    <label>
        Name: <input type="text" name="name">
    </label>
    <label>
        email: <input type="text" name="email">
    </label>
    <input type="submit" name="Wyślij">
</form>
</body>
</html>