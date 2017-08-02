<%@ page import="dev.sgp.entite.Collaborateur"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" href="<c:url value ='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
</head>
<body>
	<h1>Les collaborateurs y sont cools !</h1>
	
	<ul>
		<c:forEach var="col" items="${listeCollabs}">
			<li>${col.nom}</li>
		</c:forEach>
	</ul>
</body>
</html>