package dev.parresoft9.hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PermutaThread extends Thread{
	
	private static List<String> resultSinRepe = new ArrayList<String>();
	
	List<String> pizzasHilo;
	int numElements;
	String optimunValue;
	Map<String, Integer> mapOcurencias;
	

	public PermutaThread(List<String> pizzasHilo, int numElements, String optimunValue,Map<String, Integer> mapOcurencias) {
		super();
		this.pizzasHilo = pizzasHilo;
		this.numElements = numElements;
		this.optimunValue = optimunValue;
		this.mapOcurencias = mapOcurencias;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Perm2(pizzasHilo, "", numElements, pizzasHilo.size());
		
	}
	
	private  void Perm2(List<String> elem, String act, int n, int r) {
		if (n == 0) {
			String sortResult = sortString(act);
			if (!resultSinRepe.contains(sortResult)) {
				System.out.println(act);
				if (suma(act)==Integer.parseInt(optimunValue)) {
					System.out.println("================================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					System.out.println("BINGO       Suma" + optimunValue);
					System.out.println(act);
					System.exit(0);
				}
				
				resultSinRepe.add(sortResult);
			}

		} else {
			for (int i = 0; i < r; i++) {
				if (!act.contains(elem.get(i))) { // Controla que no haya repeticiones pero tiene en cuenta que en el array haya dos valores o tres iguales.
					actualizaCredit(elem.get(i));
					Perm2(elem, act + elem.get(i) + ", ", n - 1, r);
					
				} else if (haveCredit(elem.get(i))) {
					actualizaCredit(elem.get(i));
					Perm2(elem, act + elem.get(i) + ", ", n - 1, r);
					
				}
			}
		}
	}

	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();

		// sort tempArray
		Arrays.sort(tempArray);

		// return new sorted string
		return new String(tempArray);
	}
	
	public static Integer suma(String act) {
		// convert input string to char array
		String tempArray[] = act.replaceAll(" ", "").split(",");
		int suma = 0;
		for (int i=0; i<tempArray.length; i++) {
			suma = suma + Integer.parseInt(tempArray[i]);
		}

		
		return suma;
	}
	
	public boolean haveCredit(String act) {
		return this.mapOcurencias.get(act) > 0 ? true : false;
	}
	
	public void actualizaCredit(String act) {
		int credit = mapOcurencias.get(act);
		credit = credit -1;
		this.mapOcurencias.put(act,credit);
	}

}
