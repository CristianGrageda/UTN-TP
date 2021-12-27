package com.utn.tp.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
	private List<Producto> carrito;
	
	public Cliente(int idPersona, String nombre, String apellido, int edad, int dni, String telefono) {
		super(idPersona, nombre, apellido, edad, dni, telefono);
		this.carrito = new ArrayList<Producto>();
	}
	
	// Agrega productos al carrito
	public void agregarProducto(Producto producto) {
		this.carrito.add(producto);
	}
	
	// Se suman los precios de los productos
	public float calcularMonto() {
		float monto = 0;
		for(Producto item: this.carrito) {
			monto += item.getPrecio();
		}
		monto = (float) (Math.round(monto * 100) / 100d);
		return monto;
	}
	
	// Se suman los puntos de los productos
	public int calcularPuntos() {
		int puntos = 0;
		puntos = (int) calcularMonto()/10;
		return puntos;
	}

	public List<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Producto> carrito) {
		this.carrito = carrito;
	}
	
}
