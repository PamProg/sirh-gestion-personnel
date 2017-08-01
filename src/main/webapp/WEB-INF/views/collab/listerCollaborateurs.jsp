<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SGP - App</title>
</head>
<body>
	<h1>Les collaborateurs y sont cools !</h1>
	
	<ul>
	
	<%
		List<String> listeNoms = (List<String>)request.getAttribute("listeNoms");
		for (String nom : listeNoms) {
	%>
		<li><%=nom%></li>
	<%
		}
	%>
	
	</ul>
</body>
</html>