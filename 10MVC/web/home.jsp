<%-- 
    Document   : admin
    Created on : May 6, 2015, 8:44:18 AM
    Author     : DCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%=session.getAttribute("name")%></h1>
        <%
            List options = (List)request.getAttribute("options");
            Iterator it = options.iterator();
            while(it.hasNext()){
                out.print(it.next());
            }
         %>
    </body>
</html>
