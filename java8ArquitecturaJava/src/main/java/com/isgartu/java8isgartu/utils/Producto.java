package com.isgartu.java8isgartu.utils;

import java.util.List;

public interface Producto {
	public int getPrecio();
	
	//Agregamos un metodo estatico
	public static int importeTotal(List<Producto> listaProductos) {
		return listaProductos.stream().mapToInt((p) -> p.getPrecio()).sum();
	}

	
}
