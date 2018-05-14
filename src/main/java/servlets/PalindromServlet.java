package main.java.servlets;

import main.java.tasks.PalindromService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PalindromServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String word = req.getParameter("word");
        int maxLength = PalindromService.getMaxLengthOfPalindrom(word);
        System.out.println(maxLength);
        req.setAttribute("output", maxLength);
        req.getRequestDispatcher("/jsp/task10.jsp").forward(req, resp);
    }
}

