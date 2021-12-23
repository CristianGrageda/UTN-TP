package com.utn.tp.model;

public class Persona {
	private int idPersona;
	private String nombre;
	private String apellido;
	private int sexo;
	private int edad;
	private int dni;
	private String telefono;
	
	// CONSTRUCTOR
	public Persona(int idPersona, String nombre, String apellido, int sexo, int edad, int dni, String telefono) {
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.edad = edad;
		this.dni = dni;
		this.telefono = telefono;
	}

	// GETTERS Y SETTERS
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getSexo() {
		return sexo;
	}

	public void setSexo(int sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
