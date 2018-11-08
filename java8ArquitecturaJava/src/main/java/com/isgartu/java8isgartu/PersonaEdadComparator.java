package com.isgartu.java8isgartu;

import java.util.Comparator;

import com.isgartu.java8isgartu.utils.Persona3;

public class PersonaEdadComparator implements Comparator<Persona3>{

	@Override
	public int compare(Persona3 o1, Persona3 o2) {
		// TODO Auto-generated method stub
		return o1.getEdad()>o2.getEdad() ? 1:-1;
	}

}
