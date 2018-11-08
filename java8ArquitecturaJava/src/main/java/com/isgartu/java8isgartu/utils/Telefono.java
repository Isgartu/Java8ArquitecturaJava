package com.isgartu.java8isgartu.utils;

public class Telefono implements Producto{

	private String modelo;
	private String marca;
	private int precio;

	public Telefono(String modelo, String marca, int precio) {
		super();
		this.modelo = modelo;
		this.marca = marca;
		this.precio = precio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
