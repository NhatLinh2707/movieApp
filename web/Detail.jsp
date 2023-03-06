<%-- 
    Document   : Detail
    Created on : Feb 23, 2023, 8:26:24 PM
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
        
         <c:set var="username" value="${requestScope.USERNAME}"/>
        <h1>Hello: ${username}</h1>
    </body>
</html>
