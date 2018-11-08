package com.isgartu.java8isgartu;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.isgartu.java8isgartu.utils.IOUtil;
import com.isgartu.java8isgartu.utils.Persona;

/**
 * https://www.arquitecturajava.com/el-concepto-de-java-constructor-reference/ 
 */
public class ConstructorReference {

	public static void main(String[] args) {
		
		List<String> lista = Arrays.asList("pepe", "juan", "pedro");
		List<Persona> listaPersonas = lista.stream().map(Persona::new).collect(Collectors.toList());
		for(Persona p : listaPersonas) {
			System.out.println(p.getNombre());
		}
		
		/*Es dificil ver cuando usar la sintaxis Persona::new para hacer referencia a los constructores.
		  Un ejemplo que ayuda es usar un array similar para construir un grupo de ficheros apoyandonos
		  en el constructor de la clase File. No apoyaremos en la clase helper que dispone de un metodo
		  para crear un fichero */
		List<String> lista2 = Arrays.asList("pepe.txt", "juan.txt", "pedro.txt");
		lista2.stream().map(File::new).forEach(IOUtil::crearFicheros);
		
	}
}
