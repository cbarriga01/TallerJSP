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
    <link href="./css/signin.css" rel="stylesheet">
    
<title>Login</title>
</head>
<body>
	
	
	<div class="container">

      <form class="form-signin" role="form" action="ServletLogin" id="ServletLogin" method="post">
        <h2 class="form-signin-heading">Ingrese sus datos</h2>
        <div class="form-group">
        	<input type="text" class="form-control" name="user" placeholder="Nombre de usuario" required>
        </div>
        <div class="form-group">
        	<input type="password" class="form-control" name="password" placeholder="Password" required>
        </div>
        <div class="form-group">
        	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </div>
      </form>

    </div>
	
	
</body>
</html>