package dev.parresoft9.hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hashcode2020Application implements CommandLineRunner {
	
	private static List<String> resultSinRepe = new ArrayList<String>();

	Logger LOG = LoggerFactory.getLogger(Hashcode2020Application.class);

	@Value("#{'${pizzas}'.split(' ')}")
	private List<String> pizzas;

	@Value("#{'${optimunValue}'}")
	private String optimunValue;

	public static void main(String[] args) {
		SpringApplication.run(Hashcode2020Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Utils.estadisticas(pizzas);
		Map<String, Integer> ocurrencyMap = Utils.getMapOcurrencies(pizzas);

		for (int i = 1; i <= pizzas.size(); i++) {
			int n = i; // Tipos para escoger
			Perm1Thread hilo = new Perm1Thread(pizzas, n, optimunValue, ocurrencyMap);
			hilo.run();
			System.out.println("LANZADO HILO: " + n);
		}
		
		System.out.println("FIN ^^^^^^^^^^^^^^^^^");
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

	

}
