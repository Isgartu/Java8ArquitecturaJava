package com.isgartu.java8isgartu.utils;

public class FactoriaIVA {

//	public static TipoIva getInstance(String tipo) {
//		if(tipo.equals("IvaReducido")) {
//			return new IVAReducido();
//		} else {
//			return new IVANormal();
//		}
//	}
	
	//Podemos referencias los metodos nuevos de la interface como expresiones Lambda
	public static TipoIva getInstance(String tipo) {
		if(tipo.equals("IvaReducido")) {
			return TipoIva::IVAReducido;
		} else {
			return TipoIva::IVANormal;
		}
	}
}
