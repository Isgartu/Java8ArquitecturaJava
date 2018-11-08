package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.isgartu.java8isgartu.utils.Persona;

public class ServicioPersonas {

	static List<Persona> lista = new ArrayList<Persona>();
	
	static {
		lista.add(new Persona("pedro"));
		lista.add(new Persona("angel"));
		lista.add(new Persona("ana"));
	}
	
	public Persona buscar(String nombre) {
		for(Persona p : lista) {
			if(p.getNombre().equals(nombre)) {
				return p;
			}
		}
		return null;
	}
	
	public Optional<Persona> buscarConOptional(String nombre) {
		for(Persona p : lista) {
			if(p.getNombre() == nombre) {
				return Optional.of(p);
			}
		}
		return Optional.empty();
	}
	
	public Optional<Persona> buscarConOptionalStream(String nombre) {
		return lista.stream().filter(p -> p.getNombre()==nombre).findFirst();
	}
}
