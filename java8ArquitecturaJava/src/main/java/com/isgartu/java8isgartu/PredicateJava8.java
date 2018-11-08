package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.isgartu.java8isgartu.utils.Persona3;

/**
 * https://www.arquitecturajava.com/utilizando-java-8-predicate/
 */
public class PredicateJava8 {

	public static void main(String[] args) {
		
		//Un Predicado es un interface funcional que define una condicion que un objeto determinado debe cumplir
		//como puede ser: una persona mayor de 20 anos
		//Dispone de un unico metodo denominado test que recibe el objeto y comprueba si cumple la condicion
		List<Persona3> lista = new ArrayList<>();
		Persona3 p1 = new Persona3("pepe", "perez", 20);
		Persona3 p2 = new Persona3("angel", "sanchez", 30);
		Persona3 p3 = new Persona3("pepe", "blanco", 40);
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		
		//Convertimos la lista en un Stream de datos y la recorremos
		System.out.println("Lista en Stream de datos y la recorremos: ");
		lista.stream().forEach(new Consumer<Persona3>() {
			@Override
			public void accept(Persona3 t) {
				System.out.println(t.getNombre());
			}
		});
		
		//Hemos recorrido la lista, vamos a crear un Predicado que se encargue de definir una condicion
		//que permita filtrar la lista
		Predicate<Persona3> predicadoNombre = new Predicate<Persona3>() {
			@Override
			public boolean test(Persona3 p) {
				return p.getNombre().equals("pepe");
			}
		};
		
		
		//Acabamos de crear un Predicado que solo cumpliran las personas que se llamen "pepe"
		//Usamos la funcion filter a nivel de Streams para pasar este objeto Predicado y obligar 
		//a que se filtre en base a la condicioni que el Predicado define
		System.out.println("\nApellidos de personas que se llaman pepe: ");
		lista.stream().filter(predicadoNombre).forEach(p -> System.out.println(p.getApellidos()));
		
		
		//Es hora de convertir nuestro Java 8 Predicate en una expresion Lambda para ganar claridad:
		System.out.println("\nConvertido el Predicate a lambda: ");
		lista.stream()
			.filter(p -> p.getNombre().equals("pepe"))
			.forEach(p -> System.out.println(p.getApellidos()));
	}
}
