<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Gegevens</title>
  <style>
    table#gegevens{
      width: 50%;
      background-color: #c48ec5;
    }
  </style>
</head>
<body>
<%
         String gebruikersnaam =  request.getParameter("gebruikersnaam");
         String naam = request.getParameter("naam");
         String emailadres = request.getParameter("emailadres");

            Cookie[] cookies = request.getCookies();
            boolean foundCookie = false;

            for(int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if (c.getName().equals("naam")) {
                    out.println("Hallo " + c.getValue() + " uw emailadres: " + emailadres + " is Geregistreerd !");
                            foundCookie = true;
                }
            }

            if (!foundCookie) {
                Cookie c = new Cookie("cookienaam", "cookievalue");
                c.setMaxAge(24*60*60);
                response.addCookie(c);
            }
%>

  <br>
          <table id ="gegevens">
                <tr>
                  <td>Gebruikersnaam</td>
                  <td><%= gebruikersnaam %></td>
                </tr>
                <tr>
                  <td>Naam</td>
                  <td><%= naam %></td>
                </tr>
                <tr>
                  <td>Emailadres</td>
                  <td><%= emailadres %></td>
                </tr>
          </table>
</body>
</html>