<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index5.jsp</title>
</head>
<body>
${languageSet}
<form action="/Homework4_war_exploded/Servlet05" method="POST">
    <select name="departure">
        <option value="">--Lotnisko wylotu--</option>
        <c:forEach items="${airport}" var="airportName"><br>
            <option value="${airportName.name}">${airportName.name} Strefa: ${airportName.timezone}</option>
        </c:forEach>
    </select>
    <select name="arrival">
        <option value="">--Lotnisko przylotu--</option>
        <c:forEach items="${airport}" var="airportName"><br>
            <option value="${airportName.name}">${airportName.name} Strefa: ${airportName.timezone}</option>
        </c:forEach>
    </select>
    Długość lotu: <input type="number" name="duration" min="0", step="1"><br>
    Cena lotu: <input type="number" name="price" min="0", step="0.01"><br>
    <input type="submit" name="Wyślij">
</form>
</body>
</html>