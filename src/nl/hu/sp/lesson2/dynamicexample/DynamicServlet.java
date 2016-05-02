package nl.hu.sp.lesson2.dynamicexample;

/**
 * Created by Victor on 14-4-2016.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DynamicServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Integer num1 = Integer.parseInt(request.getParameter("num1"));
        Integer num2 = Integer.parseInt(request.getParameter("num2"));
        String operator = request.getParameter("operator");
        Integer result = 0;


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            switch (operator) {
                case ("+"): /*IF PLUS*/
                    result = num1 + num2;
                    break;
                case ("-"): /*IF MINUS*/
                    result = num1 - num2;
                    break;
                case ("*"): /*IF MULTIPLICATION*/
                    result = num1 * num2;
                    break;
                case ("/"): /*IF DIVISION*/
                    result = num1 / num2;
                    break;
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Rekenmachine</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + num1 + " " + operator + " " + num2 + " = " + result + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}