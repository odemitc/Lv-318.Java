package servlets;

import tasks.Fibonacci;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FibonacciServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));

        long fibonacciNumber = Fibonacci.fibonacciNumberCalc(n);
        System.out.println(fibonacciNumber);
        req.setAttribute("output",fibonacciNumber);
        req.getRequestDispatcher("/jsp/task1.jsp").forward(req,resp);
    }
}
