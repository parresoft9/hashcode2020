package dev.parresoft9.hashcode2020.roundFinal;

public class HashCodeRoundFinal2020 {

	public static void main(String[] args) {

		String mode = "TIME";
//		String mode = "POINTS";
//		String mode = "BOOKS";

//		String name = "a_example.txt";
//		String name = "b_read_on.txt";
//		 String name = "c_incunabula.txt";
//		 String name = "d_tough_choices.txt";
		 String name = "e_so_many_books.txt";
//		 String name = "f_libraries_of_the_world.txt";

		switch (mode) {
		case "TIME":
			Procesador.processWithTime(readFile(name));
//			CuentaDeLaVieja.procesar(readFile(name));
			break;

		case "POINTS":
			Procesador.processWithPoints(readFile(name));

			break;

		case "BOOKS":
			Procesador.processWithBooks(readFile(name));
			break;

		default:
			System.out.println("FINALIZADO");
		}

		System.out.println("\n");
		System.out.println("FIN");

	}

	private static Input readFile(String nameFile) {
		System.out.println("Reading ..................... file input");
		return Util.doInput(
				"/Volumes/Macintosh HD/develop/GOOGLE/hashcode2020/src/main/resources/EXTENDEDROUND/" + nameFile);
	}

}
