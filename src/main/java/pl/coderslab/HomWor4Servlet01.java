package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomWor4Servlet01", urlPatterns = {"/index1"})
public class HomWor4Servlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String author = request.getParameter("author");
        String content = request.getParameter("content");
        request.setAttribute("authorF", author);
        request.setAttribute("contentF", content);
        if (author != null && !author.isEmpty()) {
            getServletContext().getRequestDispatcher("/WEB-INF/index11.jsp").forward(request,response);
        } else {
            response.getWriter().append("Nie podano żadnych danych!");
        }


    }
}
//
//Zadanie 1
//
//        W projekcie stwórz stronę jsp index1.jsp. Następnie:
//
//        Pobierz wartość parametru GET o nazwie author.
//        Sprawdź czy parametr istnieje oraz czy nie jest pusty.
//        Wyświetl informacje w postaci:
//<p>Wybrany autor <Pobrana wartość></p>