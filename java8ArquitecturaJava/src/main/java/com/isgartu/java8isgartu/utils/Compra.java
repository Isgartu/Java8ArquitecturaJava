package com.isgartu.java8isgartu.utils;

public class Compra {

	private int id;
	private double importe;

	public Compra(int id, double importe) {
		super();
		this.id = id;
		this.importe = importe;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
	//Agregamos un metodo que nos calcule el IVA
	public double getImporteIVA() {
		return this.importe * 1.21;
	}
	
	//Agregamos el metodo para que quede de forma mas natural
	public static boolean esCaro(Compra c) {
		if(c.getImporteIVA() > 150) {
			return true;
		} else {
			return false;
		}
	}

}
