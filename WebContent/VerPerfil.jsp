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
    
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
	
	<link href="./css/estiloMenu.css" rel="stylesheet" />
	
<title>Perfil de Contacto</title>
</head>
<body>
	<div class="container">
    <div class="row">
    	<div class="col-sm-3 col-md-3">
    		
    		<div class="nav-side-menu navbar-fixed">
		    <div class="brand">Brand Logo</div>
		    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
		        <div class="menu-list">
		            <ul id="menu-content" class="menu-content collapse out">
		                <li>
		                  <a href="index.jsp"><i class="fa fa-home fa-lg"></i>Home</a>
		                </li>
		                <li data-toggle="collapse" data-target="#contacto" class="collapsed active">
		                  <a href="#"><i class="fa fa-edit fa-lg"></i> Contacto Empresarial <span class="arrow"></span></a>
		                </li>
			                <ul class="sub-menu collapse" id="contacto">
			                    <li><a href="TallerServlet">Ingresar Contacto</a></li>
			                    <li><a href="ServletListar">Listar Contactos</a></li>
			                </ul>
			            <li data-toggle="collapse" data-target="#busqueda" class="collapsed">
		                  <a href="#"><i class="fa fa-book fa-lg"></i> Búsquedas <span class="arrow"></span></a>
		                </li>  
		                <ul class="sub-menu collapse" id="busqueda">
		                  <li><a href="BusquedaSimple.jsp">Búsqueda Simple</a></li>
			              <li><a href="BusquedaAvanzada.jsp">Búsqueda Avanzada</a></li>
		                </ul>
		               	<li>
		                  	<a href="ServletLogin">
		                  	<i class="fa fa-sign-out fa-lg"></i> Logout
		                  	</a>
		              	</li>
		            </ul>
		    	</div>
			</div>
    	
    	</div> <!-- Fin div primer col -->
    	
    	<div class="col-sm-9 col-md-9">
            <div class="jumbotron">
            
			<h3>${msg}</h3>
			<table class="table table-bordered table-hover table-responsive">
					<tr>
						<td>Imagen</td>
						<td id="imgContainer" onLoad="encodeImageFileAsURL();">
						<img src="${contacto.imagen}" width="100px" class = "thumbnail">
						</td>
					</tr>
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
						<td>Empresa</td>
						<td>${contacto.empresa.nombreEmpresa}</td>
					</tr>
				</table>

            </div> <!-- fin div well -->
        </div> <!-- Fin div segundo col -->
    </div> <!-- Fin div row -->
    </div> <!-- Fin div container -->

</body>
</html>