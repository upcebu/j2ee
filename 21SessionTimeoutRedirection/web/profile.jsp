

<%-- 
    Document   : profile
    Created on : May 6, 2015, 3:43:00 PM
    Author     : DCS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="common/cachecontrol.jsp"/>
<script src="timeout.js"></script>

<%if(session.getAttribute("username")!=null)
    {
%>
<jsp:include page="common/header.jsp"/>
    </body>
</html>
<%}
else{
   response.sendRedirect("index.html");
        }
%>
