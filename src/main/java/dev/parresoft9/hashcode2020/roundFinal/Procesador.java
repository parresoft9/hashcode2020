package dev.parresoft9.hashcode2020.roundFinal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Procesador {

	public static void processWithTime(Input input) {

		// 25.484.756

		System.out.println("Pocessing......... with Time..........");
		System.out.println("MAXIMUN inalcanzable: " + obtenerMaxAlcanzable(input.getScore())); // Máx nunca alcanzable,
																								// ya que consideramos
																								// que los
		// libros solo están en una libreria y ademas todas
		// están logran mandar todos los libros
		// en tiempo
		calcPointLibraries(input); // calculamos el máximo de puntos que podriamos obtener con la liberira en
									// condiciones ideales
		List<Library> initalL = orderLibrariesByPuntuation(input.getLibraries());
		Map<Integer, List<Integer>> librosLibreria = obtenerMapLibros(input.getB(), initalL);
		Map<Integer, List<Integer>> librosRepetidos = obtenerMapLibrosRepetidos(librosLibreria);
//
		quitarRepetidos(librosRepetidos, initalL);
////		calcRatio(input.getLibraries());
		List<Library> lTime = orderLibrariesByTimeSigning(initalL);
//		calcRatio(lTime);
//		
//		lTime = orderLibrariesByRatio(lTime);
		// Eliminamos los repetidos de todas las listas menos de la primera
//		quitarRepetidos(librosRepetidos, lTime);

		orderBooks(lTime);
		int tiempoWithTimeSigning = tiempoenProcesarTodo(lTime);
		calcRealPointsLibraries(input, tiempoWithTimeSigning, lTime);
		int pointsRealTimeSigning = calcRealPoints(lTime, input.getScore());
		System.out.println("PUNTUACIÖN: " + pointsRealTimeSigning);
		printSolution(lTime);

	}

	public static void processWithPoints(Input input) {

		System.out.println("Pocessing......... with Points..........");
		System.out.println("MAXIMUN inalcanzable: " + obtenerMaxAlcanzable(input.getScore())); // Máx nunca alcanzable,
																								// ya que consideramos
																								// que los
		// libros solo están en una libreria y ademas todas
		// están logran mandar todos los libros
		// en tiempo
		calcPointLibraries(input); // calculamos el máximo de puntos que podriamos obtener con la liberira en
									// condiciones ideales

		Map<Integer, List<Integer>> librosLibreria = obtenerMapLibros(input.getB(), input.getLibraries());
		Map<Integer, List<Integer>> librosRepetidos = obtenerMapLibrosRepetidos(librosLibreria);

		List<Library> lPoints = orderLibrariesByPuntuation(input.getLibraries());
		// Eliminamos los repetidos de todas las listas menos de la primera
		quitarRepetidos(librosRepetidos, lPoints);
		int tiempoWithlPoint = tiempoenProcesarTodo(lPoints);
		calcRealPointsLibraries(input, tiempoWithlPoint, lPoints);
		int pointsRealTimePoints = calcRealPoints(lPoints, input.getScore());
		System.out.println("PUNTUACIÖN: " + pointsRealTimePoints);
		printSolution(lPoints);
	}

	public static void processWithBooks(Input input) {

		System.out.println("Pocessing......... with Books..........");
		System.out.println("MAXIMUN inalcanzable: " + obtenerMaxAlcanzable(input.getScore())); // Máx nunca alcanzable,
																								// ya que consideramos
																								// que los
		// libros solo están en una libreria y ademas todas
		// están logran mandar todos los libros
		// en tiempo
		calcPointLibraries(input); // calculamos el máximo de puntos que podriamos obtener con la liberira en
									// condiciones ideales

		Map<Integer, List<Integer>> librosLibreria = obtenerMapLibros(input.getB(), input.getLibraries());
		Map<Integer, List<Integer>> librosRepetidos = obtenerMapLibrosRepetidos(librosLibreria);

		List<Library> lBooks = orderLibrariesByNumberBooks(input.getLibraries());
		// Eliminamos los repetidos de todas las listas menos de la primera
		quitarRepetidos(librosRepetidos, lBooks);
		int tiempoWithBooks = tiempoenProcesarTodo(lBooks);
		calcRealPointsLibraries(input, tiempoWithBooks, lBooks);
		int pointsRealBooks = calcRealPoints(lBooks, input.getScore());
		System.out.println("PUNTUACIÖN: " + pointsRealBooks);
		printSolution(lBooks);
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
			ArrayList<Integer> libraryForBook = new ArrayList<Integer>();
			for (Library l : libraries) {
				for (Book b : l.getBooks()) {
					if (b.getId() == i) {
						libraryForBook.add(l.getId());
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

	private static void calcPointLibraries(Input input) {

		for (Library l : input.getLibraries()) {
			int points = 0;
			for (Book book : l.getBooks()) {
				points = points + book.getPoints();
			}
			l.setPuntuacion(points);
		}

	}

	private static void calcRealPointsLibraries(Input input, int timeToAll, List<Library> libraries) {

		int limitTime = input.getD();

		if (timeToAll <= limitTime) {
			for (Library l : libraries) {
				int points = 0;
				for (Book book : l.getBooks()) {
					points = points + book.getPoints();
				}
				l.setRealPoints(points);
			}
		} else {
			for (int l = 0; l < libraries.size(); l++) {
				int waitTime = 0;
				for (int r = 0; r < l; r++) {
					waitTime = waitTime + libraries.get(r).getTimeRegister();
				}
				waitTime = waitTime + libraries.get(l).getTimeRegister();
				int howManyBooks = (limitTime - waitTime) * libraries.get(l).getSendPerDay();
				if (howManyBooks >= libraries.get(l).getBooks().size()) {
					howManyBooks = libraries.get(l).getBooks().size();
				}
				libraries.get(l).setNumberBookReal(howManyBooks);
				int pointL = 0;
				for (int b = 0; b < howManyBooks; b++) {
					pointL = pointL + libraries.get(l).getBooks().get(b).getPoints();
				}
				libraries.get(l).setRealPoints(pointL);
			}
		}

	}

	private static int calcRealPoints(List<Library> ls, int score[]) {

		int result = 0;
		for (Library l : ls) {
			result = result + l.getRealPoints();
		}
		return result;

	}

	private static List<Library> orderLibrariesByTimeSigning(List<Library> libraries) {
		List<Library> result = new ArrayList<Library>(libraries);
		result.sort(Comparator.comparing(Library::getTimeRegister));
		return result;

	}

	private static List<Library> orderLibrariesByRatio(List<Library> libraries) {
		List<Library> result = new ArrayList<Library>(libraries);
		result.sort(Comparator.comparing(Library::getRatio).reversed());
		return result;

	}

	private static List<Library> orderLibrariesByPuntuation(List<Library> libraries) {
		List<Library> result = new ArrayList<Library>(libraries);
		result.sort(Comparator.comparing(Library::getPuntuacion));
		return result;

	}

	private static List<Library> orderLibrariesByNumberBooks(List<Library> libraries) {
		List<Library> result = new ArrayList<Library>(libraries);
		result.sort(Comparator.comparing(Library::getN).reversed());
		return result;

	}

	private static List<Library> orderLibrariesBySendBook(List<Library> libraries) {
		List<Library> result = new ArrayList<Library>(libraries);
		result.sort(Comparator.comparing(Library::getSendPerDay).reversed());
		return result;

	}

	private static int tiempoenProcesarTodo(List<Library> libraries) {
		int result = 0;

		for (int l = 0; l < libraries.size() - 1; l++) {
			result = result + libraries.get(l).getTimeRegister();
		}
		Library lastLibrary = libraries.get(libraries.size() - 1);
		return result + lastLibrary.getTimeRegister() + Math.round(lastLibrary.getN() / lastLibrary.getSendPerDay());

	}

	private static void quitarRepetidos(Map<Integer, List<Integer>> librosRepetidos, List<Library> lTime) {
		for (Integer libro : librosRepetidos.keySet()) {
			for (Library libra : lTime) {
				if (libra.getId() != librosRepetidos.get(libro).get(0)) {
					libra.getBooks().remove(getBookById(libro, libra));
				}

			}
		}
		for (Library libra : lTime) {
			libra.setN(libra.getBooks().size());
		}
	}

	private static void printSolution(List<Library> libraries) {

		int totalLibraries = libraries.size();
		System.out.println(totalLibraries);
		for (Library l : libraries) {
			if (l.getBooks().size() > 0) {
				System.out.println(l.getId() + " " + l.getBooks().size());
				for (Book book : l.getBooks()) {
					System.out.print(book.getId() + " ");
				}
				System.out.print("\n");
			} else {
				totalLibraries = totalLibraries - 1;
			}
		}
		System.out.println("SUSTITUYE EL PRIMER RENGLÖN POR ESTE NÜMERO: " + totalLibraries);

	}

	private static void orderBooks(List<Library> libraries) {
		for (Library l : libraries) {
			l.getBooks().sort(Comparator.comparing(Book::getPoints).reversed());
		}

	}

	private static Book getBookById(int id, Library library) {
		Book book = null;
		for (Book b : library.getBooks()) {
			if (id == b.getId()) {
				return b;
			}
		}
		return book;

	}

	private static void calcRatio(List<Library> libraries) {

		for (Library l : libraries) {
			int points = 0;
			for (Book b : l.getBooks()) {
				points = points + b.getPoints();
			}
			
			
			
			l.setRatio(((points / l.getTimeRegister()))); 
		}
	}

}
