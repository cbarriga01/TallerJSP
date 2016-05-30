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
    <script type="text/javascript" src="./js/cargarImg.js"></script>
    
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    
	<link href="./css/estiloMenu.css" rel="stylesheet" />
    
<title>Actualizar datos de contacto</title>
</head>
<body>
	<div class="container">
    <div class="row">
    	<div class="col-sm-3 col-md-3">
    		
    		<div class="nav-side-menu navbar-fixed">
		    <div class="brand">PDS - CRM</div>
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
			<h3>Actualizar Contacto</h3>
			<form action="ServletActualizar" id="ServletActualizar" method="post" class="form-horizontal mitad">
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Id</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" id="idP" name="idP" value="${idContacto}" readonly>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Run</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="run" value="${run}" required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Nombre</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="nombre" value="${nombre}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Apellido</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="apellido" value="${apellido}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Mail</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="mail" value="${mail}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Teléfono</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="telefono" value="${telefono}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">País</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="pais" value="${pais}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Región</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="region" value="${region}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Ciudad</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="ciudad" value="${ciudad}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-lg-3 control-label">Dirección</label>
				<div class="col-lg-3">
					<input type="text" class="form-control" name="direccion" value="${direccion}"required>
					<br>
				</div>
			</div>
			
			<div class="form-group">
	  			<label class="col-lg-3 control-label">Imagen</label>
	  			<div class="col-lg-3">
	  				<input id="inputImagen" name="inputImagen" type="file" multiple accept='image/*' onchange="encodeImageFileAsURL();" />	  			
	  				<br>
				</div>
	  		</div>
	  		
	  		<div class="form-group">
            	<textarea id="textArea" name="textArea" class="form-control textbox" style="display:none;"></textarea>
        	</div>
       
        	<div class="form-group" id="imgContainer"></div>
			
			${lista} 
			
			
			<div class="form-group">
				<div class="col-lg-9 col-lg-offset-3">
					<button type="submit" class="btn btn-success left">Guardar Datos</button>
				</div>
			</div>
			</form>
		
            
            </div> <!-- fin div well -->
        </div> <!-- Fin div segundo col -->
    </div> <!-- Fin div row -->
    </div> <!-- Fin div container -->	
</body>
</html>