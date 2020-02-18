package dev.parresoft9.hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PermutaThread extends Thread {

	private static List<String> resultSinRepe = new ArrayList<String>();

	List<String> pizzasHilo;
	int numElements;
	String optimunValue;
	Map<Integer, Boolean> mapExist;

	public PermutaThread(List<String> pizzasHilo, int numElements, String optimunValue,
			Map<Integer, Boolean> mapExist) {
		super();
		this.pizzasHilo = pizzasHilo;
		this.numElements = numElements;
		this.optimunValue = optimunValue;
		this.mapExist = mapExist;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Perm2(pizzasHilo, "", numElements, pizzasHilo.size());

	}

	private void Perm2(List<String> elem, String act, int n, int r) {
		if (n == 0) {
			String sortResult = Utils.sortString(act);
			if (!resultSinRepe.contains(sortResult)) {
				System.out.println(act);
				if (suma(act) == Integer.parseInt(optimunValue)) {
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
				if (!act.contains(elem.get(i))) { // Controla que no haya repeticiones pero tiene en cuenta que en el
													// array haya dos valores o tres iguales.
					actualizaCredit(i);
					Perm2(elem, act + elem.get(i) + ", ", n - 1, r);

				} else if (this.mapExist.get(i)) {
					actualizaCredit(i);
					Perm2(elem, act + elem.get(i) + ", ", n - 1, r);

				}
			}
		}
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

	public boolean haveCredit(int i) {
		return this.mapExist.get(i);
	}

	public void actualizaCredit(int indice) {
		this.mapExist.put(indice, false);
	}

}
