package nl.hu.sp.lesson2.dynamicexample;

import model.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.util.logging.Logger.global;


/**
 * Created by Victor on 26-4-2016.
 */
public class Registreren extends HttpServlet {
    private String gebruikersnaam, naam, emailadres, password1, password2;
    ArrayList<User> userList;

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

    public void init(){
        userList = new ArrayList<>();
    }


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
        HttpSession session = request.getSession(true);

        if(gebruikersnaam.isEmpty()||naam.isEmpty()||emailadres.isEmpty()|| password1.isEmpty()||password2.isEmpty())        {
            rd = request.getRequestDispatcher("registreren.jsp");
            request.setAttribute("message", "<font color=red>Vul alle velden in aub !</font>");
            rd.include(request, response);
        }
        else if (!password1.equals(password2)) {
            rd = request.getRequestDispatcher("registreren.jsp");
            request.setAttribute("message", "<font color=red>Wachtwoorden komen niet overeen !</font>");
            rd.include(request, response);
        } else {

            User user = new User(gebruikersnaam, password1, emailadres, naam);
            userList.add(user);
            getServletContext().setAttribute("userList", userList);

            session.setAttribute("user", user);

//            response.addCookie(new Cookie("emailadres", emailadres));
//            response.addCookie(new Cookie("gebruikersnaam", gebruikersnaam));
//            response.addCookie(new Cookie("naam", naam));
//            response.addCookie(new Cookie("password", password1));

            rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        }
    }
}
