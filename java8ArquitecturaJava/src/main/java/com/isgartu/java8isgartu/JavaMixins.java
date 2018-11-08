package com.isgartu.java8isgartu;

import com.isgartu.java8isgartu.utils.Mesa;

/**
 * https://www.arquitecturajava.com/java-mixins-un-ejemplo-sencillo/
 */
public class JavaMixins {

	public static void main(String[] args) {
		/*Tanto Armario como Mesa como Silla heredan de Mueble
		  pero si queremos anadir la funcionalidad de plegar, armario no debe llevarla.
		  Para este cometido lo podemos solucionar con Java Mixins:
		  Creamos una interfaz con default methods de plegar y hacemos que nuestras clases
		  interesadas implementen el interface
		 */
		
		Mesa m = new Mesa();
		m.plegar();
	}
}
