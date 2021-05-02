<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page session="false" %>
<% 
    String ctx = request.getContextPath();    
    pageContext.setAttribute("ctx", ctx);
%>