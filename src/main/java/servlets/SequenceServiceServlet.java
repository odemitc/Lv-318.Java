package servlets;

import tasks.SequenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SequenceServiceServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String[] arrayOfString = req.getParameter("seq").replaceAll("[\\D]", "").split("");
        int[] sequence = new int[arrayOfString.length];
        for (int i = 0; i < arrayOfString.length; i++) {
            sequence[i] = Integer.parseInt(arrayOfString[i]);

        }

        if (sequence.length != 0) {
            int maxLengthOfSubsequence = SequenceService.getMaxLengthOfSubsequence(sequence);
            System.out.println(maxLengthOfSubsequence);
            req.setAttribute("output", maxLengthOfSubsequence);
        }else{
            req.setAttribute("output", "Invalid input data");
        }
        req.getRequestDispatcher("/jsp/task4.jsp").forward(req, resp);
    }
}
