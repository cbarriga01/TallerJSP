<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
    
    <script type="text/javascript" src="./js/cargarImg.js"></script>
    <jsp:include page="Menu.jsp"></jsp:include>
    
<title>Lista de contactos</title>
</head>
<body>
	<div class="jumbotron vertical-center">
		<div class="container">
			<h3>Lista de Contactos</h3>
			<table class="table table-bordered table-hover table-responsive">
			<tr class="success">
				<thead>
					<th>Run</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Mail</th>
					<th>Teléfono</th>
					<th>País</th>
					<th>Región</th>
					<th>Ciudad</th>
					<th>Dirección</th>
					<th>Imagen</th>
					<th>Empresa</th>
				</thead>
			</tr>
			<tbody>
				<i:forEach items="${listaContacto}" var="contacto">
					<tr>
						<td>${contacto.idContacto}</td>
						<td>${contacto.run}</td>
						<td>${contacto.nombre}</td>	
						<td>${contacto.apellido}</td>
						<td>${contacto.mail}</td>
						<td>${contacto.telefono}</td>
						<td>${contacto.pais}</td>
						<td>${contacto.region}</td>
						<td>${contacto.ciudad}</td>
						<td>${contacto.direccion}</td>
						<td id="imgContainer" onLoad="decodeImageURLAsFile();">
							<img src="${contacto.imagen}" width="100px" class = "thumbnail">
						</td>
						<td>${contacto.empresa.nombreEmpresa}</td>
						<td>
						<table>
							<tr>
								<td><form action="ActualizarUsuario.jsp" method="post">
									<input type="hidden" value="${contacto.idContacto}" name="idUsuario">
									<input type="submit" value="Editar" class="btn btn-primary">	
								</form>
								</td>
								<td>
								<form action="EliminarUsuario" method="post">
									<input type="hidden" value="${contacto.idContacto}" name="idUsuario">
									<input type="submit" value="Eliminar" class="btn btn-danger">	
								</form>
								</td>
								<td>
								<form action="IngresarBitacora.jsp" method="post">
									<input type="hidden" value="${contacto.idContacto}" name="idContacto">
									<input type="submit" value="Ingresar Bitacora" class="btn btn-danger">	
								</form>
								</td>
							</tr>
						</table>
					</td>	
					</tr>
				</i:forEach>
			</tbody>
			</table>
		</div>
	</div>
</body>
</html>