package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class PasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        boolean isStrong = checkPasswordStrength(password);

        request.setAttribute("isStrong", isStrong);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Respuesta.jsp");
        dispatcher.forward(request, response);
    }

    private boolean checkPasswordStrength(String password) {
        int upperCaseCount = 0, lowerCaseCount = 0, digitCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upperCaseCount++;
            else if (Character.isLowerCase(c)) lowerCaseCount++;
            else if (Character.isDigit(c)) digitCount++;
        }

        return upperCaseCount >= 4 && lowerCaseCount >= 3 && digitCount >= 3;
    }
}
