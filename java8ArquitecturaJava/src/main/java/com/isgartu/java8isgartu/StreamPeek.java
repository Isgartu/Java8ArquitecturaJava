package com.isgartu.java8isgartu;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.arquitecturajava.com/utilizando-java-stream-peek-y-logging/
 */
public class StreamPeek {

	public static void main(String[] args) {
		//Ejemplo basado en un array de cadenas y su manejo con streams:
		List<String> lista = Arrays.asList("hola", "que", "tal", "estas", "tu");
		lista.stream().filter((cadena) -> cadena.length() > 3).map((cadena) -> cadena.toUpperCase()).forEach(System.out::println);
		
		/*Hemos realizado una operacion de filtrado y una transformacion de strings para luego finalmente imprimir el resultado en consola
		Nos hemos quedado con las cadenas que tienen una longitud mayor de 3 caracteres y las hemos pasado a mayusculas.*/
		
		/*En otras situaciones nos puede generar dudas el tipo de operacion que se ha ejecutado. Con Stream Peek podemos realizar
		un logging de cada paso que realizamos en el flujo de Stream */
		lista.stream()
			.peek((cadena) -> {
				System.out.println("***inicio***");
				System.out.println(cadena);
				System.out.println("***fin inicio***");
				
			}).filter((cadena) -> cadena.length() > 3)
			.peek((cadena) -> {
				System.out.println("---filter---");
				System.out.println(cadena);
				System.out.println("---fin filter---");
				
			}).map((cadena) -> cadena.toUpperCase())
			.peek((cadena) -> {
				System.out.println("<<<mayusculas>>>");
				System.out.println(cadena);
				System.out.println("<<<fin mayusculas>>>");
			})
			.forEach(System.out::println);
		
		/*
		 * Con peek podemos ver con claridad como funciona un stream
		 * 
		 * hola		filter		hola	map		HOLA	foreach
		 * que		filter		fin
		 * tal		filter		fin
		 * estas	filter		estas	map		ESTAS	foreach
		 * tu		filter		fin
		 */
	}

}
