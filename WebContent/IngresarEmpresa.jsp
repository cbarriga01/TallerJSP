<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
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
    
<title>Ingresar datos de empresa</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h3>Ingresar Empresa</h3>
			<form action="ServletRegistrarEmpresa" id="ServletRegistrarEmpresa" method="post" class="form-horizontal mitad">
		
			<div class="form-group">
				<label class="col-lg-3 control-label">Rut</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="rut" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Razon Social</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="razonSocial" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Nombre</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="nombre" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Representante</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="representante" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Mail</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="mail" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Teléfono</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="telefono" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">País</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="pais" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Región</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="region" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Ciudad</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="ciudad" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Domicilio</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="domicilio" required>
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