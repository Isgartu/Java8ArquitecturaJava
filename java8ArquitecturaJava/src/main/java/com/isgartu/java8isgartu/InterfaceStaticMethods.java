package com.isgartu.java8isgartu;

import java.util.Arrays;
import java.util.List;

import com.isgartu.java8isgartu.utils.Libro2;
import com.isgartu.java8isgartu.utils.Producto;
import com.isgartu.java8isgartu.utils.Telefono;

/**
 * https://www.arquitecturajava.com/java-8-interface-static-methods/
 */
public class InterfaceStaticMethods {

	public static void main(String[] args) {
		
		Libro2 l1 = new Libro2("Dune", 10);
		Libro2 l2 = new Libro2("Java", 20);
		Telefono t1 = new Telefono("iphone", "apple", 600);
		
		List<Producto> listaProductos = Arrays.asList(l1, l2, t1);
		
		int total = 0;
		for(Producto p : listaProductos) {
			total += p.getPrecio();
		}
		System.out.println(total);
		
		//Podemos realizar la operacion con un Stream:
		System.out.println("\nCon stream:");
		System.out.println(listaProductos.stream().mapToInt((p) -> p.getPrecio()).sum());

		//Hacemos uso de referencia a metodo
		System.out.println("\nReplace this lambda with a method reference.");
		System.out.println(listaProductos.stream().mapToInt(Producto::getPrecio).sum());
		
		
		//Estas dos/tres formas no son la solucion idonea. Podemos reutilizarla con Java 8
		//creando metodos estaticos en los interfaces
		
		System.out.println("\nLamada al static method del interface");
		int pro =  Producto.importeTotal(listaProductos);
		System.out.println(pro);
		
		//Otra forma reducida sin crear la variable
		System.out.println("\nLlamada al static method del interface directamente\n" + Producto.importeTotal(listaProductos));
		
		//Otra forma mas reducida aun donde creamos la lista, calculamos el importeTotal e imprimimos
		System.out.println("\nCreacion de lista, calculo del importeTotal e impresion en la misma linea:\n" + Producto.importeTotal(Arrays.asList(l1, l2, t1)));
		
	}
}
