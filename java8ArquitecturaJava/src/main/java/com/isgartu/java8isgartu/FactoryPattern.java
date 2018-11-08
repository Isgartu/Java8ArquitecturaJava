package com.isgartu.java8isgartu;

import com.isgartu.java8isgartu.utils.FactoriaIVA;
import com.isgartu.java8isgartu.utils.Factura;
import com.isgartu.java8isgartu.utils.GestorFacturas;
import com.isgartu.java8isgartu.utils.TipoIva;

/**
 * https://www.arquitecturajava.com/java-8-factory-pattern-y-su-implementacion/
 */
public class FactoryPattern {

	public static void main(String[] args) {
		Factura f1 = new Factura(1,200);
		Factura f2 = new Factura(1,300);
		GestorFacturas gf = new GestorFacturas();
		gf.add(f1);
		gf.add(f2);
		TipoIva tipo = FactoriaIVA.getInstance("IvaReducido");
		System.out.println(gf.importeTotal(tipo));
		
		/*
		 * Para configurar la factoria hemos necesitado bastantes clases, una por cada algoritmo que implemente el calculo del Iva
		 * 
		 *  Podemos eliminar parte de las clases. Definiendo el interface y una serie de metodos estaticos asocidados
		 *  
		 *  Falta completar "GestorFacturas"
		 */
	}

}
