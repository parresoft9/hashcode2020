package dev.parresoft9.hashcode2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hashcode2020Application implements CommandLineRunner {

	@Value("#{'${pizzas}'.split(' ')}")
	private List<String> pizzas;

	@Value("#{'${optimunValue}'}")
	private String optimunValue;

	public static void main(String[] args) {
		SpringApplication.run(Hashcode2020Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Map<Integer, List<Integer>> resultInter = orderer(pizzas, optimunValue);

		int maximun = Collections.max(resultInter.keySet());
		System.out.println("\n\n Maximo: " + maximun);
		List<Integer> combinacion = resultInter.get(maximun);
		for (int a : combinacion) {
			System.out.print(a + ",");
		}
		System.out.println("\n\n                      FIN ^^^^^^^^^^^^^^^^^");
		printSolution(combinacion, pizzas);

//		Utils.estadisticas(pizzas);
//		Map<String, Integer> ocurrencyMap = Utils.getMapOcurrencies(pizzas);
//		for (int i = 1; i <= pizzas.size(); i++) {
//			int n = i; // Tipos para escoger
//			Perm1Thread hilo = new Perm1Thread(pizzas, n, optimunValue, ocurrencyMap);
//			hilo.run();
//			System.out.println("LANZADO HILO: " + n);
//		}		
	}

//		System.out.println("^^^^^^^^^^^^^^^^^^^^^START");
//
//		Utils.estadisticas(pizzas);
//		Map<Integer, Boolean> mapExist = Utils.getMapExistences(pizzas);
//		
////		for (int i = pizzas.size(); i >= 1; i--) {
////			int n = i; // Tipos para escoger
////			PermutaThread hilo = new PermutaThread(pizzas, n, optimunValue, mapExist);
////			// run secuencial no hilos, start multihilo
////			hilo.run();
////			System.out.println("LANZADO HILO: " + n);
////		}
//
//		System.out.println("FIN ^^^^^^^^^^^^^^^^^");
//
//	}

	public Map<Integer, List<Integer>> orderer(List<String> types, String optimunValue) {

		List<Integer> tipos = types.stream().map(Integer::parseInt).collect(Collectors.toList());
		Collections.sort(tipos, Collections.reverseOrder());

		Map<Integer, List<Integer>> resultInter = new HashMap<Integer, List<Integer>>();
		Map<Integer, List<Integer>> tratamientoSpecial = new HashMap<Integer, List<Integer>>();

		int finalSum = Integer.parseInt(optimunValue);
		List<Integer> comb = new ArrayList<Integer>();
		List<Integer> numbersProblem = new ArrayList<Integer>();



		for (int i = 0; i < tipos.size(); i++) {
			int backup = tipos.get(i);

			comb = new ArrayList<Integer>();
			numbersProblem = new ArrayList<Integer>();
			comb.add(tipos.get(i));
			int suma = tipos.get(i);
			int s = 0;
			while (s < tipos.size()) {
				if (s != i) {
					suma = suma + tipos.get(s);
					if (suma == finalSum) {
						comb.add(tipos.get(s));
						System.out.println("\n\n Bingo HEMOS LLEGADO AL FINAL HAY SOLUCIÓN");
						for (Integer a : comb) {
							System.out.print(a + ",");
						}
						System.out.println("\n\n");
						printSolution(comb, types);
						System.exit(1);
					} else if (suma < finalSum && suma > backup) {
						backup = suma;
						comb.add(tipos.get(s));
					} else {
						suma = suma - tipos.get(s);
						numbersProblem.add(tipos.get(s));
					}
				}
				s++;
			}
			tratamientoSpecial.put(tipos.get(i), numbersProblem);
			if (suma < finalSum && suma > getMax(resultInter)) {
				// TODO metodo para ver que hacer con las combinaciones intermedias
				m(tipos, i, tratamientoSpecial);
				resultInter.put(suma, comb);
			}

		}

		return resultInter;

	}

	private int getMax(Map<Integer, List<Integer>> resultInter) {
		return resultInter.isEmpty() ? 0 : Collections.max(resultInter.keySet());
	}

	private int m(List<Integer> g, int i, Map<Integer, List<Integer>> b) {
		int suma = 0;
		if (!b.isEmpty()) {
			List<Integer> numbersProblem = b.get(g.get(i));
			System.out.print(g.get(i) + "==========>");
			for (int a : numbersProblem) {
				System.out.print(a + ",");
			}
			System.out.println("\n");
		}

		return suma;

	}

	private void printSolution(List<Integer> combinacion, List<String> types) {

		Collections.sort(combinacion);
		System.out.println(combinacion.size());
		for (int i = 0; i < types.size(); i++) {
			if (combinacion.contains(Integer.parseInt(types.get(i)))) {
				System.out.print(i + " ");
			}
		}

	}

}
