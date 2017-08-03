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
	<h1>Les collaborateurs</h1>
	

	<div class="container">
		<div class="row">
		
			<c:forEach var="col" items="${listeCollabs}">
			
				<div class="col-md-4 col-sm-6">
					<div class="thumbnail">
						<h4>${col.nom} ${col.prenom}</h4>
						<hr>
						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-4">
								<img src="../${col.photo}" width="100%">					
							</div>
							<div class="col-md-4 col-sm-4 col-xs-4">
								<p>Fonction</p>		
								<p>Département</p>		
								<p>Email</p>		
								<p>Adresse</p>		
							</div>
							<div class="col-md-4 col-sm-4 col-xs-4 col-xs-4">
								<p>${col.intitulePoste}</p>							
								<p>${col.departement.nom}</p>							
								<p>${col.emailPro}</p>							
								<p>${col.adresse}</p>		
								<a href="#" class="btn btn-default">Éditer</a>				
							</div>
						</div>
					</div>
				</div>
				
			</c:forEach>
			
		</div>
	</div>
</body>
</html>