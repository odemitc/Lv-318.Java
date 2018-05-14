package main.java.servlets;



import main.java.tasks.FriendPairs;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirendPairsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("number"));
        long pairs = FriendPairs.countOfPairs(n);
        req.setAttribute("output",pairs);
        req.getRequestDispatcher("/jsp/task11.jsp").forward(req,resp);
    }
}
