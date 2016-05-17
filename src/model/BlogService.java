package model;


import java.util.ArrayList;

/**
 * Created by Victor on 17-5-2016.
 */
public class BlogService {
    private ArrayList<User> userList = new ArrayList<User>();

    public addBlogPostForUser(String sub, String txt, User u){
        BlogPost bp = new BlogPost(sub, txt);
        u.addBlogPost(bp);
    }

    public boolean registerUser(String uNM, String pw, String em, String rN){
        boolean geregistreerd = false;
        User user = new User(uNM, pw, em, rN);
        if (userList.contains(user)){
            geregistreerd = true;
        }
        return geregistreerd;
    }

    public User logingUser(String uNm, String pw){
        for (User u : userList){
            if(u.checkPassword(pw) && u.getUsername().equals(uNm)){
                return u;
            }
            else{
                return null;
            }
        }
    }
}
