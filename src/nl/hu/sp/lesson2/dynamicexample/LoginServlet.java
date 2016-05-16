package nl.hu.sp.lesson2.dynamicexample;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Eigenaar on 13-5-2016.
 */
public class LoginServlet extends HttpServlet {


    private String gebruikersnaam, password;
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Object x =  getServletContext().getAttribute("user");
        User user = (User)x;

        gebruikersnaam = request.getParameter("gebruikersnaam");
        password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;

        String passwordCheck = user.getUsername();
        String username = user.getPW();

        if (gebruikersnaam.isEmpty() || password.isEmpty()) {
            rd = request.getRequestDispatcher("index.jsp");
            request.setAttribute("message", "<font color=red>Vul alle velden in aub !</font>");
            rd.include(request, response);
        } else if (user != null){
                if(!password.equals(passwordCheck) || !gebruikersnaam.equals(username)){
                    rd = request.getRequestDispatcher("index.jsp");
                    request.setAttribute("message", "<font color=red>Gebruikersnaam en Wachtwoord combinatie is niet bekend</font>");
                    rd.include(request, response);
                }
            }
        else {
            rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        }
    }
}
