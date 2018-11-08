package com.isgartu.java8isgartu;

import java.util.Optional;

import com.isgartu.java8isgartu.utils.Persona;

/**
 * https://www.arquitecturajava.com/usando-java-8-optional/
 */
public class OptionalNullPointerException {

	public static void main(String[] args) {
		//Con optional eliminamos muchos de los problemas de excepciones de tipo NullPointerException
		
		ServicioPersonas sp = new ServicioPersonas();

		//En la primera opcion, utilizamos un bucle forEach para buscar una Persona que coincide con el nombre
		Persona p = sp.buscar("angel");
		System.out.println(p.getNombre());
		
		//El programa funciona perfecto, el problema es que si en vez de angel le pasamos "gema" u otro
		//nombre no existente lanzara la excepcion: NullPointerException
		
		//Haciendo uso de Optional:
		Optional<Persona> op = sp.buscarConOptional("gema");
		if(op.isPresent()) {
			System.out.println(op.get().getNombre());
		} else {
			System.out.println("no hay registros");
		}
		
		//Haciendo uso de Optional + Stream, evitamos utilizar el bucle for
		Optional<Persona> opstream = sp.buscarConOptionalStream("gema");
		if(opstream.isPresent()) {
			System.out.println(opstream.get().getNombre());
		} else {
			System.out.println("va a ser que no esta");
		}
	}
}
