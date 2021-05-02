<!doctype html>
<html>

<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page session="false" %>
<% 
    String ctx = request.getContextPath();    
    pageContext.setAttribute("ctx", ctx);
%>
 
<head>
    <script src="${ctx }/resources/assets/js/vendor/jquery-1.12.4.min.js"></script>
</head>
<body>
    
<script type="text/javascript"> 

$(document).ready(function(){
	
	window.location.href="/index.do";

});

</script>
    
</body>
</html>