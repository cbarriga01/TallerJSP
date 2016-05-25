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
<title>Actualizar datos de usuario</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<h3>${msg}</h3>
			<h3>Actualizar Usuario</h3>
			<form action="ServletActualizarUsuario" id="ServletActualizarUsuario" method="post" class="form-horizontal mitad" action="#">
			<div class="form-group">
				<label class="col-lg-3 control-label">Id</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="id" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">User</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="user" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Password</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="password" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3">
					<button type="submit" class="btn btn-success left">Enviar</button>
				</div>
			</div>
			</form>
		</div>
	</div>
</body>
</html>