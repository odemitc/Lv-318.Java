package servlets;

import tasks.LowHightEfforts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LowHighEffortsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int n = Integer.parseInt(req.getParameter("n"));
        String[] numbersLow = req.getParameter("low").replaceAll("[\\D]", "").split("");
        int[] low = new int[numbersLow.length];
        for (int i = 0; i < numbersLow.length; i++) {
            low[i] = Integer.parseInt(numbersLow[i]);

        }

        String[] numbersHigh = req.getParameter("high").replaceAll("[\\D]", "").split("");
        int[] high = new int[numbersHigh.length];
        for (int i = 0; i < numbersHigh.length; i++) {
            high[i] = Integer.parseInt(numbersHigh[i]);
        }

        int output = LowHightEfforts.maxAmountTasks(n, low, high);
        req.setAttribute("output", output);
        req.getRequestDispatcher("/jsp/task9.jsp").forward(req, resp);
    }
}
