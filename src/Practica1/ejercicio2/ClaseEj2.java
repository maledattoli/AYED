package Practica1.ejercicio2;

public class ClaseEj2 {
	public static int[] crearArreglo(int n) {
		int[]arreglo = new int[n+1];
		for (int i=0; i<n; i++) {
			arreglo[i] = (i+1)*n;
		}
		return arreglo;
	}
}
