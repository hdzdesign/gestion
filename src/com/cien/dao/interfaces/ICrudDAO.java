package com.cien.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import com.cien.model.Articulo;

public interface ICrudDAO {
	
	public boolean insertar(Articulo articulo) throws SQLException;
	
	public List<Articulo> buscarPorNombre(String nombre);
	
	public List<Articulo> listarTodo() throws SQLException;
	
	public Articulo obtenerPorId(int id) throws SQLException;
	
	public boolean actualizar(Articulo articulo) throws SQLException;
	
	public boolean eliminar(Articulo articulo) throws SQLException;
	
	
	

}

