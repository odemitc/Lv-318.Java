package servlets;

import tasks.FriendPairs;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirendPairsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("number"));
        if(n>0) {
            long pairs = FriendPairs.countOfPairs(n);
            req.setAttribute("output", pairs);
        }else {
            req.setAttribute("output", "Number of friends should be greater than 0");
        }
        req.getRequestDispatcher("/jsp/task11.jsp").forward(req, resp);
    }
}
