package servlets;

import tasks.PaintingFence;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PaintingFenceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        int k = Integer.parseInt(req.getParameter("k"));

        if (n > 0 & k > 0) {
            int countWays = PaintingFence.countWays(n, k);
            System.out.println(countWays);
            req.setAttribute("output", countWays);
        } else {
            req.setAttribute("output", "Both n and k should be positive integers");
        }

        req.getRequestDispatcher("/jsp/task13.jsp").forward(req, resp);
    }
}
