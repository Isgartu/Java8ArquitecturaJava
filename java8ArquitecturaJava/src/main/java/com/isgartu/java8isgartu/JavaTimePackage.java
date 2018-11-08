package com.isgartu.java8isgartu;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

/**
 * https://www.arquitecturajava.com/java-time-package-y-clases-fundamentales/
 */
public class JavaTimePackage {

	public static void main(String[] args) {
		
		//Instant: define un instante concreto en una linea de tiempo y sirve habitualmente
		//para calcular los tiempos que han sucedido entre dos instantes concretos
		Instant instante = Instant.now();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Instant instante2 = Instant.now();
		System.out.println(Duration.between(instante, instante2).toMillis());
		System.out.println(Duration.between(instante, instante2).toMinutes());
		
		
		//LocalDate: esta clase se encarga de instanciar una fecha concreta en el calendario
		//con dia, mes y ano para que podamos trabajar con ella
		LocalDate dia = LocalDate.of(2016, 8, 31);
		LocalDate dia2 = LocalDate.of(2016, Month.SEPTEMBER, 30);
		Period periodo = Period.between(dia, dia2);
		System.out.println(periodo.getDays());
		
		
		//LocalDateTime: esta clase se encarga de instanciar una fecha concreta en el calendario
		//pero en este caso tambien con hora y minutos
		LocalDateTime fechaConHoraMinutos = LocalDateTime.of(2016, 8, 31, 8, 2);
		LocalDateTime nuevaFecha = fechaConHoraMinutos.plusMinutes(25);
		System.out.println(nuevaFecha.getMinute());
	}
}
