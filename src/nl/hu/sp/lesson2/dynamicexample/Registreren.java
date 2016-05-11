package nl.hu.sp.lesson2.dynamicexample;

import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


/**
 * Created by Victor on 26-4-2016.
 */
public class Registreren extends HttpServlet {
    private String gebruikersnaam, naam, emailadres, password1, password2;

    public static Cookie getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
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
        else if (!password1.equals(password2)) {
            rd = request.getRequestDispatcher("registreren.jsp");
            out.println("<font color=red>Wachtwoorden komen niet overeen !</font>");
            rd.include(request, response);
        } else {
            HttpSession session = request.getSession(true);
            ArrayList<User> users = new ArrayList<User>();
            User user = new User(gebruikersnaam, password1, emailadres, naam);
            users.add(user);

            Cookie cookie = new Cookie("cookienaam", "cookievalue");
            response.addCookie(cookie);
            cookie.setValue(emailadres);

            rd = request.getRequestDispatcher("welcome.jsp");
            rd.forward(request, response);
        }
    }
}
