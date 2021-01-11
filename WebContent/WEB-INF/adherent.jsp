<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>Bibliotheque</title>		
		<link rel="stylesheet" type="text/css" href="adherent.css">
	</head>
	
	<body>
		<h2>- Bibliothèque - <br /> Gestion des adhérents</h2>
			<form action='adherent' method='post'>
				<label for='nom'>Nom</label>
				<br />				
				<input class="saisie" name='nom' id='nom' type='text' autofocus/>
				<br />
				<label for='prenom'>Prénom</label>
				<br />				
				<input class="saisie" name='prenom' id='prenom' type='text' />
				<br />
				<input class='bouton' type='submit' name='Ajouter' value='   Ajouter   ' />		
				<input class='bouton' type='submit' name='Supprimer' value='   Supprimer   ' />
				
				<div>
					<table>
						<tr>	
							<th>Nom</th>
							<th>Prénom</th>								
							<th></th>
						</tr>
						<c:forEach var="adherent" items="${ listeAdherents }">
							<tr>										
								<td><c:out value="${ adherent.nom }"/></td>	
								<td><c:out value="${ adherent.prenom }"/></td>											
							</tr>
						</c:forEach>						
					</table>
				</div>	
					
		</form>
	</body>
	
</html>