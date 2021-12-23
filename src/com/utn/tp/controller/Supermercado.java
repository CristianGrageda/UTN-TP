package com.utn.tp.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.utn.tp.model.Persona;

//Constante puntos
public class Supermercado {
	private int carritosDisponibles = 100;
	private List<Persona> personas;
	
	public Supermercado() {
		this.personas = new ArrayList<Persona>();
	}
	
	// Genera un numero aleatorio
	public static int numeroAleatorio(int maximo,int minimo) {
		return (int)Math.floor(Math.random()*(maximo-minimo)+minimo);
	}
	
	public void hacerCompra() {
		/*
		 * Se crea lista de Productos
		 * Se selecciona un numero aleatorio para definir cantidad de productos a comprar
		 * Se seleccionan un numeros aleatorio para definir que productos se va a comprar (Mediante indice)
		 * */
	}
	
	public float calcularMonto() {
		
		// Se suman los precios de los productos

		return 0;
	}
	
	public int calcularPuntos() {

		// Se suman los puntos de los productos

		return 0;
	}
	public boolean esGanador() {
		// Verificar puntos y disponibilidad de carritos
		return true;
	}
	
	public void leerPersonas() {
		String linea = ""; // Guarda cada linea/renglon del archivo
		String[] itemPorLinea = null; // Guarda cada palabra separada por "coma" o "punto y coma"
		
		// Rutas de archivos
		String rutaA = "archivos/personas.csv";
		String rutaB = "archivos/productos.csv";
		
		try {
			// Creando archivos para leer
			File archivoPersonas = new File(rutaA);
			File archivoProductos = new File(rutaB);
			BufferedReader brPersonas = new BufferedReader(new FileReader(archivoPersonas));
			BufferedReader brProductos = new BufferedReader(new FileReader(archivoProductos));
			
			// Bucle por cada linea/renglon del archivo
			while((linea = brPersonas.readLine()) != null) {
				itemPorLinea = linea.split(";"); // Separa cada palabra por "punto y coma ;"
				// Como prueba, imprime la persona con ID = 3
				if(itemPorLinea[0].equals("3")){
					System.out.println("ID: "+ itemPorLinea[0]);
					System.out.println("nombre: "+ itemPorLinea[1]);
					System.out.println("apellido: "+ itemPorLinea[2]);
					System.out.println("sexo: "+ itemPorLinea[3]);
					System.out.println("edad: "+ itemPorLinea[4]);
					System.out.println("fecha: "+ itemPorLinea[5]);
				}
			}
			System.out.println("\n\n");
			while((linea = brProductos.readLine()) != null) {
				itemPorLinea = linea.split(",");
				if(itemPorLinea[2].equals("72201")){
					System.out.println("categoria: "+ itemPorLinea[0]);
					System.out.println("producto: "+ itemPorLinea[1]);
					System.out.println("ID: "+ itemPorLinea[2]);
					System.out.println("nombre: "+ itemPorLinea[3]);
					System.out.println("precio: "+ itemPorLinea[4]);
					System.out.println("precio unitario: "+ itemPorLinea[5]);
				}
			}
			brPersonas.close();
			brProductos.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
