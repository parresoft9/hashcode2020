package dev.parresoft9.hashcode2020.roundFinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Procesador {

	private static int maximun = 0;

	public static void procesar(Input input) {

		maximun = obtenerMaxAlcanzable(input.getScore());
		Map<Integer, List<Integer>> librosLibreria = obtenerMapLibros(input.getB(), input.getLibraries());
		Map<Integer, List<Integer>> librosRepetidos = obtenerMapLibrosRepetidos(librosLibreria);
	}

	private static int obtenerMaxAlcanzable(int[] scores) {
		int result = 0;
		for (int s : scores) {
			result += s;
		}
		return result;
	}

	private static Map<Integer, List<Integer>> obtenerMapLibros(int B, List<Library> libraries) {
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < B; i++) {
			System.out.print(i);
			ArrayList<Integer> libraryForBook = new ArrayList<Integer>();
			for (int l = 0; l < libraries.size(); l++) {
				System.out.print(l);
				for (int b : libraries.get(l).getBooks()) {
					if (b == i) {
						libraryForBook.add(l);
					}
				}
			}
			result.put(i, libraryForBook);
		}
		return result;
	}

	private static Map<Integer, List<Integer>> obtenerMapLibrosRepetidos(Map<Integer, List<Integer>> librosLibreria) {
		Map<Integer, List<Integer>> result = new HashMap<Integer, List<Integer>>();
		for (int key : librosLibreria.keySet()) {
			if (librosLibreria.get(key).size() > 1) {
				result.put(key, librosLibreria.get(key));
			}
		}
		return result;

	}

}
