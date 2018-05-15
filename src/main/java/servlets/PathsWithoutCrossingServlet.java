package servlets;

import tasks.PathsWithoutCrossing;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PathsWithoutCrossingServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        long countWays = PathsWithoutCrossing.amountOfPathsWithoutCrosses(n);
        System.out.println(countWays);
        req.setAttribute("output", countWays);
        req.getRequestDispatcher("/jsp/task8.jsp").forward(req, resp);
    }
}
