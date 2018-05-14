package main.java.servlets;

import main.java.tasks.SequenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceServiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String select = req.getParameter("seq");
        String[] arrayOfString = select.split(",");
        int[] sequence = new int[arrayOfString.length];
        for (int i = 0; i<sequence.length; i++){
            sequence[i] = Integer.parseInt(arrayOfString[i]);
        }
        int maxLengthOfSubsequence = SequenceService.getMaxLengthOfSubsequence(sequence);
        System.out.println(maxLengthOfSubsequence);
        req.setAttribute("output", maxLengthOfSubsequence);
        req.getRequestDispatcher("/jsp/task4.jsp").forward(req, resp);
    }
}
