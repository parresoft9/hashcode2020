package dev.parresoft9.hashcode2020;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sell {

	public static void main(String[] args) {
		
		List<Library> finalLibraries = new ArrayList<Library>();
		int libraries;
		int books;
		int daysScanning;
		List<Integer> orderBooks = new ArrayList<Integer>();

		try {
			File file = new File("C:\\Users\\aparreno\\Downloads\\d_tough_choices.txt"); // creates a
																											// new file
																											// instance
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
			StringBuffer sb = new StringBuffer(); // constructs a string buffer with no characters
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line); // appends line to string buffer
				sb.append("\n"); // line feed
			}
			fr.close(); // closes the stream and release the resources
//			System.out.println("Contents of File: ");
//			System.out.println(sb.toString());// returns a string that textually represents the object

			String lines[] = sb.toString().split("\n");

			String firstLine[] = lines[0].split(" ");
			books = Integer.parseInt(firstLine[0]);
			libraries = Integer.parseInt(firstLine[1]);
			daysScanning = Integer.parseInt(firstLine[2]);
			String b[] = lines[1].split(" ");
			for (int i = 0; i < b.length; i++) {
				orderBooks.add(Integer.parseInt(b[i]));
			}
			List<Integer> listaScanningTime = new ArrayList<Integer>();
			for (int l=1; l< libraries; l++) {
				String lib[] = lines[2*l].split(" ");
				listaScanningTime.add(Integer.parseInt(lib[1]));
				
				String boo[] = lines[2*l+1].split(" ");
				ArrayList<Integer> libross = new ArrayList<Integer>();
				for (String x: boo) {
					libross.add(Integer.parseInt(x));
				}
				Library biblioteca = new Library(libross, Integer.parseInt(lib[2]), Integer.parseInt(lib[1]),0);
				finalLibraries.add(biblioteca);
				System.out.println(l-1 + " "+ libross.size());
				System.out.println(libross.toString().replace("[", "").replaceAll("]", "").replaceAll(",", ""));
			}
			Collections.sort(listaScanningTime);
			
			operativa1(finalLibraries);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void operativa1 (List<Library> finalLibraries) {
		
		for (Library l : finalLibraries) {
			
		}
		
		
		
		
		
	}
	
	

}
