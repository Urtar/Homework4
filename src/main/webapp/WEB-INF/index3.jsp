<%--
  Created by IntelliJ IDEA.
  User: arturszczepanek
  Date: 2019-03-13
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>index3.jsp</title>
</head>
<body>
<c:set var="someName" value="Witaj w .coderslab."/>
<c:forTokens items="${someName}" delims="."  var="site">
    <%--<c:out value="${site}"/> <br/>--%>
    <c:if test="${site == 'coderslab'}">
        Jest ok - jest param
    </c:if>
</c:forTokens>

</body>
</html>

<%--Zadanie 3--%>

<%--W projekcie stwórz stronę jsp index3.jsp. Następnie:--%>

<%--Za pomocą odpowiedniej funkcji jstl sprawdź czy ustawiony za pomocą poniższego tagu ciąg znaków zawiera napis coderslab:--%>
<%--<c:set var="someName" value="Witaj w coderslab."/>--%>
<%--Jeżeli napis zawiera coderslab w instrukcji sterującej wypisz na stronie <p>OK</p>.--%>