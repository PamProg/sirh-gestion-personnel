<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.css">
</head>
<body>
	<h1>Les collaborateurs y sont cools !</h1>
	
	<ul>
	
	<%
		List<Collaborateur> listeCollabs = (List<Collaborateur>)request.getAttribute("listeCollabs");
		for (Collaborateur col : listeCollabs) {
	%>
		<li><%=col.getNom()%></li>
	<%
		}
	%>
	
	</ul>
</body>
</html>