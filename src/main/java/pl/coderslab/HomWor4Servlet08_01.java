package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomWor4Servlet08_01", urlPatterns = {"/Servlet08_01"})
public class HomWor4Servlet08_01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().append("Witaj na stronie 1<br>");
        HttpSession session = request.getSession();
        if(session.getAttribute("visitedSites")==(null)) {
            List<String> visitedSites = new ArrayList<>();
            visitedSites.add("Strona 1");
            session.setAttribute("visitedSites", visitedSites);
        } else {
        List<String> visitedSites = (ArrayList<String>) session.getAttribute("visitedSites");
        visitedSites.add("Strona 1");
        session.setAttribute("visitedSites", visitedSites);}
        response.getWriter().append("<html>");
        response.getWriter().append("<a href='/Homework4_war_exploded/Servlet08_02'>Strona 2 </a><br>");
        response.getWriter().append("<a href='/Homework4_war_exploded/Servlet08_03'>Strona 3 </a><br>");
        response.getWriter().append("<a href='/Homework4_war_exploded/history'>Strona 4, historia odwiedzanych stron </a><br>");
        response.getWriter().append("<a href='/Homework4_war_exploded/Servlet08_05'>Strona 5 </a><br>");
        response.getWriter().append("</html>");
    }
}

//        Zadanie 10
//
//        Utwórz 5 stron, każda ze stron ma posiadać linki nawigacyjne do pozostałych.
//        Np.:
//        strona 1 będzie posiadać linki do stron 2,3,4.
//        strona 2 będzie posiadać linki do stron 1,3,4. itd.
//        Mają również wyświetlać informacje o aktualnie odwiedzanej stronie w postaci:
//
//        Witaj na stronie 1
//        Strona 4 powinna być dostępna pod adresem /history, ma wyświetlać historię odwiedzanych stron oraz link z możliwością wyczyszczenia historii.
//        Dane o odwiedzonych stronach przechowuj w sesji.
//        Przykład wyświetlanej historii:
//
//        Odwiedzałeś:
//        Strona 1
//        Strona 2
//        Strona 3
//        Strona 2
//        Strona 4