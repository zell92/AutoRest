<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Product</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/jumbosmaller.css" rel="stylesheet" type="text/css">
</head>
<body>
	<f:view>
		<div class="jumbotron">
			<h1>Nuova casa automobilistica</h1>
		</div>
		<h:form>
			<table class="table table-hover">
				<colgroup>
					<col span="1" style="width: 15%;">
					<col span="1" style="width: 85%;">
				</colgroup>
				<tr>
					<td><label>Nome</label></td>
					<td><h:inputText value="#{carmakerController.name}"
							required="true" requiredMessage="Name is mandatory" id="name" />
						<h:message for="name" /></td>
				</tr>
				<tr>
					<td colspan="2"><h:commandButton value="Conferma"
							action="#{carmakerController.createCarmaker}">
						</h:commandButton></td>
				</tr>
			</table>
		</h:form>
	</f:view>
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>