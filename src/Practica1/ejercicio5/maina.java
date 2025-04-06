package Practica1.ejercicio5;

public class maina{
	public static Datos calculoNormal(int [] array ) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int prom = 0;
		for( int i =0; i<array.length;i++) {
			if(array[i]>max) max = array[i];
			if(array[i]<min) min = array[i];
			prom += array[i];	
		}
		Datos datos = new Datos(min,max,(int)prom/array.length);
		return datos;
	}
	public static void main(String[] args) {
	
		int [] arreglo = {9, 2, 7, 4, 5, 3};
		
		
	}
}