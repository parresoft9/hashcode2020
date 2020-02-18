package dev.parresoft9.hashcode2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// TODO Auto-generated method stub
		Map<String, Integer> mapOcurencias = new HashMap<String, Integer>();
		for (int i = 0; i<pizzas.size(); i++) {
			int ocurrencias =0;
			for(int b=0; b<pizzas.size(); b++) {
				if (pizzas.get(i).equals(pizzas.get(b))) {
					ocurrencias++;
				}
				
			}
			mapOcurencias.put(pizzas.get(i), ocurrencias);
			
		}
		for (int i = pizzas.size(); i >= 1; i--) {
			int n = i; // Tipos para escoger
			PermutaThread hilo = new PermutaThread(pizzas, n, optimunValue, mapOcurencias);
			hilo.start();
			System.out.println("LANZADO HILO: "+n);
		}
		System.out.println("FIN ^^^^^^^^^^^^^^^^^");

	}

	

}
