package servlets;

import tasks.ModificationFibonacci;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModificationFibonacciServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));

        if (n > 0) {
            int num = ModificationFibonacci.findPossition(n);
            System.out.println(num);
            req.setAttribute("output", num);
        } else {
            req.setAttribute("output", "Parameters n should be greater than 0");
        }

        req.getRequestDispatcher("/jsp/task2.jsp").forward(req, resp);
    }
}
