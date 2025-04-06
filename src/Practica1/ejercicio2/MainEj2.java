package Practica1.ejercicio2;

import java.util.Scanner;

public class MainEj2 {

	public static void main(String[] args) {
		System.out.println("ingrese un numero ");
		Scanner s = new Scanner(System.in);
		int numero= s.nextInt();
		int []arreglo = ClaseEj2.crearArreglo(numero);
		
		for(int i=0; i<numero;i++) {
			System.out.println(arreglo[i] + "");
		}

	}

}
