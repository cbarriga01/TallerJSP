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
    
    <jsp:include page="Menu.jsp"></jsp:include>
    
<title>Lista de Empresas</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h3>${msg}</h3>
			<h3>Lista de Empresas</h3>
			<table class="table table-bordered table-hover table-responsive">
			<tr class="success">
				<thead>
					<th>Rut</th>
					<th>Razón Social</th>
					<th>Nombre</th>
					<th>Representante</th>
					<th>Mail</th>
					<th>Teléfono</th>
					<th>País</th>
					<th>Región</th>
					<th>Ciudad</th>
					<th>Domicilio</th>
				</thead>
			</tr>
			<tbody>
				<i:forEach items="${listaEmpresa}" var="empresa">
					<tr>
						<td>${empresa.rut}</td>
						<td>${empresa.razonSocial}</td>
						<td>${empresa.nombreEmpresa}</td>	
						<td>${empresa.representante}</td>
						<td>${empresa.mailEmpresa}</td>
						<td>${empresa.telefonoEmpresa}</td>
						<td>${empresa.paisEmpresa}</td>
						<td>${empresa.regionEmpresa}</td>
						<td>${empresa.ciudadEmpresa}</td>
						<td>${empresa.domicilio}</td>
						<td>
						<table>
							<tr>
								<td><form action="ActualizarEmpresa.jsp" method="post">
									<input type="hidden" value="${empresa.idEmpresa}" name="idUsuario">
									<input type="submit" value="Editar" class="btn btn-primary">	
								</form>
								</td>
								<td>
								<form action="EliminarEmpresa" method="post">
									<input type="hidden" value="${empresa.idEmpresa}" name="idEmpresaEl">
									<input type="submit" value="Eliminar" class="btn btn-danger">	
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