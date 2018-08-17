<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrar Clientes</title>
</head>
<body>
<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/bootstrap.min.js"></script>

	<!-- LISTA CLIENTES -->
	<div class="container">	
	<h1>Lista  clientes</h1>
	<table>
		<tr>
			<td><a href="clienteController?action=index" >Ir al menú</a> </td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td> ID</td>
		 <td> NOMBRE</td>
		 <td> APELLIDOS </td>
		 <td>FECHA DE NACIMIENTO</td>
		 <td>NUMERO DE SOCIO</td>
		 <td>EMAIL</td>
		 <td>TELEFONO</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="cliente" items="${lista}">
			<tr>
				<td><c:out value="${cliente.id}"/></td>
				<td><c:out value="${cliente.nombre}"/></td>
				<td><c:out value="${cliente.apellidos}"/></td>
				<td><c:out value="${cliente.fechaNacimiento}"/></td>
				<td><c:out value="${cliente.numeroSocio}"/></td>
				<td><c:out value="${cliente.email}"/></td>
				<td><c:out value="${cliente.telefono}"/></td>
				<td><a href="clienteController?action=showedit&id=<c:out value="${cliente.id}" />">Editar</a></td>
				<td><a href="clienteController?action=eliminar&id=<c:out value="${cliente.id}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
	</div>
</body>

	
	

</html>