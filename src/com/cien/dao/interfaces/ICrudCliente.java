package com.cien.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.cien.model.Cliente;

public interface ICrudCliente {
	
	public List<Cliente> listaDeClientes() throws SQLException;
	
	public List<Cliente> buscarPorNombre(String nombre) throws SQLException;
	
	public Cliente obtenerCliente(long id) throws SQLException;
	
	public boolean guardarCliente(Cliente cliente) throws SQLException;
	
	public boolean actualizarCliente(Cliente cliente) throws SQLException;
	
	public boolean eliminarCliente(Cliente cliente) throws SQLException;
	

}
