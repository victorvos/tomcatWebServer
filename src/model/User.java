package model;

import javax.servlet.http.HttpServlet;

/**
 * Created by Eigenaar on 2-5-2016.
 */
public class User {

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

