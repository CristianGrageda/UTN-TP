package com.utn.tp.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.utn.tp.model.Cliente;
import com.utn.tp.model.Factura;
import com.utn.tp.model.Producto;

public class Supermercado {
	private static final int PUNTOS = 100; // Puntos necesarios para ganar
	private int carritosDisponibles = 50; // Cantidad de carritos a sortear
	private List<Cliente> clientes; // Clientes en el establecimiento
	private List<Producto> productos; // Productos en el supermercado
	private List<Factura> facturas; // Facturas que se van a generar
	
	public Supermercado() {
		this.clientes = new ArrayList<Cliente>();
		this.productos = new ArrayList<Producto>();
		this.facturas = new ArrayList<Factura>();
	}
	
	// --- Genera un numero aleatorio ---
	public static int numeroAleatorio(int maximo,int minimo) {
		return (int)Math.floor(Math.random()*(maximo-minimo)+minimo);
	}
	
	// ------ CARGA LA LISTA CLIENTES DESDE EL ARCHIVO personas.csv ------
	public void cargarClientes(String ruta){
		String linea = ""; // Guarda cada linea/renglon del archivo
		String[] itemPorLinea = null; // Guarda cada palabra separada por "coma" o "punto y coma"
		try {
			// Creando archivos para leer
			File archivo = new File(ruta);
			BufferedReader brPersonas = new BufferedReader(new FileReader(archivo));
			
			// Bucle por cada linea/renglon del archivo
			brPersonas.readLine();
			while((linea = brPersonas.readLine()) != null) {
				itemPorLinea = linea.split(";"); // Separa cada palabra por "punto y coma ';'"
				this.clientes.add(new Cliente(
						Integer.parseInt(itemPorLinea[0]), 
						itemPorLinea[1], 
						itemPorLinea[2], 
						itemPorLinea[3], 
						Integer.parseInt(itemPorLinea[4]), 
						11111111, // DNI: Actualizar archivo csv y codigo
						"+54 9 222222")); // Telefono: Actualizar archivo csv y codigo
			}
			brPersonas.close();
		}catch(Exception e) {
			System.out.println("Error en Carga Clientes: "+e.getMessage());
		}
	}
	
	// ------ CARGA LA LISTA PRODUCTOS DESDE EL ARCHIVO productos.csv ------
	public void cargarProductos(String ruta){
		String linea = ""; // Guarda cada linea/renglon del archivo
		String[] itemPorLinea = null; // Guarda cada palabra separada por "coma" o "punto y coma"
		try {
			// Creando archivos para leer
			File archivo = new File(ruta);
			BufferedReader brProductos = new BufferedReader(new FileReader(archivo));
			
			// Bucle por cada linea/renglon del archivo
			brProductos.readLine();
			while((linea = brProductos.readLine()) != null) {
				itemPorLinea = linea.split(","); // Separa cada palabra por "coma ','"
				if(itemPorLinea.length == 6) { // Se verifica que todos los campos del archivo esten completos
					this.productos.add(new Producto(
						Integer.parseInt(itemPorLinea[2]), 
						itemPorLinea[0], 
						itemPorLinea[1], 
						itemPorLinea[3], 
						Float.parseFloat(itemPorLinea[4]), 
						itemPorLinea[5]));
				}
			}
			
			brProductos.close();
		}catch(Exception e) {
			System.out.println("Error en Carga Productos: "+e.getMessage());
		}
	}
	
	// ------ CADA CLIENTE HACER COMPRAS DE PRODUCTOS AUTOMATICAMENTE ------
	public void hacerCompras(String rutaC, String rutaP) {
		// Se cargan los Clientes y Productos para empezar a operar
		cargarClientes(rutaC);
		cargarProductos(rutaP);
		
		// Cada cliente compra cierta cantidad aleatoria de productos
		for(Cliente cliente: clientes) {
			int cantidadProductos = numeroAleatorio(50, 0);
			for(int i=0 ; i<cantidadProductos ; i++) {
				// Cada cliente elige aleatoriamente un producto mediante su indice
				int indice = numeroAleatorio(productos.size()-1,0);
				cliente.agregarProducto(productos.get(indice));
			}
		}
	}
	
	// --- Verificar si tiene suficientes puntos y la disponibilidad de carritos a sortear ---
	public boolean esGanador(Cliente cliente) {
		boolean resultado = false;
		if(cliente.calcularPuntos() >= PUNTOS && this.carritosDisponibles > 0) {
			resultado = true;
			this.carritosDisponibles--;
		}
		return resultado;
	}
	
	// ------ CARGA LA LISTA FACTURAS MEDIANTE DATOS DE LOS CLIENTES CON SUS COMPRAS ------
	public void generarFacturas() {
		for(Cliente cliente: clientes) {
			int idFactura = 0;
			if(this.facturas.size()>0) {
				idFactura = this.facturas.get(this.facturas.size()-1).getIdFactura()+1;
			}
			this.facturas.add(new Factura(
					idFactura, 
					cliente.getNombre(), 
					cliente.getApellido(), 
					cliente.getDni(), 
					cliente.getTelefono(), 
					cliente.calcularMonto(), 
					cliente.calcularPuntos(), 
					esGanador(cliente)));
		}
	}
	
	// ------ SE GENERA EL ARCHIVO CSV DE LAS FACTURAS ------ 
	public void imprimirFacturas(String ruta) {
		String linea1 = "id,nombre,apellido,dni,telefono,monto,puntos,esGanador";
		try {
			File salida = new File(ruta);
			BufferedWriter bw = new BufferedWriter(new FileWriter(salida));
			bw.write(linea1);
			bw.newLine();
			for(Factura factura: this.facturas) {
				bw.write(factura.toString()); // Escribe en archivo
				bw.newLine(); // Salto de linea en archivo
			}
			
			
			// Cierre de Buffered
			bw.close();
			System.out.println("Archivo generado con exito!");
			
		}catch(IOException e) {
			System.out.println("Error, archivo no generado: \n"+e.getMessage());
		}
	}
	
	

}
