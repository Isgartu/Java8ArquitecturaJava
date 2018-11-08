package com.isgartu.java8isgartu;

import com.isgartu.java8isgartu.utils.TriAtleta;

/**
 * https://www.arquitecturajava.com/java-multiple-inheritance-con-default-methods/
 */
public class MultipleInheritanceDefaultMethods {

	public static void main(String[] args) {
		TriAtleta t = new TriAtleta();
		t.correr();
		t.nadar();
		t.haceBici();
		
		//Con esto implementamos una solucion de herencia multiple basada en el manejo de interfaces
	}
}
