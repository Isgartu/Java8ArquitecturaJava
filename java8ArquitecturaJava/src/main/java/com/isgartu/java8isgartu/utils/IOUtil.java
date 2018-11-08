package com.isgartu.java8isgartu.utils;

import java.io.File;
import java.io.IOException;

public class IOUtil {

	public static void crearFicheros(File fichero) {
		try {
			fichero.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
