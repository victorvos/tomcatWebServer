<%--
  Created by IntelliJ IDEA.
  User: Victor
  Date: 26-4-2016
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registreren</title>
</head>
<style>
    div.ex {
        text-align: right width:300px;
        padding: 10px;
        border: 5px solid grey;
        margin: 0px
    }
</style>
<body>
    <form action="registreren.do" method="get">
    <h1>Registratie</h1>
    <div class="ex">
            <table style="with: 50%">
                <tr>
                    <td>Gebruikersnaam</td>
                    <td><input type="text" name="gebruikersnaam" value="${cookie.gebruikersnaam.value}"/></td>
                </tr>
                <tr>
                    <td>Naam</td>
                    <td><input type="text" name="naam" value="${cookie.naam.value}"/></td>
                </tr>
                <tr>
                    <td>Emailadres</td>
                    <td><input type="text" name="emailadres" value="${cookie.emailadres.value}"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass1" value="${cookie.password.value}"/></td>
                </tr>
                <tr>
                    <td>Password nogmaals</td>
                    <td><input type="password" name="pass2" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="register" /></td>
                </tr>
            </table>
    </div>
    </form>
</body>
</html>
