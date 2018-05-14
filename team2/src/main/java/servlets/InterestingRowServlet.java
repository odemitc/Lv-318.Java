package  main.java.servlets;


import main.java.tasks.IntrestingRow;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InterestingRowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        int num = IntrestingRow.intrestingRow(n);
        System.out.println(num);
        req.setAttribute("output",num);
        req.getRequestDispatcher("/jsp/task3.jsp").forward(req,resp);
    }
}

