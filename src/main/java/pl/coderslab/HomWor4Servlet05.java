package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.*;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.List;

@WebServlet(name = "HomWor4Servlet05", urlPatterns = {"/Servlet05"})
public class HomWor4Servlet05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        AirportDao airportDao = new AirportDao();
        List<Airport> airportDao1 = airportDao.getList();
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");
        String departureZone = null;
        String arrivalZone = null;
        Airport airportDeparture;
        Airport airportArrival;
        for (Airport a : airportDao1) {
            if (a.getName().equals(departure)) {
                airportDeparture = new Airport(a.getName(),a.getCode(),a.getTimezone());
                request.setAttribute("airportDeparture", airportDeparture);
                departureZone = a.getTimezone();
                request.setAttribute("departureTime",LocalTime.now(ZoneId.of(departureZone)));
            }
            if (a.getName().equals(arrival)) {
                airportArrival = new Airport(a.getName(),a.getCode(),a.getTimezone());
                request.setAttribute("airportArrival", airportArrival);
                arrivalZone = a.getTimezone();
            }
        }
        Double price = null;
        Integer duration = null;
        try {
            duration = Integer.parseInt(request.getParameter("duration"));
            request.setAttribute("duration", duration);
        } catch (Exception e) {
            response.getWriter().append("Nieprawidłowa długość lotu" + "<br>");
            response.getWriter().append("<a href='/Homework4_war_exploded/Servlet05'>Powrót do formularza</a>");
        }
        try {
            price = Double.parseDouble(request.getParameter("price").replace(",", "."));
        } catch (Exception e) {
            response.getWriter().append("Nieprawidłowa cena biletu" + "<br>");
            response.getWriter().append("<a href='/Homework4_war_exploded/Servlet05'>Powrót do formularza</a>");
        }
        if (departure.equals(arrival)) {
            response.getWriter().append("Podano to samo lotnisko wylotu i przylotu" + "<br>");
            response.getWriter().append("<a href='/Homework4_war_exploded/Servlet05'>Powrót do formularza</a>");
        } else if (duration == null || price == null) {
            response.getWriter().append("Niepodano czasu lotu lub ceny biletu" + "<br>");
            response.getWriter().append("<a href='/Homework4_war_exploded/Servlet05'>Powrót do formularza</a>");
        } else if (price == 0) {
            response.getWriter().append("Nieprawidłowa cena biletu musi być większa od 0.00" + "<br>");
            response.getWriter().append("<a href='/Homework4_war_exploded/Servlet05'>Powrót do formularza</a>");
        }

        Duration d = Duration.between(ZonedDateTime.now(ZoneId.of(departureZone)), ZonedDateTime.now(ZoneId.of(arrivalZone)));
      //  response.getWriter().append(d.toString() + "<br>");
        ZonedDateTime arrivalTime = ZonedDateTime.now(ZoneId.of(arrivalZone)).plusHours(duration);
        LocalTime arrivalTime1 = LocalTime.now(ZoneId.of(arrivalZone));
        request.setAttribute("arrivalTime", arrivalTime1);
        Flight flight = new Flight(departure, arrival, arrivalTime.toString(), price);
        request.setAttribute("flight", flight);
        getServletContext().getRequestDispatcher("/WEB-INF/index6.jsp").forward(request,response);
//        response.getWriter().append(flight.toString() + "<br>");
//        response.getWriter().append("Wylot z: " + departure + " " + departureZone + "<br>");
//        response.getWriter().append("Przylot do: " + arrival + " " + arrivalZone + "<br>");
//        response.getWriter().append("Długość lotu: " + duration + "<br>");
//        response.getWriter().append("Cena lotu: " + price);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        AirportDao airportDao = new AirportDao();
        request.setAttribute("airport", airportDao.getList());
        getServletContext().getRequestDispatcher("/WEB-INF/index5.jsp").forward(request, response);
    }

    static long dateTimeDifference(Temporal d1, Temporal d2, ChronoUnit unit) {
        return unit.between(d1, d2);
    }
}


//Zadanie 5
//
//        Zapoznaj się z wzorcem DAO - [Wikipedia] dao-wiki.
//
//        Jest to wzorzec podobny do znanego już nam ActiveRecords z tą różnicą, że wszystkie metody związane z operacjami na obiekcie są wydzielone do oddzielnej klasy np. ProductDao.
//
//        Klasy DAO powinny implementować przynajmniej zestaw operacji CRUD.
//
//        Skrót ten oznacza:
//
//        Create
//        Read
//        Update
//        Delete
//        W projekcie stwórz servlet, a w nim servlet Servlet_02 z obsługą metod doGet i doPost. Celem zadania jest stworzenie formularza do zamawiania biletu lotniczego. W tym celu:
//
//        Stwórz klasę Airport z następującymi polami:
//        Nazwa name.
//        Kod code.
//        Strefa czasową timezone.
//        Stwórz klasę AirportDao - a w niej metodę o sygnaturze List <Airport> getList()- metoda wczyta z pliku airports.txt dane w postaci CSV, utworzy na ich podstawie obiekty klasy Airport, które następnie doda do ArrayListy.
//        Stwórz, w pliku jsp, formularz, który przesyła dane metodą POST. Formularz powinien zawierać:
//        Lotnisko wylotu - pole select (dane pobrane przez dao).
//        Lotnisko przylotu - pole select(dane pobrane przez dao).
//        Czas startu - pole datetime-local (będzie to czas wylotu w czasie lokalnym lotniska).
//        Długość lotu w godzinach - pole number min="0", step="1".
//        Cenę lotu - pole number min="0", step="0.01".
//        Dodaj obsługę tego formularza w metodzie doPost. Obsługa powinna polegać tylko na wyświetleniu przesłanych danych.
//        Hint: Pamiętaj żeby dane z DAO pobierać tylko raz!. Każdy odczyt z pliku (a potem z bazy danych) może długo trwać.

//
//Zadanie 6
//
//        Celem zadania jest obsługa i przetworzenie danych pobranych z formularza, który zrobiliśmy w poprzednim zadaniu. W tym celu zmodyfikuj metodę doPost servletu z poprzedniego pytania w następujący sposób:
//
//        Sprawdź czy użytkownik nie wybrał takiego samego lotniska wylotu i przylotu.
//
//        Sprawdź czy data i czas lotu zostały podane.
//
//        Sprawdź czy cena lotu jest większa od 0.
//
//        Pobierz strefę czasową lotniska wylotu i zapisz ją do zmiennej.
//
//        Pobierz strefę czasową lotniska przylotu i zapisz ją do zmiennej.
//
//        Stwórz obiekt z datą lotniska wylotu w jego strefie czasowej i zapisz czas do zmiennej
//
//        Dodaj do daty czas lotu i zmień strefę czasową na lotnisko przylotu i zapisz czas do zmiennej.
//
//        Stwórz klasę Flight z następującymi polami:
//
//        Lotnisko wylotu departure.
//        Lotnisko przylotu arrival.
//        Czas przylotu arrivalTime
//        Cena lotu price
//        Utwórz obiekt klasy z odpowiednimi danymi.
//
//        Hint: Żeby poprawnie pracować z strefami czasowymi skorzystaj z ZonedDateTime lub joda-time. Tutaj znajdziesz przykłady: przykład1 , przykład2
