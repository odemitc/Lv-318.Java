package servlets;

import tasks.IntrestingRow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InterestingRowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));

        if (n > 0) {
            int num = IntrestingRow.intrestingRow(n);
            System.out.println(num);
            req.setAttribute("output", num);
        } else {
            req.setAttribute("output", "Parameters n should be greater than 0");
        }
        req.getRequestDispatcher("/jsp/task3.jsp").forward(req, resp);
    }
}

