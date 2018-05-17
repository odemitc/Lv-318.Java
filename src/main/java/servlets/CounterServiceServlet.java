package servlets;

import tasks.CounterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CounterServiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        int m = Integer.parseInt(req.getParameter("m"));

        if (n > 0 & m > 0) {
            int countWays = CounterService.countWaysToTileFloor(n, m);
            System.out.println(countWays);
            req.setAttribute("output", countWays);
        } else {
            req.setAttribute("output", "Parameters n and m should be greater than 0");
        }
        req.getRequestDispatcher("/jsp/task12.jsp").forward(req, resp);
    }
}
