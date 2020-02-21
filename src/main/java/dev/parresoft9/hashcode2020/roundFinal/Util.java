package dev.parresoft9.hashcode2020.roundFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {
	
	public static Input makeInput(String nameFile) {

		Input input = new Input();
		List<Library> libraries = new ArrayList<Library>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(nameFile));

			String line = reader.readLine();
			String firstLine[] = line.trim().split(" ");
			input.setB(Integer.parseInt(firstLine[0]));
			input.setL(Integer.parseInt(firstLine[1]));
			input.setD(Integer.parseInt(firstLine[2]));

			System.out.println(line);

			line = reader.readLine();
			System.out.println(line);
			String scoreLine[] = line.trim().split(" ");
			int[] score = new int[scoreLine.length];
			for (int i = 0; i < scoreLine.length; i++) {
				score[i] = Integer.parseInt(scoreLine[i]);
			}
			input.setScore(score);

			String lineLibrary = reader.readLine();
			System.out.println(lineLibrary);
			
			while (lineLibrary != null && lineLibrary != "") {

				Library library = new Library();
				String libraryLine[] = lineLibrary.trim().split(" ");
				library.setN(Integer.parseInt(libraryLine[0]));
				library.setTimeRegister(Integer.parseInt(libraryLine[1]));
				library.setSendPerDay(Integer.parseInt(libraryLine[2]));

				lineLibrary = reader.readLine();
				System.out.println(lineLibrary);
				String booksLine[] = lineLibrary.trim().split(" ");
				int booksLibrary[] = new int[booksLine.length];
				for (int b = 0; b < booksLine.length; b++) {
					booksLibrary[b] = Integer.parseInt(booksLine[b]);
				}
				library.setBooks(booksLibrary);
				libraries.add(library);

				lineLibrary = reader.readLine();
				
			}

			input.setLibraries(libraries);
			System.out.println(lineLibrary);

			reader.close();
		} catch (

		IOException e) {
			e.printStackTrace();
		}

		return input;

	}

}
