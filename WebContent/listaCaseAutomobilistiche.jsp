<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista case automobilistiche</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/jumbosmaller.css" rel="stylesheet" type="text/css">
<style>
div {
	margin-left: 8px margin-bottom: 4px
}
</style>
</head>
<body>
	<f:view>
		<div class="jumbotron">
			<h1>Case automobilistiche:</h1>
		</div>
		<h:form>
			<table class="table table-bordered table-hover">
				<colgroup>
					<col span="1" style="width: 15%;">
					<col span="1" style="width: 15%;">
					<col span="1" style="width: 15%;">
					<col span="1" style="width: 15%;">
				</colgroup>
				<tr>
					<th>Nome</th>
					<th></th>
					<th></th>

				</tr>
				<c:forEach var="carmaker" items="#{carmakerController.carmakers}">
					<tr>
						<td>${carmaker.name}</td>
						<td><h:commandLink action="#{carmakerController.showCars}"
								value="Lista automobili">

								<f:param name="carmakerId" value="#{carmaker.id}" />

							</h:commandLink></td>
						<td><h:commandLink action="#{carmakerController.deleteCarmaker}"
								value="Elimina">
								<f:param name="carmakerId" value="#{carmaker.id}" />
							</h:commandLink></td>

					</tr>
				</c:forEach>
			</table>
		</h:form>
		<div>
			<a href='<c:url value="/faces/index.jsp" />'>Torna alla Home</a>
		</div>
	</f:view>
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>