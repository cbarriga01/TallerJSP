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
    
    <jsp:include page="Menu.jsp"></jsp:include>
    
<title>Lista de usuarios</title>
</head>
<body>

	<table class="table table-bordered table-hover table-responsive">
	<tr class="success">
		<th>Usuario</th>
		<th>Contraseña</th>
	</tr>
	
	<i:forEach items="${user}" var="usuario">
		<tr>
			<td>${usuario.user}</td>
			<td>${usuario.password}</td>
			<td>
				<table>
					<tr>
						<td><form action="ActualizarUsuario.jsp" method="post">
							<input type="hidden" value="${usuario.idusuario}" name="idP">
							<input type="submit" value="Editar" class="btn btn-primary">	
						</form>
						</td>
						<td>
						<form action="EliminarUsuario" method="post">
							<input type="hidden" value="${usuario.idusuario}" name="idP">
							<input type="submit" value="Eliminar" class="btn btn-danger">	
						</form>
						</td>
					</tr>
				</table>
				
			</td>
			
		</tr>
	</i:forEach>
	</table>
	
	<form action="ServletListarUsuario" method="get">
	<div class="row">
                        <div class="col-sm-1" style="background-color:lavender;"> User </div>
                        <div class="col-sm-2" style="background-color:lavender;"> Password </div>
                    </div>
		<i:forEach items="${user}" var="usuario">
 		${usuario.user} : ${usuario.password}		
		<br/>
		<div class="row">
			<div class="col-sm-1" style="background-color:lavender;"> ${usuario.user} </div>
            <div class="col-sm-2" style="background-color:lavender;"> ${usuario.password} </div>
		</div>
		</i:forEach>
		<button type="submit" class="btn btn-success left">Listar</button>
	</form>
</body>
</html>