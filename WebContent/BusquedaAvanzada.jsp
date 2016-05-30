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
    
<title>Búsqueda Avanzada</title>
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
			<h3>Búsqueda Avanzada de Contacto</h3>
			<form action="ServletBuscadorAvCont" id="ServletBuscadorAvCont" method="post" 
				class="form-horizontal mitad">
			<div class="form-group">
				<label class="col-lg-3 control-label">Run</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="run">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Nombre</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="nombre">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Apellido</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="apellido">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Mail</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="mail">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Telefono</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="telefono">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Pais</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="pais">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Region</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="region">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Ciudad</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="ciudad">
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Direccion</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="direccion">
					<br>
				</div>
			</div>	
							
			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3">
					<button type="submit" class="btn btn-success left">Enviar</button>
				</div>
			</div>
			</form>
			
			<%try{
				request.getAttribute("busqueda").toString();
			
			%>
			
			<table class="table table-bordered table-hover table-responsive">
			<tr class="success">
				<thead>
					<th>Run</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Imagen</th>
					<th>Empresa</th>
				</thead>
			</tr>
			<tbody>
				<i:forEach items="${busqueda}" var="contacto">
					<tr>
						<td>${contacto.run}</td>
						<td>${contacto.nombre}</td>	
						<td>${contacto.apellido}</td>
						<td id="imgContainer" onLoad="decodeImageURLAsFile();">
							<img src="${contacto.imagen}" width="100px" class = "thumbnail">
						</td>
						<td>${contacto.empresa.nombreEmpresa}</td>
						<td>
							<table>
								<tr>
									<td><form action="ServletActualizarContactoIntermedio" method="post">
										<input type="hidden" value="${contacto.idContacto}" name="id">
										<input type="hidden" value="${contacto.run}" name="run">
										<input type="hidden" value="${contacto.nombre}" name="nombre">
										<input type="hidden" value="${contacto.apellido}" name="apellido">
										<input type="hidden" value="${contacto.mail}" name="mail">
										<input type="hidden" value="${contacto.telefono}" name="telefono">
										<input type="hidden" value="${contacto.pais}" name="pais">
										<input type="hidden" value="${contacto.region}" name="region">
										<input type="hidden" value="${contacto.ciudad}" name="ciudad">
										<input type="hidden" value="${contacto.direccion}" name="direccion">
										<input type="submit" value="Editar" class="btn btn-primary btn-sm">	
									</form>
									</td>
									<td>
									<form action="ServletEliminar" method="post">
										<input type="hidden" value="${contacto.idContacto}" name="idContactoEl">
										<input type="submit" value="Eliminar" class="btn btn-danger btn-sm">	
									</form>
									</td>
									<td>
									<form action="ServletRegistrarBitacoraIntermedio" method="post">
										<input type="hidden" value="${contacto.idContacto}" name="idContacto">
										<input type="hidden" value="${contacto.nombre}" name="nombre">
										<input type="hidden" value="${contacto.apellido}" name="apellido">
										<input type="submit" value="Notas" class="btn btn-warning btn-sm">	
									</form>
									</td>
									<td>
									<form action="ServletVerPerfil" method="post">
										<input type="hidden" value="${contacto.idContacto}" name="idContactoPer">
										<input type="submit" value="Ver Perfil" class="btn btn-primary btn-sm">	
									</form>
									</td>
								</tr>
							</table>
						</td>		
					</tr>
				</i:forEach>
			</tbody>
			</table>
			<%
			}catch(NullPointerException e){
			
			}%>
		
            
            </div> <!-- fin div well -->
        </div> <!-- Fin div segundo col -->
    </div> <!-- Fin div row -->
    </div> <!-- Fin div container -->


	<div class="jumbotron">
		<div class="container">
			<h3>${msg}</h3>
			
		</div>
	</div>	
</body>
</html>