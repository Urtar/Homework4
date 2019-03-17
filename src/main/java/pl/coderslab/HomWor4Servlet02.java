package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@WebServlet(name = "HomWor4Servlet02", urlPatterns = {"/Servlet02"})
public class HomWor4Servlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer [] table = new Integer[0];
        for (int i =0; i<10;i++){
            table = Arrays.copyOf(table, table.length+1);
            table[i] = i;
        }
        request.setAttribute("tabelka",table);
        getServletContext().getRequestDispatcher("/WEB-INF/index2.jsp").forward(request, response);
    }

    public Integer rand () {
        Random random = new Random();
        return random.nextInt(50);
    }
}
