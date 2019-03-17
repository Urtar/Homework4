package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@WebServlet(name = "HomWorServlet04_1", urlPatterns = {"/Servlet04_1"})
public class HomWorServlet04_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Ehre");
        lang.put("es", "Hola");
        lang.put("fr", "Bienvenue");
        request.setAttribute("langF", lang);
        Cookie[] cookies = request.getCookies();
        Cookie foundCookie = null;
        request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("language")) {
                    foundCookie = c;
                }
            }
            if (foundCookie != null) {
                Set<String> keys = lang.keySet();
                for (String key : keys) {
                    if (foundCookie.getValue().equals(key)){
                        response.getWriter().append(key + "<br>");
                        request.setAttribute("languageSet", lang.get(key));
                    }
                }
            } else {
                getServletContext().getRequestDispatcher("/WEB-INF/index4.jsp").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/index4.jsp").forward(request, response);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/index4.jsp").forward(request, response);
    }
}


//Zadanie 4
//
//        W projekcie stwórz servlet Servlet_01_1 oraz Servlet_01_2. Następnie:
//
//        Na pierwszej stronie (Servlet_01_1) stwórz formularz z elementem select oraz opcjami wyboru zgodnymi z kluczami poniższej mapy:
//        Map<String, String> lang = new  HashMap<>();
//        lang.put("en", "Hello");
//        lang.put("pl", "Cześć");
//        lang.put("de", "Ehre");
//        lang.put("es", "Hola");
//        lang.put("fr", "Bienvenue");
//        Strona ma przesyłać dane za pomocą POST do drugiej strony (Servlet_01_2), która ma ustawić ciasteczko language na wartość wybraną przez użytkownika.
//        Po ponownym wejściu na pierwszą powinna być wyświetlana informacja powitalna w wybranym przez użytkownika języku.
//        Gdy ciasteczko nie istnieje, wiadomość powitalna powinna być wyświetlana w języku polskim.
//        Hint: Odpowiednie dane przekaż i przetwórz w pliku widoku.
