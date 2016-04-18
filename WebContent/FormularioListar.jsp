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
<title>Insert title here</title>
</head>
<body>
	<form action="ServletListar" method="get">
	<div class="row">
                        <div class="col-sm-1" style="background-color:lavender;"> Nombre </div>
                        <div class="col-sm-2" style="background-color:lavender;"> Apellido </div>
                        <div class="col-sm-1" style="background-color:lavender;"> Mail </div>
                        <div class="col-sm-1" style="background-color:lavender;"> Telefono </div>
                        <div class="col-sm-1" style="background-color:lavender;"> Pais </div>
                        <div class="col-sm-1" style="background-color:lavender;"> Region </div>
                        <div class="col-sm-1" style="background-color:lavender;"> Ciudad </div>
                    </div>
		<i:forEach items="${nombre}" var="contacto">
 		${contacto.nombre} : ${contacto.apellido} : ${contacto.mail} :
 		${contacto.telefono} : ${contacto.pais} : ${contacto.region} : ${contacto.ciudad}		
		<br/>
		<div class="row">
			<div class="col-sm-1" style="background-color:lavender;"> ${contacto.nombre} </div>
                        <div class="col-sm-2" style="background-color:lavender;"> ${contacto.apellido} </div>
                        <div class="col-sm-1" style="background-color:lavender;"> ${contacto.mail} </div>
                        <div class="col-sm-1" style="background-color:lavender;"> ${contacto.telefono} </div>
                        <div class="col-sm-1" style="background-color:lavender;"> ${contacto.pais} </div>
                        <div class="col-sm-1" style="background-color:lavender;"> ${contacto.region} </div>
                        <div class="col-sm-1" style="background-color:lavender;"> ${contacto.ciudad} </div>
		</div>
		</i:forEach>
		<button type="submit" class="btn btn-success left">Listar</button>
	</form>
</body>
</html>