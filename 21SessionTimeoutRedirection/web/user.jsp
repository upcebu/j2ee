<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.example.model.UserBean"%>
<%@ page language="java" 
    contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="common/cachecontrol.jsp"/>

<%if(session.getAttribute("username")!=null)
    {
%>
<%-- 
    Document   : home
    Created on : May 6, 2015, 3:34:26 PM
    Author     : DCS
--%>


<jsp:include page="common/header.jsp"/>
        
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