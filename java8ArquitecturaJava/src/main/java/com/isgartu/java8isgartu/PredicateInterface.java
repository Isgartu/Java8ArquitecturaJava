package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.isgartu.java8isgartu.utils.Persona3;


/**
 * https://www.arquitecturajava.com/java-predicate-interface-y-sus-metodos/
 */
public class PredicateInterface {

	public static void main(String[] args) {
		
		List<Persona3> lista = new ArrayList<Persona3>();
		
		Persona3 p1 = new Persona3("pepe", "perez", 20);
		Persona3 p2 = new Persona3("ana", "perez", 30);
		Persona3 p3 = new Persona3("gema", "sanchez", 40);
		Persona3 p4 = new Persona3("pedro", "gomez", 70);
		
		lista.add(p1);
		lista.add(p2);
		lista.add(p3);
		lista.add(p4);
		
		//Uno de los metodos mas utilizados es and() que permite unir dos predicados
		// y la condicion se cumple si ambos predicados son ciertos
		Predicate<Persona3> predicado1 = p -> p.getEdad()>18;
		Predicate<Persona3> predicado2 = p -> p.getEdad()<30;
		Predicate<Persona3> predicado3 = predicado1.and(predicado2);
		
		//Tambien podemos usar la clausula or() que fusiona los predicados pero hace
		//que se cumpla la condicion si uno de los dos es cierto
		Predicate<Persona3> predicado4 = p -> p.getEdad()>65;
		Predicate<Persona3> predicado5 = predicado4.or(predicado3);
		
		//Por ultimos podemos modificar el predicado y agregar una negacion de tal
		//forma que se cumpla lo contrario
		Predicate<Persona3> predicado6 = predicado4.or(predicado3).negate();
		
		//Utilizamos el predicado anterior sobre la lista
		lista.stream().filter(predicado6).forEach(p -> System.out.println(p.getNombre()));
	}
}
