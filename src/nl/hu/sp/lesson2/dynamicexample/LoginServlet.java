package nl.hu.sp.lesson2.dynamicexample;

import model.BlogService;
import model.ServiceProvider;
import model.User;
import utils.MyFilter;

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

        gebruikersnaam = request.getParameter("gebruikersnaam");
        password = request.getParameter("password");

        HttpSession session = request.getSession();
        RequestDispatcher rd = null;

        BlogService service = ServiceProvider.getBlogService();
        User user = service.logingUser(gebruikersnaam, password);

        if (gebruikersnaam.isEmpty()||password.isEmpty()) {
            rd = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("message", "<font color=red>Vul alle velden in aub !</font>");
            rd.include(request, response);
        } else if (user == null) {
            rd = request.getRequestDispatcher("/index.jsp");
            request.setAttribute("message", "<font color=red>Gebruikersnaam en Wachtwoord combinatie is niet bekend</font>");
            rd.include(request, response);
        } else {
            session.setAttribute("loggedUser", user);
            rd = request.getRequestDispatcher("/blogger/myaccount.jsp");
            rd.forward(request, response);
        }
    }
}
