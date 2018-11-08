package com.isgartu.java8isgartu.utils;

public interface Plegable {

	public default void plegar() {
		System.out.println("el mueble se pliega");
	}
}
