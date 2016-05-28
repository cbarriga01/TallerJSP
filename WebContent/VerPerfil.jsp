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
     
    <script type="text/javascript" src="./js/validador.js"></script>
    <script type="text/javascript" src="./js/cargarImg.js"></script>
    
    <jsp:include page="Menu.jsp"></jsp:include>
<title>Perfil de Contacto</title>
</head>
<body>
	<div class="jumbotron vertical-center">
		<div class="container">

			<table class="table table-bordered table-hover table-responsive">
					<tr class="success">
						<td>Rut</td>
						<td>${contacto.run}</td>
					</tr>
					<tr>
						<td>Nombre</td>
						<td>${contacto.nombre}</td>
					</tr>
					<tr>
						<td>Apellidos</td>
						<td>${contacto.apellido}</td>
					</tr>
					<tr>
						<td>Mail</td>
						<td>${contacto.mail}</td>
					</tr>
					<tr>
						<td>Telefono</td>
						<td>${contacto.telefono}</td>
					</tr>
					<tr>
						<td>País</td>
						<td>${contacto.pais}</td>
					</tr>
					<tr>
						<td>Region</td>
						<td>${contacto.region}</td>
					</tr>
					<tr>
						<td>Ciudad</td>
						<td>${contacto.ciudad}</td>
					</tr>
					<tr>
						<td>Dirección</td>
						<td>${contacto.direccion}</td>
					</tr>
					<tr>
						<td>Imagen</td>
						<td id="imgContainer" onLoad="encodeImageFileAsURL();">
						<img src="${contacto.imagen}" width="100px" class = "thumbnail">
						</td>
					</tr>
					<tr>
						<td>Empresa</td>
						<td>${contacto.empresa.nombreEmpresa}</td>
					</tr>
				</table>
			</div>
		</div>
</body>
</html>