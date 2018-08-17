package com.cien.model;

public class Cliente {

	private int id;
	private String nombre;
	private String apellidos;
	private String fechaNacimiento;
	private String numeroSocio;
	private String email;
	private String telefono;

	public Cliente() {

	}

	public Cliente(int id, String nombre, String apellidos, String fechaNacimiento, String numeroSocio, String email,
			String telefono) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.numeroSocio = numeroSocio;
		this.email = email;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNumeroSocio() {
		return numeroSocio;
	}

	public void setNumeroSocio(String numeroSocio) {
		this.numeroSocio = numeroSocio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente" + "· nomnbre: " + nombre + "" + "· apellidos: " + apellidos + "· fechaNacimiento: "
				+ fechaNacimiento + "· numeroSocio: " + numeroSocio + "· email: " + email;
	}

}
