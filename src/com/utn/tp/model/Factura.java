package com.utn.tp.model;

public class Factura {
	private int idFactura;
	private String nombre;
	private String apellido;
	private int dni;
	private String telefono;
	private float monto;
	private int puntos;
	private boolean esGanador;
	public Factura(int idFactura, String nombre, String apellido, int dni, String telefono, float monto, int puntos,
			boolean esGanador) {
		this.idFactura = idFactura;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.monto = monto;
		this.puntos = puntos;
		this.esGanador = esGanador;
	}
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
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
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public boolean isEsGanador() {
		return esGanador;
	}
	public void setEsGanador(boolean esGanador) {
		this.esGanador = esGanador;
	}
	
	@Override
	public String toString() {
		return idFactura + "," + nombre + "," + apellido + "," + dni
				+ "," + telefono + "," + monto + "," + puntos + "," + esGanador;
	}
	
}
