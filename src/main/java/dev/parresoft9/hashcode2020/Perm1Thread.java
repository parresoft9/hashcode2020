package dev.parresoft9.hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Perm1Thread  extends Thread{
	
	private static List<String> resultSinRepe = new ArrayList<String>();
	
	List<String> pizzasHilo;
	int numElements;
	Map<String, Integer> ocurrencies;
	static String optimunValue;
	
	public Perm1Thread(List<String> pizzasHilo, int numElements, String optimunValue, Map<String, Integer> ocurrencies) {
		super();
		this.pizzasHilo = pizzasHilo;
		this.numElements = numElements;
		this.ocurrencies = ocurrencies;
		this.optimunValue = optimunValue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Perm1(pizzasHilo, "", numElements, pizzasHilo.size(), ocurrencies);

	}
	
	private static void Perm1(List<String> elem, String act, int n, int r, Map<String, Integer> ocurrencies) {
		if (n == 0) {
			String sortResult = Utils.sortString(act);
			if (checkRepes(act,sortResult, resultSinRepe, Utils.getListRepes(ocurrencies)) && isValid(act,ocurrencies)) {
				int suma = suma(act);
				System.out.println(act + "----------->" + suma);
				if (suma == Integer.parseInt(optimunValue)) {
					System.out.println(
							"================================================>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
					System.out.println("BINGO       Suma" + optimunValue);
					System.out.println(act);
					System.exit(0);
				}
				resultSinRepe.add(sortResult);
			}
			
			
		} else {
			for (int i = 0; i < r; i++) {
				Perm1(elem, act + elem.get(i) + ", ", n - 1, r,ocurrencies);
			}
		}
	}
	
	private static Boolean isValid (String act,Map<String, Integer> ocurrencies) {
		boolean result=true;
		String a[] = act.replaceAll(" ", "").split(",");
		Map<String, Integer> mapOcurrenciesResult = Utils.getMapOcurrencies(Arrays.asList(a));
		for (String key: mapOcurrenciesResult.keySet()) {
			if (mapOcurrenciesResult.get(key) > ocurrencies.get(key)) {
				result=false;
				break;
			}
		}
		return result;
	}
	private static Boolean checkRepes (String act, String sortResult, List<String>resultSinRepe, List<String> listRepes) {
		boolean result = false;
		if(!resultSinRepe.contains(sortResult)){
			return true;
		}else if (resultSinRepe.contains(sortResult) ) {
			if (containsAnyElementRepe(listRepes,act)) {
				return true;
			}
		}
		
		
		return result;
	}
	
	private static boolean containsAnyElementRepe (List<String> listRepes, String sortResult) {
		boolean result = false;
		String a[] = sortResult.replaceAll(" ", "").split(",");
		for (String v : a) {
			for (String l : listRepes) {
				if (v.equals(l)) {
					return true;
				}
			}
		}
		return result;
	}
	
	public static Integer suma(String act) {
		// convert input string to char array
		String tempArray[] = act.replaceAll(" ", "").split(",");
		int suma = 0;
		for (int i = 0; i < tempArray.length; i++) {
			suma = suma + Integer.parseInt(tempArray[i]);
		}

		return suma;
	}
	
	

}
