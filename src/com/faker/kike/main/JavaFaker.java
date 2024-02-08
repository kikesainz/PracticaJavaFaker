package com.faker.kike.main;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import com.github.javafaker.Faker;
import com.github.javafaker.Lebowski;

public class JavaFaker {

	public static void main(String[] args) {
		boolean palabraEncontrada = false;
		Faker faker = new Faker(new Locale("es"));
		Scanner sc = new Scanner(System.in);
		System.out.println("Por favor escriba el tama�o del array que almacenar� las palabras/frases");
		int tamanoArray = sc.nextInt();
		sc.nextLine();

		String[] frases = new String[tamanoArray];
		System.out.println("================================================================");
		System.out.println("Por favor, elija la tem�tica a utilizar para rellenar el array: ");
		System.out.println("1-Nombres de cervezas.");
		System.out.println("2-Frases del Gran Lebowski.");
		System.out.println("3-Personajes de Harry Potter.");
		int eleccion = sc.nextInt();
		sc.nextLine();

		switch (eleccion) {
		case 1:
			for (int i = 0; i < frases.length; i++) {
				frases[i] = faker.beer().name();
			}
			break;
		case 2:
			Lebowski lebowski = new Lebowski(faker);
			for (int i = 0; i < frases.length; i++) {	
				frases[i] = lebowski.quote();
			}
			break;
		case 3:
			for (int i = 0; i < frases.length; i++) {
				frases[i] = faker.harryPotter().character();
			}
			break;
		}
		System.out.println("=======================================");
		
		System.out.println("Imprimiendo array de nombres/frases....");
		System.out.println("=======================================");
		for (int i = 0; i< frases.length; i++) {
			System.out.println(i + "." + frases[i]);
		}
		System.out.println("=============================================================");
		System.out.println("D�game por favor la palabra que quiere encontrar en el array");
		String palabraABuscar = sc.nextLine();
		
		for(int i = 0; i< frases.length; i++) {
			if (frases[i].contains(palabraABuscar)) {
				System.out.println("Encontrada palabra " + palabraABuscar +" en posici�n: "+ i);
				System.out.println(frases[i]);
				palabraEncontrada = true;
			}
		}
		if (!palabraEncontrada) {
			System.out.println("la palabra "+palabraABuscar + " no se encuentra en el array.");
		}
	}

}
