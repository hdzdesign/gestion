package com.cien.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cien.dao.ClienteDAO;
import com.cien.model.Cliente;

@WebServlet("/clienteController")
public class ClienteController extends HttpServlet {
	ClienteDAO clienteDAO;

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcUsername");

		clienteDAO = new ClienteDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet DoGet Cliente");
		String action = request.getParameter("action");
		System.out.println(action);
		if (action != null) {
			try {
				switch (action) {
				case "index":
					index(request, response);
					break;
				case "nuevo":
					nuevo(request, response);
					break;
				case "register":
					registrar(request, response);
					break;
				case "mostrar":
					mostrar(request, response);
					break;
				case "buscarPorNombre":
					buscarPorNombre(request, response);
					break;
				case "showedit":
					showEdit(request, response);
					break;
				case "editar":
					editar(request, response);
					break;
				case "eliminar":
					eliminar(request, response);
					break;
				default:
					break;
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet DoPost Cliente");
		doGet(request, response);
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		Cliente cliente = new Cliente(0, request.getParameter("nombre"), request.getParameter("apellidos"),
				request.getParameter("fnacimiento"), request.getParameter("numerosocio"), request.getParameter("email"),
				request.getParameter("telefono"));
		clienteDAO.guardarCliente(cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/nuevo-cliente.jsp");
		dispatcher.forward(request, response);
	}

	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/mostrar-clientes.jsp");
		List<Cliente> listaClientes = clienteDAO.listaDeClientes();
		request.setAttribute("lista", listaClientes);
		dispatcher.forward(request, response);
	}
	private void showEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Cliente cliente = clienteDAO.obtenerCliente(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("cliente", cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/vista/editar-cliente.jsp");
		dispatcher.forward(request, response);
	}
	private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Cliente cliente = new Cliente(Integer.parseInt(request.getParameter("id")),
				request.getParameter("nombre"),
				request.getParameter("apellidos"),
				request.getParameter("fechaNacimiento"),
				request.getParameter("numeroSocio"),
				request.getParameter("email"),
				request.getParameter("telefono"));
		clienteDAO.actualizarCliente(cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		
	}
	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		Cliente cliente = clienteDAO.obtenerCliente(Integer.parseInt(request.getParameter("id")));
		clienteDAO.eliminarCliente(cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}
	private void buscarPorNombre(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String nombreEstudiante = request.getParameter("nombreCliente");
		List<Cliente> result = clienteDAO.buscarPorNombre(nombreEstudiante);
		mostrar(request, response);
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
