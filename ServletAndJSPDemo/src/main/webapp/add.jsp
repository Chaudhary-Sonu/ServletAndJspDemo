<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
    
    <%@ page import="java.util.ArrayList"%>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="cyan">
	
	<%! int k = 0; %>
	
	<%
		int i = Integer.parseInt(request.getParameter("num1"));
		int j = Integer.parseInt(request.getParameter("num2"));
		
		k = i + j;
		
		//we are using this just to handle the exception in jsp, by creating an error page.
		int l = k / 0;
	%>
	
	<%=  "The result is : " + k  %>

</body>
</html>