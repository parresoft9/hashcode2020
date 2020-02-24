package dev.parresoft9.hashcode2020.roundFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CuentaDeLaVieja {
	
	public static void procesar (Input input) {
		List<Integer> liberiesFINALS = new ArrayList<Integer>();
		
		List<Book> booksScore = new ArrayList<Book>();
		int i = 0;
		for (int b : input.getScore()) {
			Book bo = new Book();
			bo.setId(i);
			bo.setPoints(b);
			booksScore.add(bo);
			i++;
		}
		
		booksScore.sort(Comparator.comparing(Book::getPoints).reversed());
		
		for (Book book : booksScore) {
			
		}
		
		
		
	}

}
