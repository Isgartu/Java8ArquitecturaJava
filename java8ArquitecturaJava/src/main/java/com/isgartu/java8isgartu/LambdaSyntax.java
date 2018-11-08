package com.isgartu.java8isgartu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.isgartu.java8isgartu.utils.Persona3;

/**
 * https://www.arquitecturajava.com/java-8-lambda-syntax/
 */
public class LambdaSyntax {

	public static void main(String[] args) {

		Persona3 personaA = new Persona3("pedro", "perez", 20);
		Persona3 personaB = new Persona3("ana", "blanco", 15);
		Persona3 personaC = new Persona3("miguel", "alvarez", 50);

		List<Persona3> lista = Arrays.asList(personaA, personaB, personaC);

		
		//De esta forma, tenemos que crear una nueva clase para hacer la comparacion de edad
		System.out.println("Llamando a una clase para la comparacion");
		lista.sort(new PersonaEdadComparator());
		for (Persona3 p : lista) {
			System.out.println(p.getNombre() + " ," + p.getEdad());
		}
		
		
		//Podemos evitar la creacion de la clase PersonaEdadComparator con una clase anonima
		System.out.println("\nSin crear la clase para la comparacion");
		lista.sort(new Comparator<Persona3>() {
			@Override
			public int compare(Persona3 o1, Persona3 o2) {
				return o1.getEdad() > o2.getEdad() ? 1 : -1;
			}
		});
		for(Persona3 p : lista) {
			System.out.println(p.getNombre() + " ," + p.getEdad());
		}
		/*
		 La Sintaxis es la siguiente:
		  
		  new	Comparador<Persona>()	{
		  		public int compare(Persona p1, Persona p2)	{
		  		return	p1.getEdad()>p2.getEdad()?1:-1;
		  		}
		  }
		 */
		
		
		//Con lambda syntax block reducimos considerablemente el codigo
		System.out.println("\nCon lambda syntax block");
		lista.sort((Persona3 p1, Persona3 p2) -> {
			return p1.getEdad() > p2.getEdad() ? 1:-1;
		});
		for(Persona3 p : lista) {
			System.out.println(p.getNombre() + " ," + p.getEdad());
		}
		/*
		 La Sintaxis es la siguiente:
		 
		  (Persona p1, Persona p2)	->	{
		  return	p1.getEdad()>p2.getEdad()?1:-1;
		  }
		 */
		
		
		//Con lambda expression se simplifica aun mas
		System.out.println("\nCon lambda expression");
		lista.sort((p1, p2) -> {return p1.getEdad() > p2.getEdad() ? 1:-1;});
		for(Persona3 p : lista) {
			System.out.println(p.getNombre() + " ," + p.getEdad());
		}
		/*
		 La Sintaxis es la siguiente:
		 
		  (p1, p2)	->	{
		  return	p1.getEdad() > p2.getEdad() ? 1 : -1;
		  }
		 */
		
		
		//Lo anterior se puede simplificar mas aun ya que el compilador es capaz de 
		//entender que al ser una unica linea se pueden eliminar los parentesis y el return
		System.out.println("\nMas compacto aun");
		lista.sort((p1, p2) -> p1.getEdad() > p2.getEdad() ? 1 : -1);
		lista.forEach(e -> System.out.println(e.getNombre() + " ," + e.getEdad()));
		/*
		 La Sintaxis es la siguiente:
		 
		  (p1, p2)	->	p1.getEdad() > p2.getEdad() ? 1 : -1;
		 */
		
	}
}
