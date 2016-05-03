package nl.hu.sp.lesson2.dynamicexample;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Victor on 26-4-2016.
 */
public class Registreren extends HttpServlet {
    private String gebruikersnaam, naam, emailadres, password1, password2;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        gebruikersnaam = request.getParameter("gebruikersnaam");
        naam = request.getParameter("naam");
        emailadres = request.getParameter("emailadres");
        password1 = request.getParameter("pass1");
        password2 = request.getParameter("pass2");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        RequestDispatcher rd = null;
        if(gebruikersnaam.isEmpty()||naam.isEmpty()||emailadres.isEmpty()|| password1.isEmpty()||password2.isEmpty())        {
            rd = request.getRequestDispatcher("registreren.jsp");
            out.println("<font color=red>Please fill all the fields</font>");
            rd.include(request, response);
        }
        else if(!password1.equals(password2)){
            rd = request.getRequestDispatcher("registreren.jsp");
            out.println("<font color=red>Wachtwoorden komen niet overeen !</font>");
            rd.include(request, response);
        }
        else{
            rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        }
    }
}
