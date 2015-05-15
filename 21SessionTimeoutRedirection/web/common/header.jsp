<%-- 
    Document   : header
    Created on : May 10, 2015, 5:31:45 PM
    Author     : DCS
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="home.jsp">Home</a> | <a href="profile.jsp">Profile</a> | <a href="LogoutServlet">Logout</a>
        <h1>Hello <%=session.getAttribute("username")%>!</h1>