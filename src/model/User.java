package model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Eigenaar on 2-5-2016.
 */
public class User extends HttpServlet {

    private String username = null;
    private String password = null;
    private String email = null;
    private String name = null;


    public User(String uNm, String pw, String em, String nm) {
        username = uNm;
        password = pw;
        email = em;
        name = nm;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean checkPassword(String pw) {
        boolean checkpw = false;
        if (pw.equals(password)) {
            checkpw = true;
        }
        return checkpw;
    }
}

