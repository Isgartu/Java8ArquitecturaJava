package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.isgartu.java8isgartu.utils.Persona;
import com.isgartu.java8isgartu.utils.Viaje;

/**
 * https://www.arquitecturajava.com/java-8-flatmap/
 */
public class FlatMap {

	public static void main(String[] args) {
		
		//Creamos una persona y le agregamos viajes
		Persona p1 = new Persona("pedro");
		Viaje v1 = new Viaje("Francia");
		Viaje v2 = new Viaje("Inglaterra");
		p1.addViaje(v1);
		p1.addViaje(v2);
		
		//Creamos otra persona y le agregamos viajes
		Persona p2 = new Persona("Gema");
		Viaje v3 = new Viaje("Italia");
		Viaje v4 = new Viaje("Belgica");
		p2.addViaje(v3);
		p2.addViaje(v4);
		
		//Creamos una lista de personas y le agregamos las personas con sus caracteristicas
		List<Persona> lista = new ArrayList<Persona>();
		lista.add(p1);
		lista.add(p2);
		
		//Listo por cada persona sus viajes, y por cada viaje de cada persona obtengo el nombre
//		for(Persona persona : lista) {
//			for(Viaje viaje : persona.getLista()) {
//				System.out.println(viaje.getPais());
//			}
//		}
		
		
		
		//Para hacerlo con Java 8 FlatMap y Streams
		
		//Asi obtenemos con stream y map el nombre de las personas - Convertimos la lista en un Stream y a traves de map() convertimos 
		//el Stream de Personas a un Stream de Strings que imprime los nombres
		lista.stream().map(persona -> persona.getNombre()).forEach(new Consumer<String>() {
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		});
		
		//Para obtener la lista de paises necesitamos usar FlatMap
		lista.stream().map(persona -> persona.getLista())
			.flatMap(viajes -> viajes.stream())
			.forEach(new Consumer<Viaje>() {
				@Override
				public void accept(Viaje arg0) {
					System.out.println(arg0.getPais());
				}
			});
		
		//Podemos optimizar lo anterior de esta forma:
		lista.stream().map(persona -> persona.getLista())
			.flatMap(viajes -> viajes.stream())
			.map(viaje -> viaje.getPais()).forEach(System.out::println);

	}

}
