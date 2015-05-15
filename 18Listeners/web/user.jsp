<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.example.model.UserBean"%>
<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% 
    response.setHeader("Cache-Control","no-store, must-revalidate"); 
    response.setHeader("Pragma","no-cache"); 
    response.setDateHeader ("Expires", -1);
    
    if(session.getAttribute("username")!=null)
    {
%> 
<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:26 PM
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
        
        <form method="post" action="UserController">
            <input type="hidden" name="userid" value="<c:out value="${user.userid}"/>">
            Username:<input type="text" name="username" value="<c:out value="${user.username}"/>"> <br/>
            Password:<input type="password" name="password" value="<c:out value="${user.password}"/>"> <br/>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
<%}
else{
   response.sendRedirect("index.html");
        }
%>