<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Car</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<f:view>
		<h:form>
			<div class="container">
				<div class="form-signin">
					<div>
						Modello:
						<h:inputText value="#{carController.model}"
							styleClass="form-control" required="true"
							requiredMessage="Name is mandatory" id="name" />
						<h:message for="name" />
					</div>
					<div>
						Prezzo:
						<h:inputText value="#{carController.price}"
							styleClass="form-control" required="true"
							requiredMessage="Price is mandatory"
							converterMessage="Price must be a number" id="price" />
						<h:message for="price" />
					</div>
					<div>
						Codice:
						<h:inputText value="#{carController.code}"
							styleClass="form-control" required="true"
							requiredMessage="Category is mandatory" id="category" />
						<h:message for="category" />
					</div>
					<div>
						Casa Automobilistica:
						<h:selectOneMenu value="#{carController.carmakerId}">
							<f:selectItem itemValue="#{null}" itemLabel="Non specificato" />
							<c:forEach var="carmaker" items="#{creatorController.carmakers}">
								<f:selectItem itemValue="#{carmaker.id}"
									itemLabel="#{carmaker.name}" />

							</c:forEach>
						</h:selectOneMenu>


					</div>
					<div>
						Descrizione (opzionale):
						<h:inputTextarea value="#{carController.description}"
							styleClass="form-control" required="false" cols="20" rows="5" />

					</div>
					<div>
						<h:commandButton value="Submit"
							action="#{carController.createCar}"
							styleClass="btn btn-lg btn-primary btn-block" />
					</div>

				</div>
			</div>
		</h:form>
	</f:view>
</body>
</html>