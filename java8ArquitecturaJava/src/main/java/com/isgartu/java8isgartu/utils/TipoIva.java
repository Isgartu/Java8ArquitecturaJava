package com.isgartu.java8isgartu.utils;

public interface TipoIva {
	public double calcular(double importe);
	
	//Estos metodos estaticos se agregan para eliminar parte de las clases
	public static double IVANormal(double importe) {
		return importe * 1.21;
	}
	
	public static double IVAReducido(double importe) {
		return importe * 1.07;
	}
}
