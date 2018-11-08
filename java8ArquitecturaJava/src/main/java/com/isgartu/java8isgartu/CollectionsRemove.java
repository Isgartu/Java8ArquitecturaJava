package com.isgartu.java8isgartu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.isgartu.java8isgartu.utils.Libro;

/**
 * https://www.arquitecturajava.com/java-collections-remove-con-java-8/
 */
public class CollectionsRemove {

	public static void main(String[] args) {

		Libro l1 = new Libro("java", 500, "programacion");
		Libro l2 = new Libro("angular", 300, "web");
		Libro l3 = new Libro("react", 350, "web");
		
		List<Libro> libros = new ArrayList();
		libros.add(l1);
		libros.add(l2);
		libros.add(l3);
		
		//Eliminamos el primer libro pasando un objeto
		libros.remove(l1);
		//Eliminamos el segundo libro por posicion
		libros.remove(0);
		//Eliminamos el tercer libro con removeAll
		libros.removeAll(Arrays.asList(l3));
		
		System.out.println(libros);

		
		//Si queremos eliminar un subconjunto de elemetos aplicando una condicion
		//hasta ahora siempre se ha utilizado el interface iterator
		Iterator<Libro> it = libros.iterator();
		while(it.hasNext()) {
			if(it.next().getCategoria().equals("web")) {
				it.remove();
			}
		}
		
		//Ahora se puede mejorar utilizando removeIf con lambda
		libros.removeIf(l -> l.getCategoria().equals("web"));
	}

}
