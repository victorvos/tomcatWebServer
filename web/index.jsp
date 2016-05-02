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
<% String voornaam =  request.getParameter("voornaam");
   String achternaam = request.getParameter("achternaam");
   String adres = request.getParameter("adres");
%>
<table id ="gegevens">
  <tr>
    <td>Voornaam</td>
    <td><%= voornaam %></td>
  </tr>
  <tr>
    <td>Achternaam</td>
    <td><%= achternaam %></td>
  </tr>
  <tr>
    <td>Adres</td>
    <td><%= adres %></td>
  </tr>
</table>
</body>
</html>