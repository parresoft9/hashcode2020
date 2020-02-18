package dev.parresoft9.hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

	static Logger LOG = LoggerFactory.getLogger(Utils.class);

	public static void estadisticas(List<String> pizzas) {
		LOG.error("Hola estamos arrancando la primera aplicacion sobre guión");

		double nF = factorial(pizzas.size());
		for (int i = 1; i <= pizzas.size(); i++) {
			double nkF = factorial(pizzas.size() - i);
			LOG.info("Existen " + nF / (nkF * factorial(i)) + " grupos de " + i + " elementos.");
		}

	}

	public static double factorial(double n) {
		return (n == 0) ? 1 : n * factorial(n - 1);
	}

	public static Map<Integer, Boolean> getMapExistences(List<String> pizzas) {
		Map<Integer, Boolean> result = new HashMap<Integer, Boolean>();
		for (int i = 0; i < pizzas.size(); i++) {
			result.put(i, true);
		}
		return result;
	}
	
	public static Map<String, Integer> getMapOcurrencies(List<String> pizzas) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (int i = 0; i < pizzas.size(); i++) {
			int ocurrencies = 0;
			for (int b = 0; b < pizzas.size(); b++) {
				if ((pizzas.get(i)).equals(pizzas.get(b))) {
					ocurrencies = ocurrencies +1;
				}
			}
			result.put(pizzas.get(i), ocurrencies);
		}
		return result;
	}
	
	public static List<String> getListRepes (Map<String, Integer> mapOcurrencies){
		List<String> result = new ArrayList<String>();
		for (String key: mapOcurrencies.keySet()) {
			if (mapOcurrencies.get(key)>1) {
				result.add(key);
			}
		}
		return result; 
			
		
	}
	
	public static String sortString(String inputString) {
		// convert input string to char array
		char tempArray[] = inputString.toCharArray();

		// sort tempArray
		Arrays.sort(tempArray);

		// return new sorted string
		return new String(tempArray);
	}

}
