package servlets;

import tasks.WaysToSumUsingElements;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WaysToSumUsingElementsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        String[] strings = req.getParameter("array").replaceAll("[\\D]", "").split("");
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = Integer.parseInt(strings[i]);
        }

        if (n > 0 & array.length != 0) {
            int countWays = WaysToSumUsingElements.countWays(n, array);
            req.setAttribute("output", countWays);
        } else {
            if (n <= 0) {
                req.setAttribute("output", "Number - n should be greater than 0");
            }

            if (array.length == 0) {
                req.setAttribute("output", "You forgot to enter an array");
            }
        }
        req.getRequestDispatcher("/jsp/task5.jsp").forward(req, resp);
    }
}
