<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SGP - App</title>
	<link rel="stylesheet" href="<c:url value ='/bootstrap-3.3.7-dist/css/bootstrap.css'></c:url>">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>

	<form class="form-horizontal" method="post">
		<fieldset>

			<!-- Form Name -->
			<h1 class="col-lg-offset-1 col-md-offset-1">Nouveau Collaborateur</h1>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nom">Nom</label>
				<div class="col-md-4">
					<input id="nom" name="nom" placeholder="Nom"
						class="form-control input-md" required="" type="text"> <span
						class="help-block">Ne doit pas contenir de chiffres</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="prenom">Prénom</label>
				<div class="col-md-4">
					<input id="prenom" name="prenom" placeholder="Prénom"
						class="form-control input-md" required="" type="text"> <span
						class="help-block">Ne doit pas contenir de chiffres</span>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="dateDeNaissance">Date
					de naissance</label>
				<div class="col-md-4">
					<input id="dateDeNaissance" name="dateDeNaissance"
						placeholder="Date de naissance" class="form-control input-md"
						required="" type="text"> <span class="help-block">Format
						: jj/mm/aaaa. Ex : 23/11/1995</span>
				</div>
			</div>

			<!-- Textarea -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="adresse">Adresse</label>
				<div class="col-md-4">
					<textarea class="form-control" id="adresse" name="adresse"></textarea>
				</div>
			</div>
			
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nir">Numéro de
					Sécurité sociale</label>
				<div class="col-md-4">
					<input id="nir" name="nir" placeholder="Numéro de Sécurité sociale"
						class="form-control input-md" required="" type="text"> <span
						class="help-block">Doit contenir 15 caractères</span>
				</div>
				<c:if test="${listErreurs.nir != null}"><span class="alert alert-danger alert-dismissible" role="alert">${listErreurs.nir}</span></c:if>
			</div>
			

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"></label>
				<div class="col-md-4">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary">Créer</button>
				</div>
			</div>

		</fieldset>
	</form>

</body>
</html>