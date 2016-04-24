<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"></link>
    <link href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" rel="stylesheet"></link>
    
    <script src="//oss.maxcdn.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
     
    <script type="text/javascript" src="./js/validador.js"></script>
    
    <jsp:include page="Menu.jsp"></jsp:include>
<title>Busqueda simple</title>
</head>
<body>
	<form action="ServletBuscadorSimpleCont" id="ServletBuscadorSimpleCont" method="post" class="form-horizontal mitad">
	<div class="form-group">
		<label class="col-lg-3 control-label">Buscar</label>
		<div class="col-lg-3">
			<input type="text" class="form-control" name="textoBusqueda" required>
			<br>
		</div>
	</div>
	<div class="form-group">
		<div class="col-lg-9 col-lg-offset-3">
			<button type="submit" class="btn btn-success left">Enviar</button>
		</div>
	</div>
	</form>
	
	<table class="table table-bordered table-hover table-responsive">
	<tr class="success">
		<thead>
			<th>Run</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Mail</th>
			<th>Teléfono</th>
			<th>País</th>
			<th>Región</th>
			<th>Ciudad</th>
			<th>Dirección</th>
		</thead>
	</tr>
	<tbody>
		<i:forEach items="${busqueda}" var="contacto">
			<tr>
				<td>${contacto.run}</td>
				<td>${contacto.nombre}</td>	
				<td>${contacto.apellido}</td>
				<td>${contacto.mail}</td>
				<td>${contacto.telefono}</td>
				<td>${contacto.pais}</td>
				<td>${contacto.region}</td>
				<td>${contacto.ciudad}</td>
				<td>${contacto.direccion}</td>		
			</tr>
		</i:forEach>
	</tbody>
	</table>
	
</body>
</html>