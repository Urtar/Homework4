<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index4.jsp</title>
</head>
<body>
${languageSet}
<form action="/Homework4_war_exploded/Servlet04_2" method="POST">
    <select name="languageSelect">
        <option value="">--Please choose an option--</option>
<c:forEach items="${langF}" var="langAtrr">
        <option value="${langAtrr.key}">${langAtrr.key}</option>
</c:forEach>
    </select>
    <input type="submit" name="Wyślij">
</form>
</body>
</html>
