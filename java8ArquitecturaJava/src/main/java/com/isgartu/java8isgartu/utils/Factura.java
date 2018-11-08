package com.isgartu.java8isgartu.utils;

public class Factura {

	private int numero;
	private double importe;

	public Factura(int numero, double importe) {
		super();
		this.numero = numero;
		this.importe = importe;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getImporte (TipoIva tipo) {
		return tipo.calcular(importe);
	}
}
