<%-- 
    Document   : index.jsp
    Created on : 30 de nov de 2020, 13:44:23
    Author     : Leandro
--%>

<%@page import="com.fatecpg.listener.NewServletListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Usuários</h1>
        
        <% if(NewServletListener.exception!=null) { %>
        <hr>
        <div style="color:red"><%= NewServletListener.exception.getMessage() %> </div>
        <% } %>
        
        <% for(String Disciplina: NewServletListener.getNameDisciplina()) { %>
        
        <div> <%= Disciplina %> </div>
        
        <% } %>
        
    </body>
</html>
