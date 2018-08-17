<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Artículo</title>
</head>
<body>
	<h1>Actualizar Artículo</h1>
	<form action="clienteController?action=editar" method="post">
		<table>
			<tr>
				<td><label>Id</label></td>
				<td><input type="text" name="id"
					value="<c:out value="${cliente.id}"></c:out>"></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input type="text" name="nombre"
					value='<c:out value="${cliente.nombre}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Apellidos</label></td>
				<td><input type="text" name="apellidos"
					value='<c:out value="${cliente.apellidos}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>Fecha de nacimiento</label></td>
				<td><input type="text" name="descripcion"
					value='<c:out value="${cliente.fechaNacimiento}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Numero de socio</label></td>
				<td><input type="text" name="existencia"
					value='<c:out value="${cliente.numeroSocio}"></c:out>'></td>
			</tr>

			<tr>
				<td><label>email</label></td>
				<td><input type="text" name="precio"
					value='<c:out value="${cliente.email}"></c:out>'></td>
			</tr>
			<tr>
				<td><label>Teléfono</label></td>
				<td><input type="text" name="precio"
					value='<c:out value="${cliente.telefono}"></c:out>'></td>
			</tr>
		</table>
		<input type="submit" value="Guardar" name="register">
		<table>
			<tr>
				<td><a href="clienteController?action=index">VOLVER AL
						MENU</a></td>
			</tr>
		</table>
	</form>

</body>
</html>