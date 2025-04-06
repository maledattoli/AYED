package Practica1.ejercicio5;

public class mainc {
	public static Datos d;
	public static int [ ]array = {9, 2, 7, 4, 5, 3};
	public static void calculoSinReturn() {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int prom = 0;
		for( int i =0; i<array.length;i++) {
			if(array[i]>max) max = array[i];
			if(array[i]<min) min = array[i];
			prom += array[i];	
		}
		d.setMax(max);
		d.setMin(min);
		d.setProm((int)prom/array.length);
	}
	public static void main(String[] args) {
		calculoSinReturn();
	}

}
