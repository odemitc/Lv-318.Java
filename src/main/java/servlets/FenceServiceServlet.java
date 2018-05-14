package main.java.servlets;

import main.java.tasks.FenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FenceServiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int countOfPosts = Integer.parseInt(req.getParameter("countOfPosts"));
        int countOfColors = Integer.parseInt(req.getParameter("countOfColors"));
        long countWays = FenceService.countWays(countOfPosts, countOfColors);
        System.out.println(countWays);
        req.setAttribute("output", countWays);
        req.getRequestDispatcher("/jsp/task14.jsp").forward(req, resp);
    }
}