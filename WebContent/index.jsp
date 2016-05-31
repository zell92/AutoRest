<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ASS concessionario</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/jumbosmaller.css" rel="stylesheet" type="text/css">
</head>
<body>
	<f:view>
		<div class="jumbotron">
			<h1>Benvenuto!</h1>
		</div>
		<ul class="list-group">

			<li class="list-group-item"><h:form>
					<h:commandLink action="#{carmakerController.listCarmakers}"
						value="Case automobilistiche" />
				</h:form></li>
			<li class="list-group-item"><h:form>
					<h:commandLink action="#{carController.listCars}"
						value="Lista automobili" />
				</h:form></li>
			<li class="list-group-item"><a
				href='<c:url value="/faces/newCarmaker.jsp" />'>Inserisci una
					casa automobilistica</a></li>
			<li class="list-group-item"><h:form>
					<h:commandLink action="#{creatorController.newCar}"
						value="Aggiungi una nuova macchina" />
				</h:form></li>
		</ul>
	</f:view>

	<script src="//code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

