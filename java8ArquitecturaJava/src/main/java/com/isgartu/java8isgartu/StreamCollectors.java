package com.isgartu.java8isgartu;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.isgartu.java8isgartu.utils.Libro;

/**
 * https://www.arquitecturajava.com/java-stream-collectors-y-su-uso/
 */
public class StreamCollectors {

	public static void main(String[] args) {
		Libro l1 = new Libro("El senor de los anillos",1000);
		Libro l2 = new Libro("La fundacion", 500);
		Libro l3 = new Libro("El caliz de fuego", 600);
		
		//Acabamos de instanciar tres objetos, vamos a agregar todos
		//a un stream y recorrerlo utilizando el metodo forEach
		System.out.println("Recorremos el stream:");
		Stream<Libro> st = Stream.of(l1, l2, l3);
		st.forEach((l) -> System.out.println(l.getTitulo()));
		
		//Podemos convertir el Stream a Array
		System.out.println("\nLo convertimos a Array y obtenemos las paginas de los libros:");
		Stream<Libro> st2 = Stream.of(l1, l2, l3);
		Libro[] arrayLibro = st2.toArray(Libro[]::new);
		for (int i=0; i<arrayLibro.length; i++) {
			System.out.println(arrayLibro[i].getPaginas());
		}
		
		//Podemos convertirlo en Lista
		System.out.println("\nLo convertimos a List:");
		Stream<Libro> st3 = Stream.of(l1, l2, l3);
		List<Libro> lista = st3.collect(Collectors.toList());
		for (Libro l : lista) {
			System.out.println(l.getTitulo());
		}
		
		//O en Conjunto
		System.out.println("\nLo convertimos a Set:");
		Stream<Libro> st4 = Stream.of(l1, l2, l3);
		Set<Libro> lista2 = st4.collect(Collectors.toSet());
		for(Libro l : lista2) {
			System.out.println(l.getTitulo());
		}
		
		//Podemos hacer que todos los titulos se impriman en una unica linea
		System.out.println("\nTodos los titulos en una linea:");
		Stream<Libro> st5 = Stream.of(l1, l2, l3);
		String resultado = st5.map((l) -> l.getTitulo()).collect(Collectors.joining(","));
		System.out.println(resultado);
		
		//Tambien podemos sumar todas las paginas de los libros
		System.out.println("\nNumero de paginas de todos los libros:");
		Stream<Libro> st6 = Stream.of(l1, l2, l3);
		Optional<Integer> resultado3 = st6.map((l) -> l.getPaginas()).collect(Collectors.reducing(Integer::sum));
		System.out.println(resultado3.get());
	}
}
