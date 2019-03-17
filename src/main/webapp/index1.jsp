
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index1</title>
</head>
<body>
<form action="/Homework4_war_exploded/index1" method="GET">
    Author: <input type="text" name="author">
    Content: <input type="text" name="content">
    <input type="submit" name="Wyślij">
</form>
<a href='<c:url value="/Servlet02" />'>Rozwiazanie zadania 2</a><br>
<a href='<c:url value="/Servlet03" />'>Rozwiazanie zadania 3</a><br>
<a href='<c:url value="/Servlet04_1" />'>Rozwiazanie zadania 4</a><br>
<a href='<c:url value="/Servlet05" />'>Rozwiazanie zadań 5, 6 i 7</a><br>
<a href='<c:url value="/newsletter" />'>Rozwiazanie zadania 8</a><br>
<a href='<c:url value="/guest-book" />'>Rozwiazanie zadania 9</a><br>
<a href='<c:url value="/Servlet08_01" />'>Rozwiazanie zadania 10</a><br>
</body>
</html>