package Practica1.ejercicio8;


public class DoubleEndedQueue<T> extends Queue<T>{
	public void enqueueFirst(T datito) {
		super.data.add(0,datito);
	}
}
