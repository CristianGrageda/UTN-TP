package com.utn.tp.model;

public class Producto {
	private int idProducto;
	private String categoria;
	private String producto;
	private String nombre;
	private float precio;
	private String precioUnitario;
	
	// CONSTRUCTOR
	public Producto(int idProducto, String categoria, String producto, String nombre, float precio,
			String precioUnitario) {
		this.idProducto = idProducto;
		this.categoria = categoria;
		this.producto = producto;
		this.nombre = nombre;
		this.precio = precio;
		this.precioUnitario = precioUnitario;
	}
	
	// GETTERS Y SETTERS
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
