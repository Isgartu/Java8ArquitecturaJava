package com.isgartu.java8isgartu;

import java.util.stream.DoubleStream;

/**
 * https://www.arquitecturajava.com/el-concepto-de-java-infinite-stream/
 */
public class InfiniteStream {

	public static void main(String[] args) {
		
		//Los stream infinitos nos permiten realizar operaciones habituales
		//enfocandolas desde la programacion funcional
		
		//Para sumar los primeros 1000 numeros enteros en Java con for
		double total = 0;
		long t1 = System.nanoTime();
		for (int i = 0; i < 1_000; i++) {
			total = total + (i+1);
		}
		long t2 = System.nanoTime();
		
		System.out.println(total);
		System.out.println("Tiempo requerido: " + (t2-t1));
		
		
		//Con programacion funcional quedaria asi:
		long t3 = System.nanoTime();
		double resultado = DoubleStream.iterate(0, i -> i+1).limit(1_001).sum();
		long t4 = System.nanoTime();
		
		System.out.println(resultado);
		System.out.println("Timpo requerido por el stream: " + (t4-t3));
		
		
		//En una operacion basica como esta, el Stream tarda mas
		//Para aliviar el tiempo, se puede paralelizar los streams
		long t5 = System.nanoTime();
		double resultado2 = DoubleStream.iterate(0, i -> i+1).limit(1_001).parallel().sum();
		long t6 = System.nanoTime();
		
		System.out.println(resultado2);
		System.out.println("Tiempo requerido por el parallel streams: " + (t6-t5));
		
		//Sigue siendo mas lento, porque en bucles tan sencillos no se aprovecha el potencial
		//Pero para estructuras complejas de informacion 
		//(colecciones de facturas, lineas y productos...) se nota la mejora
	}
}
