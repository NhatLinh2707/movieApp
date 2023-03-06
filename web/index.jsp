<%-- 
    Document   : index
    Created on : Feb 23, 2023, 8:26:58 PM
    Author     : linh2
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>LOGIN</h1>
         <c:set var="errorMessage" value="${requestScope.ERRORMESSAGE}"/>
         <form action="LoginServlet" method="post">
            USERNAME:<input type="text" name="username"><br><br>
            PASSWORD:<input type="password" name="password"><br><br>
            
            <input type="checkbox" name="remember">Remember me<br><br>
            <button type="submit">Login</button><br><br>
        </form>
         <span style="color: red">${errorMessage}</span>
    </body>
</html>
