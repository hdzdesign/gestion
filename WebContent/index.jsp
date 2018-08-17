<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Artículos Java Web JSP y Servlet</title>
</head>
<body>
<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>

	
	<div class="container">
	<h2>Clientes</h2>
	<!-- Formulario buscar cliente -->
	<form action="clienteController" method="get" id="buscarEmployeeForm"
		role="form">
		<input type="hidden" id="buscarAction" name="action"
			value="buscarPorNombre">
		<div class="form-group col-xs-5">
			<input type="text" name="nombreCliente" id="nombreEstudiante"
				class="form-control" required="true"
				placeholder="Escriba el nombe o apellido del Estudiante" />
		</div>
		<button type="submit" class="btn btn-info">
			<span class="glyphicon glyphicon-search"></span> Buscar
		</button>
	</form>
	
	<h1>Administrar Artículos</h1>
	<table border="1" width="50%" align="center">
		<tr>
			<td align="center"><a href="articuloController?action=nuevo">Nuevo</a></td>
		</tr>
		<tr>
			<td align="center"><a href="articuloController?action=mostrar">Mostrar</a></td>
		</tr>
		<tr>
			<td align="center"><a href="clienteController?action=nuevo">nuevo CLiente</a></td>
		</tr>
		
		<tr>
			<td align="center"><a href="clienteController?action=mostrar">MOSTRAR CLIENTES</a></td>
		</tr>
	</table>


</body>
</html>