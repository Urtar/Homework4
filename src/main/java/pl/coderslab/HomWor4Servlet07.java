package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomWor4Servlet07", urlPatterns = {"/guest-book"})
public class HomWor4Servlet07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setContentType("UTF-8");
        GuestBook guestBook = new GuestBook();
        guestBook.setDescription(request.getParameter("description"));
        GuestBookDao guestBookDao = new GuestBookDao();
        guestBookDao.saveToDBDao(guestBook);
        response.sendRedirect("/Homework4_war_exploded/guest-book");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().append("<html>");
        response.getWriter().append("<form action='/Homework4_war_exploded/guest-book' method='post'");
        response.getWriter().append("<label>");
        response.getWriter().append("Dodaj wpis do księgi gości:<br>");
        response.getWriter().append("<input type='text' name='description'>");
        response.getWriter().append("</label>");
        response.getWriter().append("<input type='submit' name='Wyślij'>");
        response.getWriter().append("</form>");
        response.getWriter().append("</html>");
        response.getWriter().append("Guest Book:<br>");
        GuestBookDao guestBookDao = new GuestBookDao();
        response.getWriter().append(guestBookDao.findAllDescriptions().toString());
    }
}
//
//Zadanie 9
//
//        Celem zadania jest udostępnienie funkcjonalności księgi gości.
//
//        Utwórz servlet wyświetlający listę wpisów z księgi gości. Ma być dostępny pod adresem /guest-book
//        Wyświetlane mają być wpisy w kolejności od najnowszego do najstarszego.
//        Informacje o wpisach mają być pobierane z bazy danych.
//        Zapytania tworzące tabele w bazie danych umieść w pliku query.sql.
//        Dane dostępowe do bazy danych umieść w parametrach inicjalizacji dla całej aplikacji - sprawdź snippety aby dowiedzieć się jak zapisać i odczytać parametry.
//        Na stronie nad wpisami umieść formularz umożliwiający dodawanie nowego wpisu (nazwa oraz opis).
