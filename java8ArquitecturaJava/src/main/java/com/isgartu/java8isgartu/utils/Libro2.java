package com.isgartu.java8isgartu.utils;

public class Libro2 implements Producto {

	private String titulo;
	private int precio;

	public Libro2(String titulo, int precio) {
		super();
		this.titulo = titulo;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

}
