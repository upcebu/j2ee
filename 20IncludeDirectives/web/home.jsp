<%@page import="com.example.listener.AppEventsListener"%>
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

        <p><a href="UserController?action=add">Add User</a></p>
        <table border="1">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th colspan="2">Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td><a href="UserController?action=edit&userid=<c:out value="${user.userid}"/>"/>Edit</td>
                        <td><a href="UserController?action=delete&userid=<c:out value="${user.userid}"/>"/>Delete</td>
                    </tr>
                </c:forEach>
            </tbody>
            
            
        </table>
        <p>Number of accesses:<%=session.getAttribute("counter")%></p>
        <p>Total Active Sessions:<%=AppEventsListener.getTotalActiveSessions()%></p>
    </body>
</html>

<%}
else{
   response.sendRedirect("index.html");
        }
%>