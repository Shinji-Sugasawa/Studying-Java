<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Class.forName("org.h2.Driver");
	out.print("OK");
	}catch (Exception e){
		e.printStackTrace(new PrintWriter(out));
	}
	%>
</body>
</html>