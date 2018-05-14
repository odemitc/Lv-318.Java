package  main.java.servlets;

import main.java.tasks.ModificationFibonacci;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Task2Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        int num = ModificationFibonacci.findPossition(n);
        System.out.println(num);
        req.setAttribute("output",num);
        req.getRequestDispatcher("/jsp/task2.jsp").forward(req,resp);
    }
}
