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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String voornaam = request.getParameter("voornaam");
        String achternaam = request.getParameter("achternaam");
        String adres = request.getParameter("adres");
        String password1 = request.getParameter("pass1");
        String password2 = request.getParameter("pass2");

        RequestDispatcher rd = null;
        if(voornaam.isEmpty()||achternaam.isEmpty()||adres.isEmpty()|| password1.isEmpty()||password2.isEmpty())
        {
            rd = request.getRequestDispatcher("registreren.jsp");
            out.println("<font color=red>Please fill all the fields</font>");
            rd.include(request, response);
        }
        else if(!password1.equals(password2)){
            rd = request.getRequestDispatcher("registreren.jsp");
            out.println("<font color=red>Wachtwoorden komen niet overeen !</font>");
            rd.include(request, response);
        }
        else
        {
            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }


    }
}
