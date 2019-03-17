
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>allQuotes</title>
</head>
<body>
<table>
    <c:forEach items="${tabelka}" var="tabArr" step="2">
        <tr>
            <td>${tabArr}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>