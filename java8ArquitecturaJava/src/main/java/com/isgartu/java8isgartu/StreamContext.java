package com.isgartu.java8isgartu;

import java.util.Arrays;
import java.util.List;

import com.isgartu.java8isgartu.utils.Compra;

/**
 * https://www.arquitecturajava.com/java-stream-context/
 */
public class StreamContext {

	public static void main(String[] args) {
		
		Compra c1 = new Compra(1,100);
		Compra c2 = new Compra(2,130);
		Compra c3 = new Compra(3,130);
		
		List<Compra> misCompras = Arrays.asList(c1, c2, c3);
		
		// Recorrer lista de compras, sumar aquellas que impuestos incluidos superen los 150 euros
		// y calcular el importe de compras mas caras
		System.out.println("Forma regular de Stream:");
		misCompras.stream().map(c -> c.getImporte()*1.21).filter(i -> i > 150).reduce(Double::sum).ifPresent(System.out::println);
		
		//Podemos cambiar el Stream para compactarlo aplicando el contexto de nuestra lista de objetos con la funcion nueva getImporteIVA de la clase Compra
		System.out.println("\nForma compacta aplicando el contexto:");
		misCompras.stream().map(Compra::getImporteIVA).filter(i -> i > 150).reduce(Double::sum).ifPresent(System.out::println);
		
		//Creando un Predicate en la clase Compra (funcion: esCaro()) el codigo queda mas sencillo
		//Usamos Java Stream Context y Predicate para manejar la lista de compra de forma natural
		System.out.println("\nCon Predicate");
		misCompras.stream().filter(Compra::esCaro).map(Compra::getImporteIVA).reduce(Double::sum).ifPresent(System.out::println);
	}
}
