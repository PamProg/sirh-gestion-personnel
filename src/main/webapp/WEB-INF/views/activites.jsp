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
	<h1>Activités depuis le démarrage de l'application</h1>
	
	<table class="table">
		<thead>
			<tr>
				<th>Date/Heure</th>
				<th>Libellé</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="evt" items="${listeCollabEvents}">
				<tr>
					<td>${evt.dateHeure}</td>
					<c:choose>
						<c:when test="${evt.type == TypeCollabEvt.CREATION_COLLAB}" >
							<td>Création d'un nouveau collaborateur - matricule : ${evt.matricule}</td>
						</c:when>
						<c:otherwise>
							<td>Modification d'un collaborateur - matricule : ${evt.matricule}</td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>