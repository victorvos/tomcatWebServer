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
    if ((session.getAttribute("user") == null) || (session.getAttribute("user") == "")) {
        out.println("You are not logged in");
    }
    else {
        out.print("Welkom op jou Blog ");
    }
%>
${user.name}
  <br>
          <table id ="gegevens">
                <tr>
                  <td>Gebruikersnaam:</td>
                  <td>${user.username}</td>
                </tr>
                <tr>
                  <td>Naam:</td>
                  <td>${user.name}</td>
                </tr>
                <tr>
                  <td>Emailadres:</td>
                  <td>${user.email}</td>
                </tr>
          </table>
<br>
<br>
    <form action="welcome.jsp">
        <title>
            Blogpost
        </title>
        <textarea name="text">

        </textarea>
    </form>
</body>
</html>