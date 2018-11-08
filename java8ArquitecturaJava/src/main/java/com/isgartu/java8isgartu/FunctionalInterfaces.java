package com.isgartu.java8isgartu;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.isgartu.java8isgartu.utils.Persona2;

/**
 * https://www.arquitecturajava.com/java-8-functional-interfaces-y-sus-tipos/
 */
public class FunctionalInterfaces {

	public static void main(String[] args) {
		
		//Java8 Stream con setencia forEach() - Recibe una funcion consumidora que tiene el parametro x e imprime los valores
		List<String> lista = Arrays.asList("hola", "que", "tal");
		lista.stream().forEach((x) -> System.out.println(x)); 
		
		
		//Java8 Functions - Recibe uno o mas parametros y retorna un resultado
		//El ejemplo es con el metodo map que recibe como parametro un tipo Function
		List<String> lista2 = Arrays.asList("hola", "que", "tal");
		lista2.stream().map((x) -> x.toUpperCase()).forEach((x) -> System.out.println(x));
		
		
		//Java8 Suppliers - Funcion que no recibe parametro y devuelve un resultado
		//El ejemplo el metodo generate de Stream recibe un Supplier, usamos un metodo de referencia e invocamos al contructor
		//de la clase Persona2 que es un constructor vacio y devuelve un objeto nuevo
		//Nota: para poder hacer el generate(Persona2::new) es necesario que la clase no tenga un constructor sobrecargado
		List<Persona2> lista3 = Stream.generate(Persona2::new)
				.limit(100)
				.peek((p) -> p.setNombre("pepe"))
				.collect(Collectors.toList());
		//Esto solo es para recorrer la lista e imprimirla
		for(Persona2 p : lista3) {
			System.out.println(p.getNombre());
		}
		
		
		//Java8 Predicates - Especializacion de los Functions, reciben un parametro y devuelven un valor booleano
		//Se usa mucho en los filtrados
		List<Integer> lista4 = Arrays.asList(1,3,4,5,6,7,1,2);
		lista4.stream().filter((x) -> x>5).forEach(System.out::println);
		
		
		//Java8 Operators - Especializacion de los Functions, reciben un tipo de parametro y devuelven un resultado del mismo tipo
		//Un ejemplo es el resultado que genera el metodo reduce, se encarga de agrupar un conjunto de elementos del mismo tipo
		List<String> lista5 = Arrays.asList("hola", "que", "tal");
		Optional<String> resultado = lista5.stream().reduce(String::concat);
		if(resultado.isPresent()) { System.out.println(resultado.get());}
	}
}
