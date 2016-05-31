<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<title>Automobile</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/jumbosmaller.css" rel="stylesheet" type="text/css">
</head>
<body>
	
		<div class="jumbotron">
			<h1>
				Automobile<br>
				
			</h1>
		</div>
	<f:view>
	
	<div class="container">
	<div class="starter-template">
	
		<h2>${carController.car.model}</h2>
		<h3><small>Dettagli:</small></h3>
			<div>Prezzo: ${carController.car.price} Euro</div>
			<div>Descrizione: ${carController.car.description}</div>
			<div>Codice: ${carController.car.code}</div>
		<div>
			<c:if test="${carController.car.carmaker != null}">
				Casa automobilistica: ${carController.car.carmaker.name} 
			</c:if>
		</div>
		<c:if test="${carController.car.carmaker == null}">
				Casa automobilistica: Non specificata 
			</c:if>

	</div>
	</div>
		

	</f:view>
	<script src="//code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>