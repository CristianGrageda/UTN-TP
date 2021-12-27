package com.utn.tp;

import com.utn.tp.controller.Supermercado;

public class Main {

	public static void main(String[] args) {
		String rutaC = "archivos/personas.csv";
		String rutaP = "archivos/productos.csv";
		String rutaF = "archivos/facturas.csv";
		Supermercado supermercado = new Supermercado();
		supermercado.hacerCompras(rutaC, rutaP);
		supermercado.generarFacturas();
		supermercado.imprimirFacturas(rutaF);
	}

}
