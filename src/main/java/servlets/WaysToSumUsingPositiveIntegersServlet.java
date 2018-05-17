package servlets;

import tasks.WaysToSumUsingPositiveIntegers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class WaysToSumUsingPositiveIntegersServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));

        if (n>0) {
            int countWays = WaysToSumUsingPositiveIntegers.countWays(n);
            System.out.println(countWays);
            req.setAttribute("output", countWays);
        }else {
            req.setAttribute("output", "You should enter positive integer");
        }
        req.getRequestDispatcher("/jsp/task6.jsp").forward(req, resp);
    }
}
