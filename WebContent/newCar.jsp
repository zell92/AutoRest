<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Car</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/jumbosmaller.css" rel="stylesheet" type="text/css">
</head>
<body>
	<f:view>
		<div class="jumbotron">
			<h1>Dati automobile</h1>
		</div>
		<h:form>
			<table class="table table-hover">
				<colgroup>
					<col span="1" style="width: 15%;">
					<col span="1" style="width: 85%;">
				</colgroup>
				<tr>
					<td><label>Modello</label></td>
					<td><h:inputText value="#{carController.model}"
							required="true" requiredMessage="Name is mandatory" id="name" />
						<h:message for="name" /></td>
				</tr>
				<tr>
					<td><label>Codice</label></td>
					<td><h:inputText value="#{carController.code}" required="true"
							requiredMessage="Code is mandatory" id="code" /> <h:message
							for="code" /></td>
				</tr>
				<tr>
					<td><label>Prezzo</label></td>
					<td><h:inputText value="#{carController.price}"
							required="true" requiredMessage="Price is mandatory"
							converterMessage="Price must be a number" id="price" /> <h:message
							for="price" /></td>
				</tr>
				<tr>
					<td><label>Descrizione</label></td>
					<td><h:inputTextarea value="#{carController.description}"
							required="false" cols="20" rows="5" /></td>
				</tr>
				<tr>
					<td><label>Casa Automobilistica</label></td>
					<td><h:selectOneMenu value="#{carController.carmakerId}">
							<f:selectItem itemValue="#{null}" itemLabel="Non specificato" />
							<c:forEach var="carmaker" items="#{creatorController.carmakers}">
								<f:selectItem itemValue="#{carmaker.id}"
									itemLabel="#{carmaker.name}" />

							</c:forEach>
						</h:selectOneMenu>
						</td>
				<tr>
					<td colspan="2"><h:commandButton value="Conferma"
							action="#{carController.createCar}">
						</h:commandButton></td>
				</tr>
			</table>
		</h:form>
	</f:view>
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>