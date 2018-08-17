package com.cien.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Request;

import com.cien.dao.interfaces.ICrudCliente;
import com.cien.model.Cliente;
import com.cien.model.Conexion;

public class ClienteDAO implements ICrudCliente {
	Connection connection;
	Conexion con;

	public ClienteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		System.out.println(jdbcURL);
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);

	}

	@Override
	public List<Cliente> listaDeClientes() throws SQLException {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String sql = "SELECT id, nombre, apellidos, fecha_nacimiento, numero_socio, email, telefono FROM clientes";
		con.conectar();
		connection=con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resulset = statement.executeQuery(sql);
		while(resulset.next()){
			int id = resulset.getInt("id");
			String nombre = resulset.getString("nombre");
			String apellidos = resulset.getString("apellidos");
			String fechaNacimiento = resulset.getString("fecha_nacimiento");
			String numeroSocio = resulset.getString("numero_socio");
			String email = resulset.getString("email");
			String telefono = resulset.getString("telefono");
			Cliente cliente = new Cliente(id, nombre, apellidos, fechaNacimiento, numeroSocio, email, telefono);
			listaClientes.add(cliente);
		}
		resulset.close();
		connection.close();
		return listaClientes;
	}

	@Override
	public List<Cliente> buscarPorNombre(String nombre) throws SQLException {
		List<Cliente> listaClientes = listaDeClientes();
		Comparator<Cliente> comparator = Comparator.
				comparing(Cliente::getNombre).
				thenComparing(Cliente::getApellidos);
		
				listaClientes.stream().filter(e -> e.getNombre().equalsIgnoreCase(nombre) ||
				e.getApellidos().equalsIgnoreCase(nombre))
				.sorted(comparator).collect(Collectors.toList());
		return listaClientes;
	}

	@Override
	public Cliente obtenerCliente(long id) throws SQLException {
		Cliente cliente = null;
		String sql = "SELECT  id, nombre, apellidos, fecha_nacimiento, numero_socio, email, telefono FROM clientes";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulset = statement.executeQuery(sql);
		if(resulset.next()) {
			 cliente = new Cliente(resulset.getInt("id"), resulset.getString("nombre"),
					resulset.getString("apellidos"), resulset.getString("fecha_nacimiento"),
					resulset.getString("numero_socio"), resulset.getString("email"), resulset.getString("telefono"));
		}
		resulset.close();
		statement.close();
		con.desconectar();
		
		return cliente;
	}

	@Override
	public boolean guardarCliente(Cliente cliente) throws SQLException {
		String sql = "INSERT INTO clientes(id, nombre, apellidos, fecha_nacimiento, numero_socio, email, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, cliente.getNombre());
		statement.setString(3, cliente.getApellidos());
		statement.setString(4, cliente.getFechaNacimiento());
		statement.setString(5, cliente.getNumeroSocio());
		statement.setString(6, cliente.getEmail());
		statement.setString(7, cliente.getTelefono());
		boolean rowInserted = statement.executeUpdate() > 0;
		System.out.println("Cliete añadido");
		System.out.println(cliente.toString());
		con.desconectar();
		statement.close();
		
		return rowInserted;
	}

	@Override
	public boolean actualizarCliente(Cliente cliente) throws SQLException {
		String sql = "UPDATE clientes SET nombre=?,apellidos=?,fecha_nacimiento=?,numero_socio=?,email=?,telefono=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, cliente.getNombre());
		statement.setString(2, cliente.getApellidos());
		statement.setString(3, cliente.getFechaNacimiento());
		statement.setString(4, cliente.getNumeroSocio());
		statement.setString(5, cliente.getEmail());
		statement.setString(6, cliente.getTelefono());
		statement.setInt(7, cliente.getId());
		boolean rowSelect = statement.executeUpdate()>0;
		System.out.println("El resultado actualizado es : " + cliente.toString());
		statement.close();
		con.desconectar();	
		
		return rowSelect;
	}

	@Override
	public boolean eliminarCliente(Cliente cliente) throws SQLException {
		String sql = "DELETE FROM clientes WHERE ID= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, cliente.getId());
		boolean rowDelete = statement.executeUpdate()>0;
		System.out.println("El cliente borrado es + " + cliente.toString());
		statement.close();
		con.desconectar();
		
		return rowDelete;
	}

}
