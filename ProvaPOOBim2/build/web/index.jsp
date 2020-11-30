<%-- 
    Document   : index.jsp
    Created on : 30 de nov de 2020, 13:44:23
    Author     : Leandro
--%>

<%@page import="com.fatecpg.model.Disciplina"%>
<%@page import="com.fatecpg.listener.NewServletListener"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
String errorMessage = null;

try{
    if(request.getParameter("inserir")!=null){
        String name = request.getParameter("name");
        if(name!=""){
            Disciplina.insertDisciplina(name);
            response.sendRedirect(request.getRequestURI());
        }else{    
        } 
    }
    } catch(Exception ex){
            errorMessage = "Erro ao inserir nova Disciplina"+ex.getMessage();
    }

try{
    if(request.getParameter("delete")!=null){
        String name = request.getParameter("name");
        Disciplina.deleteDisciplina(name);
        response.sendRedirect(request.getRequestURI());
    }
    } catch(Exception ex){
            errorMessage = "Erro ao inserir nova Disciplina"+ex.getMessage();
    }


%>
            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Usuários</h1>
        <form>
        <input type="text" name="name">
        <input type="submit" name="inserir" value="Inserir Disciplina">
        </form>
        <hr>
        
        <% if(NewServletListener.exception!=null) { %>
        <hr>
        <div style="color:red"><%= NewServletListener.exception.getMessage() %> </div>
        <% } %>
        
        <table border="1">

        <tr>
            <th>Nome</th>
            <th>Ações</th>
        
        </tr>
        <% for(String Disciplina: NewServletListener.getNameDisciplina()) { %>
        <tr>
            <td> <%= Disciplina %> </div></td>
            <td>
                <form>
                <input type="hidden" name="name" value="<%=Disciplina %>">
                <input type="submit" name="delete" value="Excluir"></td>
                </form>    
        <% } %>
        </tr>
        </table>
        
    </body>
</html>
