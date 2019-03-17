package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomWor4Servlet06", urlPatterns = {"/newsletter"})
public class HomWor4Servlet06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setContentType("UTF-8");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (name == null || email == null) {
            response.getWriter().append("Nieprawidłowe dane");
            response.getWriter().append("<a href='/Homework4_war_exploded/newsletter'>Wróc na stronę główną</a>");
        }
        Cookie cookie = new Cookie("user", name);
        NewsletterUser newsletterUser = new NewsletterUser();
        newsletterUser.setName(name);
        newsletterUser.setEmail(email);
        NewsletterLoginFormDao newsletterLoginFormDao = new NewsletterLoginFormDao();
        newsletterLoginFormDao.saveToDBDao(newsletterUser);
        cookie.setMaxAge((3600*24));
        response.addCookie(cookie);
        response.sendRedirect("/Homework4_war_exploded/newsletter");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    getServletContext().getRequestDispatcher("/WEB-INF/index8.jsp").forward(request, response);
                } else {
                    getServletContext().getRequestDispatcher("/WEB-INF/index7.jsp").forward(request, response);
                }
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/index7").forward(request, response);
        }
    }
}
