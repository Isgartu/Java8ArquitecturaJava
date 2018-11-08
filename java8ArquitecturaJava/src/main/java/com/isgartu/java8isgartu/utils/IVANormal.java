package com.isgartu.java8isgartu.utils;

public class IVANormal implements TipoIva {

	@Override
	public double calcular(double importe) {
		return importe * 1.21;
	}
	

}
