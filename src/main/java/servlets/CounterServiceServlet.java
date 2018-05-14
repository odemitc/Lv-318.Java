package main.java.servlets;

import main.java.tasks.CounterService;

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
        int countWays = CounterService.countWaysToTileFloor(n, m);
        System.out.println(countWays);
        req.setAttribute("output", countWays);
        req.getRequestDispatcher("/jsp/task12.jsp").forward(req, resp);
    }
}
