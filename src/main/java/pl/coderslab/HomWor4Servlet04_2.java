package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomWor4Servlet04_2", urlPatterns = {"/Servlet04_2"})
public class HomWor4Servlet04_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String welcom = request.getParameter("languageSelect");
        System.out.println(welcom);
        Cookie cookie = new Cookie("language", welcom);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        response.sendRedirect("/Homework4_war_exploded/Servlet04_1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
