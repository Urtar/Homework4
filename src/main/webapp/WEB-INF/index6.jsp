<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index6.jsp</title>
</head>
<body>
<table>
    <label>
        <tr>
            <th>
                Departure airport: ${flight.departure}
            </th>
        </tr>
        <tr>
            <td>
                Living time: ${departureTime}
            </td>
        </tr>
        <tr>
            <td>
                Airport code: ${airportDeparture.code}
            </td>
        </tr>
    </label>
    <label>
        <tr>
            <th>
                Arrival airport: ${flight.arrival}
            </th>
        </tr>
        <tr>
            <td>
                Arrival time: ${arrivalTime1}
            </td>
        </tr>
        <tr>
            <td>
                Airport code: ${airportArrival.code}
            </td>
        </tr>
    </label>
    <label>
        <tr>
            <th>
                Duration: ${duration} hours
            </th>
        </tr>
        <tr>
            <th>
                Price: ${flight.price} pln
            </th>
        </tr>
    </label>
</table>

</body>
</html>