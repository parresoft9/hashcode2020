package dev.parresoft9.hashcode2020.roundFinal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

	

	public static Input doInput(String nameFile) {

		Input input = new Input();

		try {
			File file = new File(nameFile);
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line); // appends line to string buffer
				sb.append("\n"); // line feed
			}
			fr.close(); // closes the stream and release the resources
			System.out.println("Contents of File: ");
			System.out.println(sb.toString());// returns a string that textually represents the object

			String lines[] = sb.toString().split("\n");

			String firstLine[] = lines[0].split(" ");
			input.setB(Integer.parseInt(firstLine[0]));
			input.setL(Integer.parseInt(firstLine[1]));
			input.setD(Integer.parseInt(firstLine[2]));

			String scoreLine[] = lines[1].split(" ");
			int[] score = new int[scoreLine.length];
			for (int i = 0; i < scoreLine.length; i++) {
				score[i] = Integer.parseInt(scoreLine[i]);
			}
			input.setScore(score);

			List<Library> listLibrary = new ArrayList<Library>();
			for (int l = 1; l <= input.getL(); l++) {
				Library library = new Library();
				library.setId(l-1);
				String lib[] = lines[2 * l].split(" ");
				library.setN(Integer.parseInt(lib[0]));
				library.setTimeRegister(Integer.parseInt(lib[1]));
				library.setSendPerDay(Integer.parseInt(lib[2]));

				String boo[] = lines[2 * l + 1].split(" ");
				List<Book> booksLibrary = new ArrayList<Book>();
				for (int b = 0; b < boo.length; b++) {
					Book buk = new Book();
					int x = Integer.parseInt(boo[b]);
					buk.setId(x);
					buk.setPoints(score[x]);
					booksLibrary.add(buk);
				}
				library.setBooks(booksLibrary);
				listLibrary.add(library);
			}
			input.setLibraries(listLibrary);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;

	}

}
