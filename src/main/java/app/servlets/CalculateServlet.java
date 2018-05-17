package app.servlets;

import app.classes.UtilityFabric;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstNumber = req.getParameter("firstNumber");
        String secondNumber = req.getParameter("secondNumber");
        String label = req.getParameter("tasklabel");
        String result = UtilityFabric.execute(firstNumber, secondNumber, label);
        req.setAttribute("result", result);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/resultPage.jsp");
        requestDispatcher.forward(req, resp);
    }
}
