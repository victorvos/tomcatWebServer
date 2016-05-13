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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        gebruikersnaam = request.getParameter("gebruikersnaam");
        password = request.getParameter("pass1");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;

        Object user = session.getAttribute("user");


        if(gebruikersnaam.isEmpty()||password.isEmpty()){
            rd = request.getRequestDispatcher("index.jsp");
            out.println("<font color=red>Vul alle velden in aub !</font>");
            rd.include(request, response);
        }
        else if (!password) {
            rd = request.getRequestDispatcher("registreren.jsp");
            out.println("<font color=red>Wachtwoorden komen niet overeen !</font>");
            rd.include(request, response);
    }


}
