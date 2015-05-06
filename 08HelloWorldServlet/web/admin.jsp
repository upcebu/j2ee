<%-- 
    Document   : admin
    Created on : May 6, 2015, 2:45:51 PM
    Author     : DCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            String type = request.getParameter("type");
         %>
         <h1>Type: <%=type%></h1>
    </body>
</html>
