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
	<h1>Statistiques</h1>
	
	<table class="table">
		<thead>
			<tr>
				<th>Chemin</th>
				<th>Nombre de visites</th>
				<th>Min (ms)</th>
				<th>Max (ms)</th>
				<th>Moyenne (ms)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vis" items="${listeVisites}">
				<tr>
					<td>${vis.chemin}</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
					<td>A faire</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
</body>
</html>