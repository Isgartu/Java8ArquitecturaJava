package com.isgartu.java8isgartu;

import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * https://www.arquitecturajava.com/java-stream-string-y-java-8/
 */
public class StreamString {

	public static void main(String[] args) {

		String texto = "hola que tal estas";
		long total = texto.chars()
				.mapToObj(i -> (char) i)
				.filter((l) -> l == 'a')
				.count();
		System.out.println(total);
		
		//Acabamos de contar el numero de letras 'a' que tiene una cadena
		//Esto esta muy bien pero es poco util. No queremos un Stream de chars sino un Stream de Strings
		
		String texto2 = "nombre:pedro,nombre:gema,nombre:ana";
		Stream<String> bloques = Pattern.compile(",").splitAsStream(texto2);
		bloques.map(cadena -> cadena.substring(7, cadena.length())).forEach(System.out::println);
	}

}
