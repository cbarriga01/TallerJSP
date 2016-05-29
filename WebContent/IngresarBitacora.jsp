<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ page import="java.util.*" %>
  <%@ page import="capanegocio.Contacto" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet"></link>
    <link href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css" rel="stylesheet"></link>
    
    <script src="//oss.maxcdn.com/jquery/1.11.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>
     
    <script type="text/javascript" src="./js/validador.js"></script>
    <script type="text/javascript" src="./js/cargarImg.js"></script>
    
    <jsp:include page="Menu.jsp"></jsp:include>
    
<title>Ingresar Bitácora a Contacto</title>
</head>
<body>
	
	<div class="jumbotron">
		<div class="container">
			<h3>Ingresar Bitacora de Anotaciones</h3>
			<h3>${msg}</h3>
			<form action="ServletRegistrarBitacora" id="ServletRegistrarBitacora" method="POST" class="form-horizontal mitad">
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Titulo</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="titulo" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Texto</label>
				<div class="col-lg-3">
					<textarea class="form-control" id="texto" name="texto" required></textarea>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Contacto</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="idContacto" value="${idContacto}" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3">
					<button type="submit" class="btn btn-success left">Guardar Datos</button>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>