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

@WebServlet(name = "HomWor4Servlet08_03", urlPatterns = {"/Servlet08_03"})
public class HomWor4Servlet08_03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.getWriter().append("Witaj na stronie 3<br>");
        HttpSession session = request.getSession();
        List<String> visitedSites = (ArrayList<String>) session.getAttribute("visitedSites");
        visitedSites.add("Strona 3");
        session.setAttribute("visitedSites", visitedSites);
        response.getWriter().append("<a href='/Homework4_war_exploded/Servlet08_01'>Strona 1 </a><br>");
        response.getWriter().append("<a href='/Homework4_war_exploded/Servlet08_02'>Strona 2 </a><br>");
        response.getWriter().append("<a href='/Homework4_war_exploded/history'>Strona 4, historia odwiedzanych stron </a><br>");
        response.getWriter().append("<a href='/Homework4_war_exploded/Servlet08_05'>Strona 5 </a><br>");
    }
}
